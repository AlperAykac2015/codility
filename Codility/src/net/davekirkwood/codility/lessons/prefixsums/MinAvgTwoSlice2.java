package net.davekirkwood.codility.lessons.prefixsums;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class MinAvgTwoSlice2 {

	public int solution(int[] A) {

		int minSumOf2 = Integer.MAX_VALUE;

		int minSumOf3 = Integer.MAX_VALUE;

		int[] newSums = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {

			newSums[i + 1] = A[i] + newSums[i];
		}
		System.out.println("\n");
		List<String> list = Arrays.stream(newSums).mapToObj(x->String.valueOf(x)).collect(Collectors.toList());
		list.stream().forEach(x-> System.out.print(x+":"));
		System.out.println("\n");

		int startingIdx3 = 0;
		int startingIdx2 = 0;
		System.out.println(minSumOf2+":"+startingIdx2);

		for (int i = 1; i < newSums.length-1; i++) {
			System.out.println("newSums["+i+"]:"+newSums[i]);

			if(minSumOf2 > newSums[i]) {
				minSumOf2 = newSums[i];
				startingIdx2=i-1;				
			}
		}	
		System.out.println(minSumOf2+":"+startingIdx2);

		for (int i = 1; i < newSums.length-1; i++) {
			int nt = newSums[i]+A[i];
			System.out.println("--"+i+">"+newSums[i]+":"+A[i]+":"+nt+":"+minSumOf3);
			if(minSumOf3 > nt) {
				minSumOf3 = nt;
				startingIdx3=i;				
			}
		}	
		System.out.println(minSumOf3+":"+startingIdx3);


		return (startingIdx2 > startingIdx3 ? startingIdx3:startingIdx2) ;/// return starting index of min-sum slice
	}


	public static void main(String[] args) {
		MinAvgTwoSlice2 mats = new MinAvgTwoSlice2();
		System.out.println(mats.solution(new int[] { 10, 11, -20, 5 }));
		// System.out.println(mats.solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
		// System.out.println(mats.solution(new int[] { 4, 2, 2, 5, 7, 2, 1 }));
	}

}
