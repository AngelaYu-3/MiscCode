import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sort {
	Scanner in = new Scanner(System.in);
	String[] values;
	int[] array;
	int i = 0;
	
	public sort() {
		System.out.print("Please enter in a list of integers separated by commas only or q to quit: ");
		String input = in.nextLine();
		String regex = "[\\d, /, /-]+"; //used to see if "0-9" and "," are only present in input
		
		if(input.contentEquals("q") || input.contentEquals("Q")) {
			System.out.printf("\nProcess finished with exit code 0");
			System.exit(0);
		}
		while(!input.matches(regex)) {
			if(input.contentEquals("q") || input.contentEquals("Q")) {
				System.out.printf("\nProcess finished with exit code 0");
				System.exit(0);
				//break;
			}
			System.out.print("Please enter in a list of integers separated by commas only or q to quit: ");
			input = in.nextLine();
		}
		
		values = input.split(",");
		array = new int[values.length];
		for(String str:values) {
			array[i] = Integer.parseInt(str);
			i++;
		}
		//System.out.print(Arrays.toString(array));
	}
	
	//selectionSort logic
	public void selectionSort() {	    
		
		for(int i = 0; i < array.length - 1; i++) {
			                                                   
			int minIndex = i;
			
			for(int j = i + 1; j < array.length; j++) {	
				if((array[j]) < (array[minIndex])) {					
					minIndex = j;
				}
			}
			                 
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		System.out.print("Selection Sort: " + Arrays.toString(array) + " ");
	}

	
	//insertionSort logic
	public void insertionSort() {
	    for(int i = 1; i < array.length; i++) {
	    	
	    	int temp = array[i];
	    	int possibleIndex = i;
	    	
	    	while(possibleIndex > 0 && temp < array[possibleIndex - 1]) {
	    		array[possibleIndex] = array[possibleIndex - 1];
	    		possibleIndex--;
	    	}
	    	
	    	array[possibleIndex] = temp;
	    }
	    System.out.println("Insertion Sort: " + Arrays.toString(array) + " ");
	    System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do{
			sort test = new sort();
			test.selectionSort();
			test.insertionSort();
		}while(true);
	}

}