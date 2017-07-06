package algorithm.sort;

import static algorithm.util.UtilTools.exchange;
import static algorithm.util.UtilTools.print;

import java.util.Random;
/**
 * 堆排序，使用优先队列的结构进行排序
 * @author chenyubin
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] source = new int[10];
		Random r = new Random();
		for(int i=0;i<source.length;i++){
			source[i] = r.nextInt(300);
		}
		print(source);
		
		heapSort(source);
		print(source);
	}
	
	
	public static void heapSort(int[] source){
		int lastIndex = source.length - 1;
		for(int i=lastIndex/2;i>=0;i--){//从倒数第二层开始下沉，将堆有序化
			sink(source,i,lastIndex);
		}
		while(lastIndex>0){
			exchange(source,0,lastIndex--);//将最大值，放到数列末尾，从堆中移除，将原本最后一位放到堆顶
			sink(source,0,lastIndex);//在缩小的堆中进行下沉，将堆有序化，将堆里剩下的最大值放到堆顶
		}
	}
	
	/**
	 * 下沉元素k
	 * @param k
	 */
	private static void sink(int[] source,int k,int range){
		while(2*k <= range){
			int j = 2*k;
			if(j < range && source[j]<source[j+1] ){//获取节点k下子节点中最小的一个
				j++;
			}
			if(source[j] <= source[k]){//比较节点k和节点j
				break;
			}
			exchange(source,k,j);
			k = j;
		}
	}
}
