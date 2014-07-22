package recitation6Sums;

import java.util.Scanner;

/**
 * Sums.java
 * 
 * @author Miles Friedman m3488030 COP3503C R6-Sums
 * @version 7/16/14
 */
public class SumsSolver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int testCases = input.nextInt();
		
		for (int i = 0; i < testCases; i++) {
			
			int N = input.nextInt();
			int M = input.nextInt();

			//Create an array to dynamically store the amount of ways you can represent N as a sum
			//from 0 to N.
			int[] permutations = new int[N+1];
			
			//Create base cases that will be used to assist the recursive function below.
			if (N >= 0)
				permutations[0] = 0;
			if (N >= 1)
				permutations[1] = 0;
			if (N >= 2) 
				permutations[2] = 1%M;
			if (N >= 3)
				permutations[3] = 1%M;
			if (N >= 4)
				permutations[4] = 1%M;
			if (N >= 5)
				permutations[5] = 3%M;
			
			int answer = sumsIterative(N, permutations, M);
			System.out.println(answer);
			
		}
	}
	
	//Iteratively traverses through the permutations array filling it as it goes along and using
	//previously filled permutation values to solve new ones.
	public static int sumsIterative (int N, int[] permutations, int M) {
		for (int i = 0; i < N+1; i++) {
			if (i > 5)
				permutations[i] = (permutations[i-5] + permutations[i-3] + permutations[i-2])%M;
		}
		return permutations[N];
	}
	
	
	/*//recursively solves the problem by breaking up the number into smaller versions until it can
	//use permutation values from base cases or previously filled cases to solve the problem.
	public static int sumsRec (int n, int[] permutations, int M) {
		if (n <= 5 || permutations[n] != 0)
			return permutations[n];
		else if (n > 5) 
			permutations[n] = (sumsRec(n-5, permutations, M) + sumsRec(n-3, permutations, M) + sumsRec(n-2, permutations, M))%M;
		return permutations[n];
	}*/

}
