package org.lu.java8Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulateTest {

	private static class Trader {
		private final String name;
		private final String city;

		public Trader(String n, String c) {
			this.name = n;
			this.city = c;
		}

		public String getName() {
			return this.name;
		}

		public String getCity() {
			return this.city;
		}

		public String toString() {
			return "Trader:" + this.name + " in " + this.city;
		}
	}

	private static class Transaction {

		private final Trader trader;
		private final int year;
		private final int value;

		public Transaction(Trader trader, int year, int value) {
			this.trader = trader;
			this.year = year;
			this.value = value;
		}

		public Trader getTrader() {
			return this.trader;
		}

		public int getYear() {
			return this.year;
		}

		public int getValue() {
			return this.value;
		}

		public String toString() {
			return "{" + this.trader + ", " + "year: " + this.year + ", "
					+ "value:" + this.value + "}";
		}
	}

	private static List<Transaction> getTransactions() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul,
						2011, 400), new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700), new Transaction(alan, 2012,
						950));
	}

	private static class Transactions {
		private final static List<Transaction> transactions = getTransactions();
	}

	public static List<Transaction> generateTransactions() {
		return Transactions.transactions;
	}

	public static void main(String[] s) {
		// Find all transactions in the year 2011 and sort them by value (small
		// to high)
		Comparator<Transaction> c = Comparator.comparing(t -> t.getYear());
		System.out.println(generateTransactions().stream()
				.filter(t -> t.getYear() == 2011).sorted(c)
				.collect(Collectors.toList()));

		// What are all the unique cities where the traders work?
		System.out.println(generateTransactions().stream()
				.map(t -> t.getTrader().getCity()).distinct()
				.collect(Collectors.toList()));

		// Find all traders from Cambridge and sort them by name.
		c = Comparator.comparing(t -> t.getTrader().getName());
		System.out.println(generateTransactions().stream()
				.filter(t -> t.getTrader().getCity() == "Cambridge").sorted(c)
				.collect(Collectors.toList()));

		// Return a string of all traders�� names sorted alphabetically.
		System.out.println(generateTransactions().stream()
				.map(t -> t.getTrader().getName()).sorted()
				.reduce("", (s1, s2) -> s1 + " " + s2 + " "));

		// Are any traders based in Milan
		System.out.println(generateTransactions().stream()
				.filter(t -> t.getTrader().getCity() == "Milan")
				.collect(Collectors.toList()));

		// Print all transactions�� values from the traders living in Cambridge
		System.out.println(generateTransactions().stream()
				.filter(t -> t.getTrader().getCity() == "Cambridge")
				.map(Transaction::getValue).collect(Collectors.toList()));

		// What��s the highest value of all the transactions?
		generateTransactions().stream().map(Transaction::getValue)
				.reduce(Integer::max).ifPresent(i -> System.out.println(i));

		// Find the transaction with the smallest value.
		generateTransactions().stream()
				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
				.ifPresent(t -> System.out.println(t));

		generateTransactions().stream()
				.min(Comparator.comparing(Transaction::getValue))
				.ifPresent(t -> System.out.println(t));
	}
}
