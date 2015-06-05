package org.lu.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class PersonComparatorByAge implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		if (p1.getAge() >= p2.getAge()) {
			return 1;
		} else {
			return 0;
		}
	}
}

class TT {
	static void tt() {
		List<Person> list = new CopyOnWriteArrayList<>();
		list.add(Person.createPerson(10, Gender.MALE, "Tom"));
		list.add(Person.createPerson(20, Gender.FEMALE, "Lisa"));
		list.add(Person.createPerson(30, Gender.MALE, "Tim"));

		// Collections.sort(list, new Comparator<Person>() {
		// @Override
		// public int compare(Person o1, Person o2) {
		// return o1.getAge() - o2.getAge();
		// }
		// });

		Collections.sort(list,
				(Person p1, Person p2) -> Integer.valueOf(p1.getAge())
						.compareTo(Integer.valueOf(p2.getAge())));

		list.stream().filter(e -> e.getGender() == Gender.FEMALE)
				.forEach(e -> System.out.println(e.getName()));
	}
}

public class Person implements Comparable<Person>, Cloneable {
	private int age;
	private Gender gender;
	private String name;

	private static Person person;

	public static Person createPerson(int age, Gender gender, String name) {
		synchronized (Person.class) {
			if (person == null) {
				return new Person(age, gender, name);
			}
			return person;
		}
	}

	public static class PersonHolder {
		private static final Person thePerson = new Person();
	}

	public static Person createPerson2() {
		return PersonHolder.thePerson;
	}

	private Person() {
	}

	private Person(int age, String name) {
		this(age, null, name);
	}

	private Person(int age, Gender gender, String name) {
		this.age = age;
		this.gender = gender;
		this.name = name;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public Person setAge(int age) {
		this.age = age;
		return this;
	}

	public Person setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public int compareTo(Person p) {
		if (this.hashCode() >= p.hashCode()) {
			return 0;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) throws CloneNotSupportedException {
		TT.tt();
		Person p = new Person(30, Gender.MALE, "aaa");
		Person pp = (Person) p.clone();
		System.out.println(pp.getName() + pp.getGender());
	}

}
