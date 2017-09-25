package dataStructure;

/**
 * 图
 * @author chenyubin
 *
 */
public abstract class Graph {
	
	/**
	 * 获取该图的顶点数
	 * @return
	 */
	abstract int V();
	
	/**
	 * 获取该图的边数
	 * @return
	 */
	abstract int E();
	
	/**
	 * 向图中添加一条连接顶点v和顶点w的边
	 * @param v
	 * @param w
	 */
	abstract void addEdge(int v,int w);
	
	/**
	 * 获取和顶点v相邻的所有顶点
	 * @param v
	 * @return
	 */
	abstract Iterable<Integer> adj(int v);
	
	
	/**
	 * 计算顶点的度数
	 * @param v
	 * @return
	 */
	public int degree(int v){
		int degree = 0;
		for(int w:this.adj(v)){
			degree++;
		}
		return degree;
	}
	
	/**
	 * 返回最大度数
	 * @return
	 */
	public int maxDegree(){
		int max = 0;
		int currentDegree = 0;
		for(int v=0;v<this.V();v++){
			currentDegree = degree(v);
			if(currentDegree > max) max = currentDegree;
		}
		return max;
	}
	
	/**
	 * 计算平均度数
	 * @return
	 */
	public double avgDegree(){
		//一个边连接两个顶点，在计算总度数的时候需要*2
		return 2 * this.E() / this.V();
	}
	
	/**
	 * 计算自环个数
	 * @return
	 */
	public int numberOfSelfLoops(){
		int count = 0;
		for(int v = 0;v<this.V(); v++){
			for(int w : this.adj(v)){
				if(v == w)count++; //自环连接自身
			}
		}
		return count/2;//TODO 每条边都会记录两次（？有疑问）
	}
	
	public String toString(){
		String s = " vertices, " + " edges\n";
		for(int v = 0;v<this.V();v++){
			s += v + ": ";
			for(int w : this.adj(v)){
				s += w + " "; 
			}
			s += "\n";
		}
		return s;
	}
	
}
