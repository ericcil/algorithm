package dataStructure.impl;

import java.util.PriorityQueue;

/**
 * 利用数组，实现有序二叉堆结构
 * 简单实现优先队列
 * see {@link PriorityQueue}
 * @author chenyubin
 *
 */
public class SimplePriorityQueue {

	/**
	 * 使用数组，实现二叉堆结构
	 * 完全二叉树：叶子节点都集中在该层最左边的若干位置
	 * 不使用[0]元素，根节点为元素[1]
	 * 堆结构对应数组元素下标为：
	 *      [1]
	 *  [2]    [3]
	 * [4][5][6][7]
	 * 
	 */
	private Integer[] heap;
	private int size = 0;
	
	public SimplePriorityQueue(int maxLen){
		this.heap = new Integer[maxLen];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * 插入新元素
	 * @param v
	 */
	public void insert(int v){
		heap[++size] = v;//在末尾插入新节点
		swim(size);//通过上浮新节点，重新有序化堆
	}
	
	public int delMax(){
		int max = heap[1];//该优先队列中维护的最大值永远位于根节点
		exch(1,size);//将最后一个节点至根节点，通过下沉该节点，重新有序化堆（reheapifying）
		heap[size] = null;
		size--;
		sink(1);
		return max;
	}
	
	private boolean less(int first,int second){
		return heap[first] < heap[second];
	}
	
	private void exch(int one,int other){
		Integer temp = heap[one];
		heap[one] = heap[other];
		heap[other] = temp;
	}
	
	/**
	 * 上浮元素k
	 * @param k
	 */
	private void swim(int k){
		while(k > 1 && less(k/2,k)){//比较子节点k和其父节点
			exch(k/2,k);
			k = k/2;
		}
	}
	
	/**
	 * 下沉元素k
	 * @param k
	 */
	private void sink(int k){
		while(2*k <= size){
			int j = 2*k;
			if(j < size && less(j,j+1)){//获取节点k下子节点中最小的一个
				j++;
			}
			if(!less(k,j)){//比较节点k和节点j
				break;
			}
			exch(k,j);
			k = j;
		}
	}
}
