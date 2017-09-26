package algorithm.graph.search;

import dataStructure.Graph;

/**
 * 计算和起始顶点相连的顶点数量
 * 《算法》 P351
 * @author chenyubin
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;//标记对应顶点是否访问过
	private int count;
	
	public DepthFirstSearch(Graph g,int s){
		marked = new boolean[g.V()];
		dfs(g,s);
	}
	
	/**
	 * 计算和起始顶点相连的顶点数量
	 * @param g 
	 * @param v 起始顶点
	 */
	private void dfs(Graph g,int v){
		marked[v] = true;
		count++;
		for(int w:g.adj(v)){
			if(!marked[w])
				dfs(g,w);
		}
	}
	
	public boolean marked(int w){
		return marked[w];
	}
	
	public int count(){
		return count;
	}
}
