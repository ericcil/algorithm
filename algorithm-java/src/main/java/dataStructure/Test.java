package dataStructure;

import java.util.PriorityQueue;
import java.util.Random;
import static algorithm.util.UtilTools.print;

public class Test {

	public static void main(String[] args) {
		int[] source = new int[10];
		Random r = new Random();
		for(int i=0;i<source.length;i++){
			source[i] = r.nextInt(300);
		}
		print(source);
		
		SimplePriorityQueue queue = new SimplePriorityQueue(source.length+1);
		for(int i:source){
			queue.insert(i);
		}
		for(int i=0;i<source.length;i++){
			System.out.print(queue.delMax()+",");
		}
	}
}
