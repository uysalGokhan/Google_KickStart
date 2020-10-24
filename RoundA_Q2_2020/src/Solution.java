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
		
		int stackNumber = reader.nextInt();
		int plateOnEachStack = reader.nextInt();
		int NumberOfPlateTaken = reader.nextInt();
		
		int dp[][] = new int[stackNumber + 1][NumberOfPlateTaken + 1];
		
		for(int i = 0 ; i < stackNumber ; i++) {
			dp[i + 1] = Arrays.copyOf(dp[i], dp[0].length);
			int sum = 0;
			for(int j = 0 ; j < plateOnEachStack ; j++) {
				int tmp = reader.nextInt();
				sum += tmp;
				for(int l = 0 ; l + j + 1 <= NumberOfPlateTaken ; l++) {
					dp[i + 1][l + j + 1] = Math.max(dp[i][l] + sum, dp[i+1][l+j+1]);
				}
			}
		}
		
		System.out.println(dp[stackNumber][NumberOfPlateTaken]);
	}

}
