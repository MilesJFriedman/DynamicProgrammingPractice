package recitation6Sums;

import java.util.Scanner;

/**
 * Sums.java
 * 
 * @author Miles
 * @version 7/16/14
 */
public class SumsSolver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int testCases = input.nextInt();
		
			int N = input.nextInt();
			int M = input.nextInt();

			//Create an array to dynamically store the amount of ways you can represent N as a sum
			//from 0 to N.
			int[] permutations = new int[N+1];
			
			//Create base cases that will be used to assist the recursive function below.
			permutations[0] = 0;
			permutations[1] = 0;
			permutations[2] = 1%M;
			permutations[3] = 1%M;
			permutations[4] = 1%M;
			permutations[5] = 3%M;
			
			int answer = sumsRec(N, permutations, M);
			System.out.println(answer);
	}
	
	//recursively solves the problem by breaking up the number into smaller versions until it can
	//use permutation values from base cases or previously filled cases to solve the problem.
	public static int sumsRec (int n, int[] permutations, int M) {
		if (n <= 5 || permutations[n] != 0)
			return permutations[n];
		else if (n > 5) 
			permutations[n] = sumsRec(n-5, permutations, M)%M + sumsRec(n-3, permutations, M)%M + sumsRec(n-2, permutations, M)%M;
		return permutations[n];
	}

}
