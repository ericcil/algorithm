package algorithm.search;

/**
 * 二叉查找树
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
	
	public Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
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
