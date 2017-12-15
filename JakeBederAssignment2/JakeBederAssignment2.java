import java.util.*;
public class JakeBederAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//part 1
		
		Scanner scanner_1 = new Scanner(System.in);
		int ArrLength = 0;
		while (ArrLength < 1) {
			System.out.println("Enter an Positive Integer Array:");
			ArrLength = scanner_1.nextInt();
		}
		
			
			
		
		
		double DoubPres = 2.0;
		while (DoubPres < 0.0  || DoubPres > 1.0)  {
			System.out.println("Enter a 'Double Precision' Array Density in the range of [0.0 - 1.0]:");
			DoubPres = scanner_1.nextDouble();
		}
		

		
		int[] Array = DenseArray(ArrLength, DoubPres);
		DenseToSparse(Array);
		
		ArrayList<int[]> ArrList = SparseArray(ArrLength, DoubPres);
		SparseToDense(ArrList, ArrLength);
		
		MaxOfDense(Array);
		MaxOfSparse(ArrList);
		
		
		//Longer array lengths result in longer response times
		//Sparse arrays are much quicker than dense arrays
		
		
		
	scanner_1.close();
	}
	
	//part 2
	public static int[] DenseArray(int ArrLength, double DoubPres) {
		double start = System.nanoTime();
		int[] Array = new int [ArrLength];
		for (int i =0; i < ArrLength;i++) {
			Random Rand = new Random();
			double DoubRand = Rand.nextDouble();
			
			if (DoubRand > DoubPres) {
				Array[i] = 0;
			}
			else {
				Array[i] = Rand.nextInt(1000000) + 1;
			}
		}
		double end = System.nanoTime();
		double total = ((end - start)/ 1000000);
		System.out.println("create dense length: "+ ArrLength + " time: " + total);
		return Array;
		}
	
	// part 3
	public static ArrayList<int[]> SparseArray (int ArrLength, double DoubPres) {
		double start = System.nanoTime();
		ArrayList<int[]> ArrList = new ArrayList<int[]>(ArrLength);
		for (int i =0; i < ArrLength;i++) {
			Random Rand = new Random();
			double DoubRand = Rand.nextDouble();
			
			if (DoubRand < DoubPres) {
				int[] arrayV2 = new int[2];
				arrayV2[0] = i;
				arrayV2[1] = Rand.nextInt(1000000) + 1;
				ArrList.add(arrayV2);
				
			}
			
			
		}
		int ArrListLength = ArrList.size();
		double end = System.nanoTime();
		double total = ((end - start)/ 1000000);
		System.out.println("create sparse length: " + ArrListLength + " time: " + total);
		return ArrList;
		}
	
	// part 4
	public static ArrayList<int[]>DenseToSparse(int[] Array) {
		double start = System.nanoTime();
		int DenseArrLength = Array.length;
		ArrayList<int[]> SparseArr = new ArrayList<int[]>(DenseArrLength);
		for (int x = 0; x < DenseArrLength; x++)
			if (Array[x] > 0) {
				int[] SparseArrV2 = new int[2];
				SparseArrV2[0] = x;
				SparseArrV2[1] = Array[x];
				SparseArr.add(SparseArrV2);
			}
		int SparseLength = SparseArr.size();
		double end = System.nanoTime();
		double total = (end - start)/ 1000000;
		System.out.println("convert to sparse length: " + SparseLength + " time: " +total);
	
	return SparseArr;
	}
	
	// part 5
	public static int[]SparseToDense(ArrayList<int[]>ArrList, int ArrLength){
		double start = System.nanoTime();
		int [] NewDenseArray = new int[ArrLength];
		int SparseArrLength = ArrList.size();
		for (int i = 0; i < ArrLength; i++) NewDenseArray[i] = 0;
		
		for (int j = 0; j < SparseArrLength;j++) {
			int index = ArrList.get(j)[0];
			int value = ArrList.get(j)[1];
			NewDenseArray[index] = value;
		}
		int NewDenseArrayLength = NewDenseArray.length;
		double end = System.nanoTime();
		double total = (end - start)/ 1000000;
		System.out.println("convert to dense length: " + NewDenseArrayLength + " time: " + total);
		
		return NewDenseArray;
		
		
		
	}
	
	//part 6
	public static void MaxOfDense(int[]Array) {
		double start = System.nanoTime();
		int max = Array[0];
		int loc = 0;
		for (int i = 1; i < Array.length; i++) {
		    if (Array[i] > max) {
		    	// Inspired by stackoverflow
		    	//https://stackoverflow.com/questions/16325168/how-would-i-find-the-maximum-value-in-an-array
		      max = Array[i];
		      loc = i;
		    }
		}
		double end = System.nanoTime();
		double total = (end - start)/ 1000000;
		System.out.println("find max (dense): "+ max + " at: " + loc);
		System.out.println("dense find time: " + total);
	}
	
	// part 7
	public static void MaxOfSparse(ArrayList<int[]> ArrList) {
		double start = System.nanoTime();
		int SparseArrSize = ArrList.size();
		int index = 0;
		int max = 0;
		for (int x = 0; x < SparseArrSize; x++) {
			if (ArrList.get(x)[1] > max) {
				max = ArrList.get(x)[1];
				index = ArrList.get(x)[0];
			}
		}
		double end = System.nanoTime();
		double total = (end - start)/ 1000000;

		System.out.println("find max (sparse): " + max + " at: "  + index);
		System.out.println("sparse find time: " + total);
	}
		
		
		
		
	}
		
	
	

