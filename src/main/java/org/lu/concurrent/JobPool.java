package org.lu.concurrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

public class JobPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		List<SalaryCalculator> list = JobPool.getSalaryCalculators();

		BigDecimal sum = JobPool.calculateTotalSalary(executorService, list);

		executorService.shutdown();

		System.out.format("Total salary is %f", sum.doubleValue());
	}

	private static BigDecimal calculateTotalSalary(
			ExecutorService executorService,
			List<? extends SalaryCalculator> list) {
		List<Future<BigDecimal>> resultList = new ArrayList<>();
		for (SalaryCalculator cal : list) {
			Future<BigDecimal> future = executorService
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
			resultList.add(future);
		}
		BigDecimal sum = BigDecimal.ZERO;
		for (Future<BigDecimal> future : resultList) {
			try {
				sum = sum.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("error");
				sum = sum.add(BigDecimal.ZERO);
			}
		}
		return sum;
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
