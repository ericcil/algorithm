package algorithm.graph.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

import dataStructure.Graph;

/**
 * 基于BFS
 * 
 * @author chenyubin
 *
 */
public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;//起点
	
	public BreadthFirstPaths(Graph g,int s){
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = s;
		bfs(g,s);
	}
	
	private void bfs(Graph g,int s){
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		queue.add(s);
		while(!queue.isEmpty()){
			int v =  queue.poll();
			for(int w : g.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.add(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)){
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x != s; x=edgeTo[x]){//获取到的路径不是最段路径
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
}
