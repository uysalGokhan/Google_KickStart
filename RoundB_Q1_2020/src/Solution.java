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
		int result = 0;
		int prev = reader.nextInt();
		int current = reader.nextInt();
		int next;
		
		for(int i = 2 ; i < n ; i++) {
			next = reader.nextInt();
			if(current > prev && current > next) {
				result++;
			}
			
			prev = current;
			current = next;
		}
		System.out.println(result);
	}
}