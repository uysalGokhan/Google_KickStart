import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static final long boundry = 1000000000; 

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int caseNumber = reader.nextInt();
		reader.nextLine();

		for (int i = 0; i < caseNumber; i++) {
			caseSolver(reader, i);
		}

	}
	
	public static void caseSolver(Scanner reader, int caseNumber){
		System.out.print("case #" + (caseNumber + 1) + ": ");
		String moves = reader.nextLine();
//		double times = 1 ;
		ArrayList<Integer> timesQueue = new ArrayList<Integer>();
		long NS = 1;
		long EW = 1;
		for(char c : moves.toCharArray()) {
			if(c <= '9' && c >= '2') {
				timesQueue.add(Character.getNumericValue(c));
//				times *= Character.getNumericValue(c);
			} else if(c == ')') {
//				times /= timesQueue.get(timesQueue.size() - 1);
				timesQueue.remove(timesQueue.size() - 1);
			} else if(c == 'N') {
				long tmp = 1;
				for(int i = 0 ; i < timesQueue.size() ; i++) {
					tmp *= timesQueue.get(i);
					if(tmp > boundry) {
						tmp %= boundry;
					}
				}
				NS -= tmp;;
				if(NS <= 0) {
					NS += boundry;
				} else if(NS > boundry) {
					NS -= boundry;
				}
			} else if(c == 'S') {
				long tmp = 1;
				for(int i = 0 ; i < timesQueue.size() ; i++) {
					tmp *= timesQueue.get(i);
					if(tmp > boundry) {
						tmp %= boundry;
					}
				}
				NS += tmp;
				if(NS <= 0) {
					NS += boundry;
				} else if(NS > boundry) {
					NS -= boundry;
				}
			} else if(c == 'E') {
				long tmp = 1;
				for(int i = 0 ; i < timesQueue.size() ; i++) {
					tmp *= timesQueue.get(i);
					if(tmp > boundry) {
						tmp %= boundry;
					}
				}
				EW += tmp;
				if(EW <= 0) {
					EW += boundry;
				} else if(EW > boundry) {
					EW -= boundry;
				}
			} else if(c == 'W') {
				long tmp = 1;
				for(int i = 0 ; i < timesQueue.size() ; i++) {
					tmp *= timesQueue.get(i);
					if(tmp > boundry) {
						tmp %= boundry;
					}
				}
				EW -= tmp;
				if(EW <= 0) {
					EW += boundry;
				} else if(EW > boundry) {
					EW -= boundry;
				}
				
			}
		}
		System.out.println(EW + " " + NS);
	}
}