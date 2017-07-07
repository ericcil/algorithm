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
