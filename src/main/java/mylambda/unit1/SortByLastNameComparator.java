package mylambda.unit1;

import java.util.Comparator;

public class SortByLastNameComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return p1.lastName.compareTo(p2.lastName);
	}

}
