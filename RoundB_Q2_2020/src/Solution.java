import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int caseNumber = reader.nextInt();

		for (int i = 0; i < caseNumber; i++) {
			caseSolver(reader, i);
		}

	}
	
	public static void caseSolver(Scanner reader, int caseNumber){
		System.out.print("case #" + (caseNumber + 1) + ": ");
		int n = reader.nextInt();
		long d = reader.nextLong();
		long busTimes[] = new long[n];
		
		for(int i = 0 ; i < n ; i++) {
			busTimes[i] = reader.nextLong();
		}
		
		for(int i = n - 1 ; i >= 0 ; i--) {
			d -= d % busTimes[i];
		}
		
		System.out.println(d);
	}
}