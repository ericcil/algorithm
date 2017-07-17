package algorithm.search;

/**
 * 使用红黑查找树实现2-3树（即3阶B树）
 * 红链连接的两个节点表示一个3-节点
 * 黑链表示普通2-节点
 * （B树查找能减少IO操作
 */
public class RBT {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;//根节点总是黑色
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x == null) return 0;
		return x.n;
	}
	
	/**
	 * 左旋当前节点，改变受影响节点颜色（由于不会存在两个红链同时连接一个节点，总是红黑相间）
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;//改变中间节点的归属
		x.left = h;//改变红链
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	/**
	 * 右旋当前节点，改变受影响节点颜色（由于不会存在两个红链同时连接一个节点，总是红黑相间）
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	
	private void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public boolean isRead(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	
	private class Node{
		String key;
		String val;
		Node left;
		Node right;
		int n;
		boolean color;
		
		Node(String key,String val,int n,boolean color){
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
		
	}
}
