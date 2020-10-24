import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int caseNumber = reader.nextInt();

		for (int i = 0; i < caseNumber; i++) {
			caseSolver(reader, i);
		}

	}

	public static void caseSolver(Scanner reader, int caseNumber) {

		System.out.print("case #" + (caseNumber + 1) + ": ");
		int house = reader.nextInt();
		int budget = reader.nextInt();
		int houses[] = new int[house];
		
		for(int i = 0 ; i < house ; i++) {
			houses[i] = reader.nextInt();
		}
		
		Arrays.sort(houses);
		
		int result = 0;
		for(int i = 0 ; i < house ; i++) {
			int tmp = budget - houses[i];
			if(tmp < 0) {
				break;
			}
			budget = tmp;
			result++;
		}
		
		System.out.println(result);
	}

}
