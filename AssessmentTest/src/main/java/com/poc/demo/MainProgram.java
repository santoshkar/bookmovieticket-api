package com.poc.demo;

public class MainProgram {
	public static void main(String[] args) {
		int[] arr = { 2,6,8,5 };
		int size = solution(arr);
		System.out.println(size);
	}

	public static int solution(int[] blocks) {
		
		int move = 0;
		int max = 0;
		
		if(blocks.length == 2) {
			return 2;
		}

		for (int i = 0; i < blocks.length; i++) {
			move = 0;
			// Moving to right
			for (int j = i; j < blocks.length-1; j++) {
				if(blocks[j+1]>=blocks[j]) {
					move++;
				} else
					break;
			}

			//Moving to left
			for (int k = i; k > 0; k--) {
				if(blocks[k-1]>=blocks[k]) {
					move++;
				} else
					break;
			}
			
			if(max<move) max = move;

		}

		return max;
	}
}

record Airport(int id, String name){
	
}
