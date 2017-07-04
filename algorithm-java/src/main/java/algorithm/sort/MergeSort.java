package algorithm.sort;

import static algorithm.util.UtilTools.print;

import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {

	private static int[] temp;
	
	public static void main(String[] args) {
		int[] source = new int[10];
		Random r = new Random();
		for(int i=0;i<source.length;i++){
			source[i] = r.nextInt(300);
		}
		print(source);
		temp = new int[source.length];
		//topDownMergeSort(source,0,source.length-1);
		downTopMergeSort(source);
		print(source);
	}
	
	/**
	 * 《算法》 P171
	 * 自顶向下的归并排序
	 * 树形结构，由上向下，逐个枝干叶遍历
	 * {4,3,43,31,10,0}
	 * {4,3,43|31,10,0}
	 * {4,3|43........}
	 * @param source
	 * @param low
	 * @param hig
	 */
	public static void topDownMergeSort(int[] source,int low,int hig){
		if(hig<=low){//递归停止的判断
			return;
		}
		int mid = low+(hig-low)/2;
		topDownMergeSort(source,low,mid);
		topDownMergeSort(source,mid+1,hig);
		merge(source,low,mid,hig);
	}
	
	
	/**
	 * 自底向上的归并排序
	 * @param source
	 */
	public static void downTopMergeSort(int[] source){
		int len = source.length;
		for(int step =1;step<len;step = 2*step){//按步进逐步扩大，细分数列
			for(int lo=0;lo<len-step;lo=lo+2*step){//排序数列
				merge(source,lo,lo+step-1,Math.min(lo+2*step-1, len-1));
			}
		}
	}
	
	
	public static void merge(int[] source,int low,int mid,int hig){
		int i = low,j = mid+1;
		for(int k = low;k<=hig;k++){//快照当前比对的数列
			temp[k] = source[k];
		}
		for(int k=low;k<=hig;k++){//比较快照数列左右的数，依次替换原始数列
			if(i>mid){ //当左边的数列取尽
				source[k] = temp[j];
				j++;
			}else if(j>hig){//当右边的数列取尽
				source[k] = temp[i];
				i++;
			}else if(temp[j]<temp[i]){
				source[k] = temp[j];
				j++;
			}else{
				source[k] = temp[i];
				i++;
			}
		}
	}
}
