package org.lu.java8Practice;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Comparator;

import org.lu.util.Gender;
import org.lu.util.Person;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SortTest {
	public static void main(String[] s) {
		Person p1 = Person.createPerson(20, Gender.MALE, "Tom");
		Person p2 = Person.createPerson(22, Gender.MALE, "Jerry");
		Set<Person> set = Sets.newHashSet(p1, p2);
		List<Person> list = Lists.newCopyOnWriteArrayList(set);

		Comparator<Person> c = Comparator.comparing(Person::getAge);
		c = Comparator.comparing((aa) -> aa.getAge());

		Collections.sort(list, (a, b) -> {
			return a.getAge() - b.getAge();
		});
	}
}
