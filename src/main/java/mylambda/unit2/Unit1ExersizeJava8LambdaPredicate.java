package mylambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import mylambda.unit1.*;

public class Unit1ExersizeJava8LambdaPredicate {
	public static <P> void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("kiran", "Chitrada", 44),
			new Person("sri", "tirumala", 40),
			new Person("Dhiren", "Chitrada", 3),
			new Person("Parin", "Chitrada", 12)
			);
		
		//sort list by lastname
		printConditionally(persons, p -> true);

		System.out.println("==SortByLastNameLambda==");
		Collections.sort(persons, (p1, p2) -> p1.lastName.compareTo(p2.lastName));

		System.out.println("==print only C Name Lambda==");		
		printConditionally(persons, (p) -> p.lastName.startsWith("C"));

		//printall
		printConditionally(persons, p -> true);
	}

	private static void printConditionally(List<Person> persons, Predicate<Person> predicate) {
		for (Person p : persons) {
			if(predicate.test(p))
			System.out.println(p);
		}
	}
}
