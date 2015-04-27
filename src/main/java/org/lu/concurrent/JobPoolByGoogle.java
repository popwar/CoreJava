package org.lu.concurrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureFallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class JobPoolByGoogle {
	private static BigDecimal sum = BigDecimal.ZERO.setScale(2);

	public static void main(String[] args) {
		ListeningExecutorService executorService = MoreExecutors
				.listeningDecorator(Executors.newFixedThreadPool(3));

		List<SalaryCalculator> list = JobPoolByGoogle.getSalaryCalculators();

		List<ListenableFuture<BigDecimal>> futureList = JobPoolByGoogle
				.dispatchSalaryCalculateTask(executorService, list);

		JobPoolByGoogle.calculateTotalSalary(futureList, executorService);

		executorService.shutdown();
	}

	private static List<ListenableFuture<BigDecimal>> dispatchSalaryCalculateTask(
			ListeningExecutorService executorService,
			List<? extends SalaryCalculator> list) {

		List<ListenableFuture<BigDecimal>> futureList = new ArrayList<>();
		for (SalaryCalculator cal : list) {
			ListenableFuture<BigDecimal> futureTask = executorService
					.submit(new Callable<BigDecimal>() {
						@Override
						public BigDecimal call() throws Exception {
							BigDecimal salary = cal.calculate();
							System.out.println(Thread.currentThread()
									.toString()
									+ ", "
									+ cal.getClass().getName()
									+ ", salary = "
									+ salary);
							return cal.calculate();
						}
					});

			futureList.add(Futures.withFallback(futureTask,
					new FutureFallback<BigDecimal>() {
						@Override
						public ListenableFuture<BigDecimal> create(
								Throwable cause) throws Exception {
							return executorService
									.submit(new Callable<BigDecimal>() {
										@Override
										public BigDecimal call()
												throws Exception {
											System.out.println("error: "
													+ cause);
											return BigDecimal.ZERO;
										}
									});
						}

					}, executorService));
		}

		return futureList;
	}

	private static void calculateTotalSalary(
			List<ListenableFuture<BigDecimal>> futureList,
			ListeningExecutorService executorService) {
		ListenableFuture<List<BigDecimal>> taskBatch = Futures
				.allAsList(futureList);

		ListenableFuture<BigDecimal> total = Futures.transform(taskBatch,
				new Function<List<BigDecimal>, BigDecimal>() {
					@Override
					public BigDecimal apply(List<BigDecimal> input) {
						BigDecimal sum = BigDecimal.ZERO;
						for (BigDecimal result : input) {
							sum = sum.add(result);
						}
						return sum;
					}
				}, executorService);

		try {
			System.out.format("Total salary is %f\n",
					total.get().setScale(2, BigDecimal.ROUND_HALF_UP));
		} catch (InterruptedException | ExecutionException e) {
			System.out.format("Total salary is %f\n", 0);
		}
	}

	private static List<SalaryCalculator> getSalaryCalculators() {
		List<SalaryCalculator> list = Lists.newLinkedList();
		list.add(new ManagerSalaryCalculator());
		list.add(new DevSalaryCalculator());
		list.add(new QaSalaryCalculator());
		return list;
	}

	private interface SalaryCalculator {
		public BigDecimal calculate();
	}

	private static class ManagerSalaryCalculator implements SalaryCalculator {
		@Override
		public BigDecimal calculate() {
			return new BigDecimal(1000);
		}
	}

	private static class DevSalaryCalculator implements SalaryCalculator {
		@Override
		public BigDecimal calculate() {
			return new BigDecimal(1500);
		}
	}

	private static class QaSalaryCalculator implements SalaryCalculator {
		@Override
		public BigDecimal calculate() {
			return new BigDecimal(1 / 0);
		}
	}
}
