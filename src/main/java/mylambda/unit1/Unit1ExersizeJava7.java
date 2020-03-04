package mylambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Unit1ExersizeJava7 {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person("kiran", "Chitrada", 44),
			new Person("sri", "tirumala", 40),
			new Person("Dhiren", "Chitrada", 3),
			new Person("Parin", "Chitrada", 12)
			);
		
		//sort list by lastname
		printAllPersons(persons);
		
		System.out.println("SortByLastNameComparator");
		Collections.sort(persons, new SortByLastNameComparator());
		printAllPersons(persons);
		
		System.out.println("==Fileter only LastName starting with C Lambda==");
		printConditioally(persons, new Fi<Person>() {

			@Override
			public boolean function(Person o) {
				return o.lastName.startsWith("C");
			}
		});

	}
	
	private static void printConditioally(List<Person> persons, Fi<Person> myFunctionalInterface) {
		System.out.println("---------printConditioally---------------------------------");
		for (Person person : persons) {
			if(person.lastName.startsWith( "C"))
			System.out.println(person);	
		}
		
	}

	private static void printAllPersons(List<Person> persons) {
		System.out.println("---------printAllPersons---------------------------------");
		for (Person aPerson : persons)  System.out.println(aPerson);	
	}
	

}

interface Fi<T>  {
	public boolean function(Person p);
}

