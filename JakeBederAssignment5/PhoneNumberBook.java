import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PhoneNumberBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//part 1
		try {
		Path p = Paths.get("phonebook_test.txt");
		ArrayList<PhoneNumberBook> arrayRead = new ArrayList<>();
		
			BufferedReader br = Files.newBufferedReader(p);
			String line = br.readLine();
			while (line != null) {
				String a[] = line.split(", ");
				String b[] = a[0].split(" ");
				
				String number = b[0];
				String last = b[1];
				String first = a[1];
				
				
				PhoneNumberBook phoneBook =  new PhoneNumberBook(number, last, first);
				
				
				arrayRead.add(phoneBook);
				
				
				line = br.readLine();
				
	
			}
			br.close();
			
			
			//This is where the functions must be tested.
			
			//Simply put a function down and use "arrayRead" for any functions
			// that require an arraylist. Here are some examples:
			
			//Searchphonebook(arrayRead, "new");
			// The above function will output a file with the words that contain "new".
			
			ArrayList<PhoneNumberBook> hi = SelectionSort(arrayRead);
			SearchTrue(hi);	
			// The above code will run MergeSort(arrayRead) and then run SearchTrue(hi)
			// to check if MergeSort(arrayRead) properly sorted the code.
			
			//NanoTimer(arrayRead);
			// This code will check the timing of running SelectionSort and MergeSort.
			
		}
			catch (IOException e){
				System.out.println("Did not work.");
		}
		
		
		
		
	}
	
	private String phoneNumber;
	private String lastName;
	private String firstName;
	
	public PhoneNumberBook(String PhoneNumber, String LastName, String Firstname) {
		this.phoneNumber = PhoneNumber;
		this.lastName = LastName;
		this.firstName = Firstname;
	}
	
	public String toString() {
		return phoneNumber +" " + lastName +" " + firstName + "\n";
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getfirstName() {
		return firstName;
	}
	//part 2
	public static void Searchphonebook(ArrayList<PhoneNumberBook> arrayRead, String x) {
		try {
			
		
		
		int sizeAR = arrayRead.size();
		FileWriter output = new FileWriter("Output.txt");
		BufferedWriter outbuf = new BufferedWriter(output);
		
		
		for (int i = 0; i < sizeAR; i++) {
			PhoneNumberBook a = arrayRead.get(i);
			
			if (a.getlastName().contains(x) || a.getfirstName().contains(x)) {
				
				outbuf.write(a.toString());
				
			}
			
		}
		
		
		outbuf.close();
	
	} catch (IOException d){
		System.out.println("Did not work.");
	}
		
		

}
	//part 3
	public static ArrayList<PhoneNumberBook> SelectionSort(ArrayList<PhoneNumberBook>arrayRead){
		ArrayList<PhoneNumberBook> arrayReadCopy = new ArrayList<>();
		int arLen = arrayRead.size();
		
	
		for (int x = 0; x < arLen; x++) {
			arrayReadCopy.add(arrayRead.get(x));
		}
		
		
		for (int i = 0; i < arLen - 1; i++) {
			int minindex = i;
			PhoneNumberBook a = arrayReadCopy.get(minindex);
			for (int j = i+1; j <arLen; j++) {
				PhoneNumberBook b = arrayReadCopy.get(j);
				if (b.getlastName().compareTo(a.getlastName()) < 0) {
					minindex = j;
					a = arrayReadCopy.get(j);
				}
			}
			
			Collections.swap(arrayReadCopy, i, minindex);
			
			
			
		}
		System.out.println(arrayRead);
		return arrayReadCopy;
		
		
	}
	
	// part 4
	//This code was inspired by Codexpedia
	//http://www.codexpedia.com/java/java-merge-sort-implementation/
	public static ArrayList<PhoneNumberBook> MergeSort(ArrayList<PhoneNumberBook> arrayRead){
		ArrayList<PhoneNumberBook> arrayReadCopy = new ArrayList<>();
		
		int arSize = arrayRead.size();
		for (int x = 0; x < arSize; x++) {
			arrayReadCopy.add(arrayRead.get(x));
		}
		
		ArrayList<PhoneNumberBook> arrayLeft = new ArrayList<>();
		ArrayList<PhoneNumberBook> arrayRight = new ArrayList<>();
		int middle = arrayReadCopy.size() / 2;
	    if (arrayReadCopy.size() == 1) {    
	        return arrayReadCopy;
	    } else {
	        middle = arrayRead.size()/2;
	        
	        for (int i=0; i<middle; i++) {
	                arrayLeft.add(arrayReadCopy.get(i));
	        }
	        for (int i=middle; i<arrayReadCopy.size(); i++) {
                arrayRight.add(arrayReadCopy.get(i));
	        }
	        
	        arrayLeft = MergeSort(arrayLeft);
	        arrayRight = MergeSort(arrayRight);
	        Merge(arrayLeft, arrayRight, arrayReadCopy);
	    }
	    
		return arrayReadCopy;
	}
	
	public static void Merge(ArrayList<PhoneNumberBook> arrayLeft,ArrayList<PhoneNumberBook> arrayRight,ArrayList<PhoneNumberBook> arrayReadCopy) {
		int leftIndex = 0;
		int rightIndex = 0;
		int mainIndex = 0;
		while (leftIndex < arrayLeft.size() && rightIndex < arrayRight.size()) {
	        if ( (arrayLeft.get(leftIndex).getlastName().compareTo(arrayRight.get(rightIndex).getlastName())) < 0) {
	            arrayReadCopy.set(mainIndex, arrayLeft.get(leftIndex));
	            leftIndex++;
	        } else {
	           arrayReadCopy.set(mainIndex, arrayRight.get(rightIndex));
	            rightIndex++;
	        }
	        mainIndex++;
	    }
		ArrayList<PhoneNumberBook> rest;
		int restindex;
		if (leftIndex >=arrayLeft.size()) {
			rest = arrayRight;
			restindex = rightIndex;
		}else {
			rest = arrayLeft;
			restindex = leftIndex;
		}
		for (int i = restindex;i<rest.size(); i++) {
			arrayReadCopy.set(mainIndex,rest.get(i));
			mainIndex++;
		}
	}

	
	//part 5
	public static Boolean SearchTrue(ArrayList<PhoneNumberBook> arrayRead) {
		int arSize = arrayRead.size();
		for (int i = 0; i < arSize-1; i++) {
			String a = arrayRead.get(i).getlastName();
			
			for (int j = i+1; j< arSize; j++) {
				String b = arrayRead.get(j).getlastName();
				if (a.compareTo(b)>0) {
					//Prints sad face if it doesn't work
					System.out.println(":(");
					return false;
				}
				
			}
		}
		//Prints happy face if it worked
		System.out.println(":)");
		return true;
		
	}
	
	//part 6
	public static void NanoTimer(ArrayList<PhoneNumberBook> arrayRead) {
		double startSelection = System.nanoTime();
		SelectionSort(arrayRead);
		double endSelection = System.nanoTime();
		System.out.println("Selection Sort: " + (endSelection - startSelection)/1000000000);
		double startMerge = System.nanoTime();
		MergeSort(arrayRead);
		double endMerge = System.nanoTime();
		System.out.println("Merge Sort: " + (endMerge - startMerge)/1000000000);
		
	}
	

	
}
