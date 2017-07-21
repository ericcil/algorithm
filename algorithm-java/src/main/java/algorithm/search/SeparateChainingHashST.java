package algorithm.search;

/**
 * 基于链表的散列
 * 《算法》 P297
 */
public class SeparateChainingHashST<key,value> {
	
	private int n;
	private int m;
	private SeparateChainingHashST<key,value>[] st;
	
	public SeparateChainingHashST(){
		this(997);
	}
	
	public SeparateChainingHashST(int m){
		this.m = m;
		st = new SeparateChainingHashST[m];
		for(int i=0;i<m;i++){
			st[i] = new SeparateChainingHashST();
		}
	}
	
	private int hash(Object key){
		return (key.hashCode() & 0x7fffffff) % m;//除留余数
	}
	
	public Object get(Object key){
		return st[hash(key)].get(key);
	} 
	
	
}
