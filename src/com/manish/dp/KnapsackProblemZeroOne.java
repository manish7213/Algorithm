package com.manish.dp;

public class KnapsackProblemZeroOne {

	public static void main(String[] args) {

		int[] values = { 60, 100, 120 };
		int[] weights = { 10, 20, 30 };
		int capacity = 50;
		int size = weights.length;
		int[][] memTable = createMemTable(size, capacity);
		int result = getKnapsack(weights, values, capacity, size, memTable);

		System.out.println("Result is: " + result);
	}

	private static int getKnapsack(int[] weights, int[] values, int capacity, int n, int[][] memTable) {

		if (memTable[n][capacity] != -1) {
			return memTable[n][capacity];
		}
		if (n == 0 || capacity == 0) {
			return 0;
		}

		if (weights[n - 1] <= capacity) {
			memTable[n][capacity] = max(
					values[n - 1] + getKnapsack(weights, values, capacity - weights[n - 1], n - 1, memTable),
					getKnapsack(weights, values, capacity, n - 1, memTable));
		} else {

			memTable[n][capacity] = getKnapsack(weights, values, capacity, n - 1, memTable);
		}

		return memTable[n][capacity];

	}

	private static int max(int a, int b) {

		return a > b ? a : b;
	}

	private static int[][] createMemTable(int n, int w) {

		int[][] memTable = new int[n + 2][w + 2];

		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				memTable[i][j] = -1;
			}
		}

		return memTable;
	}

}
