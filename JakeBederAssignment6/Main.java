
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		System.out.println(intSet);
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		System.out.println(stringSet);
		OccurrenceSet<Boolean> boolSet = new OccurrenceSet<Boolean>();
		boolSet.add(true);
		boolSet.add(true);
		boolSet.add(true);
		boolSet.add(false);
		System.out.println(boolSet);
		OccurrenceSet<String> stringSet2 = new OccurrenceSet<String>();
		stringSet2.add("hi");
		stringSet2.add(":)");
		stringSet2.add(":)");
		System.out.println(stringSet2);
		OccurrenceSet<Integer> intSet2 = new OccurrenceSet<Integer>();
		intSet2.add(10);
		intSet2.add(10);
		intSet2.add(10);
		intSet2.add(2);
		intSet2.add(2);
		intSet2.add(6);
		System.out.println(intSet2);
		
	}
	
	
	
}
