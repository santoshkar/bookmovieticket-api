package com.test;

public class Test {
	public static void main(String[] args) {

		int n = 5;
		print1(n);
//		print2(n);

	}

	static void print1(int n) {
		System.out.print("\n\n");
		for (int i = 1; i <= n; i++) {

			for (int j = n; j >= i; j--) {
				System.out.print("--");
			}

			int k;
			for (k = 1; k <= i; k++) {
				System.out.print(k + " ");
			}

			for (int l = k -= 2; l >= 1; l--) {
				System.out.print(l + " ");
			}
			System.out.print("\n");
		}

//		for (int i = 1; i <= n; i++) {
//			int j;
//			for (j = 0; j <= i; j++) {
//				System.out.print("  ");
//			}
//
//			int k;
//			for (k = 1; k <= n - i; k++) {
//				System.out.print(k + " ");
//			}
//
//			for (int l = k -= 2; l >= 1; l--) {
//				System.out.print(l + " ");
//			}
//			System.out.println();
//		}
	}
	
	
	static void print2(int n) {
		System.out.print("\n\n");
		for (int i = 1; i <= n; i++) {

			for (int j = n; j >= i; j--) {
				System.out.print("  ");
			}

			int k;
			for (k = 1; k <= i; k++) {
				System.out.print("* ");
			}

			for (int l = k -= 2; l >= 1; l--) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}

		for (int i = 1; i <= n; i++) {
			int j;
			for (j = 0; j <= i; j++) {
				System.out.print("  ");
			}

			int k;
			for (k = 1; k <= n - i; k++) {
				System.out.print("* ");
			}

			for (int l = k -= 2; l >= 1; l--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
