package dataStructure.impl;

import dataStructure.Graph;

/**
 * 邻接表实现图
 * @author chenyubin
 *
 */
public class SimpleGraph extends Graph{

	public int V;	//顶点数
	public int E;	//边数
	private Bag<Integer>[] adj;//邻接表
	
	
	
	public SimpleGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++){
			adj[v] = new Bag<Integer>();
		}
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);//一条边在邻接表中表现为两个连接，自环也是相同的
		adj[w].add(v);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	
	
}
