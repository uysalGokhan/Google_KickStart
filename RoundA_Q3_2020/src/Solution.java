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
		int n = reader.nextInt();
		int k = reader.nextInt();

		int a[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = reader.nextInt();
		}

		int lb = 1;
		int rb = a[n - 1] - a[0];
		while (lb < rb) {
			int mb = (lb + rb) / 2;
			int k2 = 0;
			for(int i = 1 ; i < n ; i++) {
				int d = a[i] - a[i-1];
				k2 += (d+mb-1)/mb-1;
//				k2 = (int) Math.ceil(d / ((mb - 1) * 1.0));
			}
			
			if(k2 <= k) {
				rb = mb;
			} else {
				lb = mb + 1;
			}
		}
		
		System.out.println(lb);

	}

}
