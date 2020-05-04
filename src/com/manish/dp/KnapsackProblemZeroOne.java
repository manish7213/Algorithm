package com.manish.dp;

public class KnapsackProblemZeroOne {

	public static void main(String[] args) {

		int[] values = {60,100,120};
		int[] weights = {10,20,30};
		int capacity = 50;
		int size = weights.length;

		int result = getKnapsack(weights, values, capacity, size);
		
		System.out.println(result);
	}

	private static int getKnapsack(int[] weights, int[] values, int capacity, int n) {
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		if(weights[n-1] <= capacity) {
			
			return max(values[n-1] + getKnapsack(weights, values, capacity-weights[n-1],n-1),getKnapsack(weights, values, capacity,n-1));
		} else {
			
			return getKnapsack(weights, values, capacity,n-1);
		}
		
		
	}

	private static int max(int a, int b) {

		return a > b ? a : b;
	}

}
