package algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 * 改进：2-3查找树 《算法》P269
 * 2-3树的平衡性在于在插入时可以让2-节点和3-节点动态的变化，降低树的高度
 * 
 */
public class BST {

	private Node root;//根节点
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x == null) return 0;
		return x.n;
	}
	
	public String get(String key){
		return get(root,key);
	}
	
	public void put(String key,String val){
		root = put(root,key,val);
	}
	
	private String get(Node x,String key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		if(cmp>0) return get(x.right,key);
		else return x.val;
	}

	/**
	 * put操作不会除了新增节点外，不会对树结构进行改变
	 * key的插入顺序会直接影响树的结构，最好情况下树是左右平衡的
	 * 最坏情况下树的高度会等于节点数，造成和基于无需数组的查找一样的开销
	 * @param x
	 * @param key
	 * @param val
	 * @return
	 */
	private Node put(Node x,String key,String val){
		if(x == null) return new Node(key,val,1);//类似下沉操作
		int cmp = key.compareTo(x.key);
		if(cmp<0){
			x.left = put(x.left,key,val);
		}else if(cmp>0){
			x.right = put(x.right,key,val);
		}else{
			x.val = val;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * 最小键
	 * @return
	 */
	public String min(){
		return min(root).key;
	}
	
	private Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	
	public String max(){
		return max(root).key;
	}
	
	private Node max(Node x){
		if(x.right == null) return x;
		return max(x.right);
	}
	
	/**
	 * 选则第k个key
	 * @param k
	 * @return
	 */
	public String select(int k){
		return select(root,k).key;
	}
	
	private Node select(Node x,int k){
		if(x == null) return null;
		int t = size(x.left);
		if(t > k){//如果k比左树的节点数小，则标识点k在左树里
			return select(x.left,k);
		}else if(t < k){
			return select(x.right,k-t+1);//计算k相对于右树的位置
		}else{
			return x;
		}
	}
	
	/**
	 * 获取给定key的位置
	 * @param key
	 * @return
	 */
	public int rank(String key){
		return rank(key,root);
	}
	
	private int rank(String key,Node x){
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return rank(key,x.left);
		}else if(cmp > 0){
			return 1 + size(x.left) + size(x.right);
		}else{
			return size(x.left);
		}
	}
	
	/**
	 * 删除最小值
	 */
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if(x.left == null) return x.right;//递归直到左树为空，即没有更小的，则将右树挂钩
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(String key){
		root = delete(root,key);
	}
	
	public Node delete(Node x,String key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			x.left = delete(x.left,key);//左移指针
		}else if(cmp > 0){
			x.right = delete(x.right,key);//右移指针
		}else{
			if(x.right == null) return x.left;//如果该节点只有一边有子树，则直接挂钩子树
			if(x.left == null) return x.right;
			//当前要删除的节点含有两个子树时
			Node t = x;
			x = min(t.right);//取右树最小，根据二叉查找树定义，该节点一定比左树所有值都大
			x.right = deleteMin(t.right);//删除右树最小值
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x; 
	}
	
	public Iterable<String> keys(){
		return keys(min(),max());
	}
	
	/**
	 * 获取给定范围内keys
	 * @param low
	 * @param hig
	 * @return
	 */
	public Iterable<String> keys(String low,String hig){
		Queue<String> queue = new LinkedList<String>();
		keys(root,queue,low,hig);
		return queue;
	}
	
	private void keys(Node x,Queue<String> queue,String low,String hig){
		if(x == null)return;
		int cmplo = low.compareTo(x.key);
		int cmphi = hig.compareTo(x.key);
		if(cmplo < 0) keys(x.left,queue,low,hig);
		if(cmplo <= 0 && cmphi >= 0) queue.add(x.key);
		if(cmphi > 0) keys(x.right,queue,low,hig);
	}
	
	
	public class Node{
		private String key;//键
		private String val;//值
		private Node left;//左子树
		private Node right;//右子树
		private int n; //以该节点为根的子树中的节点总数
		
		public Node(String key, String val, int n) {
			super();
			this.key = key;
			this.val = val;
			this.n = n;
		}
	}
}
