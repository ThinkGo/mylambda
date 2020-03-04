package mylambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExersizeJava8Lambda {
	public static <P> void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("kiran", "Chitrada", 44),
			new Person("sri", "tirumala", 40),
			new Person("Dhiren", "Chitrada", 3),
			new Person("Parin", "Chitrada", 12)
			);
		
		//1. sort list by lastname
		System.out.println("==SortByLastNameLambda==");
		Collections.sort(persons, (p1, p2) -> p1.lastName.compareTo(p2.lastName));
		printConditionally(persons, p -> true);

		System.out.println("==print only C Name Lambda==");
		//Comparator myLambda = (Person p1, Person p2) -> p1.lastName.compareTo(p2.lastName);
		
		printConditionally(persons, (p) -> p.lastName.startsWith("C"));

	}

	private static void printConditionally(List<Person> persons, Predicate<Person> fnPredicate) {
		for (Person p : persons) {
			if(fnPredicate.test(p))
			System.out.println(p);
		} 
	}
}
