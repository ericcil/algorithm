package algorithm.util;

public class UtilTools {

	
	public static void exchange(int[] source,int first,int second){
		int temp = source[first];
		source[first] = source[second];
		source[second] = temp;
	}
	
	public static void print(int[] source){
		for(int i:source){
			System.out.print(i+",");
		}
		System.out.println();
	}
}
