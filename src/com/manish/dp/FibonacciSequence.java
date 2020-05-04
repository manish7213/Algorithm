package com.manish.dp;

import java.util.Arrays;

public class FibonacciSequence {
	
	public static void main(String[] args) {
		int n = 6;
		int[] mem = createMemTable(n);
		int x = Fibonacci(n,mem);
		System.out.println(x);
	}

	private static int Fibonacci(int n,int[] mem) {
		
		if(mem[n] != -1) {
			return mem[n];
		}
		if(n == 0 || n == 1) {
			mem[n] =  n;
		}
		
		else mem[n] =  Fibonacci(n-1,mem) + Fibonacci(n-2,mem);
		
		return mem[n];
	}

	private static int[] createMemTable(int n) {
		int[] mem = new int[n+2];
		Arrays.fill(mem, -1);
		return mem;
	}
}

// 0 1 1 2 3 5 8