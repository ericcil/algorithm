package algorithm.sort;

import static algorithm.util.UtilTools.exchange;
import static algorithm.util.UtilTools.print;

import java.util.Random;

/**
 * 快速排序和归并排序的区别：
 * 归并排序：将数列任意拆分成N个子数列，分别进行排序，然后再合并子数列，对整体进行排序
 * 快速排序：将数列有规则的拆分成N个子数列，分别排序，当子数列有序，整合的数列也有序
 *
 */
public class QuickSort {

	
	public static void main(String[] args) {
		int[] source = new int[10];
		Random r = new Random();
		for(int i=0;i<source.length;i++){
			source[i] = r.nextInt(300);
		}
		print(source);
		Long begin = System.currentTimeMillis();
		
		quickSort(source,0,source.length-1);
		
		System.out.println(System.currentTimeMillis()-begin+"ms");
		print(source);
	}
	
	
	/**
	 * 《算法》P183 快速排序
	 * @param source
	 * @param low
	 * @param hig
	 */
	public static void quickSort(int[] source,int low,int hig){
		if(hig <= low) return;
		int j = partition(source,low,hig);
		quickSort(source,low,j-1);
		quickSort(source,j+1,hig);
	}
	
	/**
	 * 切分数组，在切分的时候将数组大小区分
	 * @param source
	 * @param low
	 * @param hig
	 * @return
	 */
	public static int partition(int[] source,int low,int hig){
		int i = low,j = hig+1;
		int value = source[low];
		
		while(true){
			while(source[++i]<value){//从value右手边找到第一个不小于value大的数
				if(i==hig) break;
			}
			while(value<source[--j]){//从数列最右边起找到第一个不大于value小的数
				if(j==low) break;
			}
			if(i>=j) break;
			exchange(source,i,j);//交换两个数，使某位置（j=i或j=i-1）右边只有比value大的数，左边只有比value小的数
		}
		exchange(source,low,j);//将value放到那个位置（j=i或j=i-1）
		return j;
	}
}
