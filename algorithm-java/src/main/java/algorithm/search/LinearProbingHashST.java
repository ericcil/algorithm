package algorithm.search;

/**
 * 基于线性探测的hash
 * 算法P314
 * @author chenyubin
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key,Value> {

	private int N;
	private int M = 16;
	private Key[] keys;
	private Value[] vals;
	
	private LinearProbingHashST(){
		keys = (Key[]) new  Object[M];
		vals = (Value[]) new Object[M];
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void resize(int len){}
	
	public void put(Key key,Value val){
		if(N >= M/2) resize(2*M);
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1)%M){
			if(keys[i].equals(key)){
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public Value get(Key key){
		for(int i=hash(key);keys[i]!=null;i=(i+1)%M){
			if(keys[i].equals(key)){
				return vals[i];
			}
		}
		return null;
	}
}
