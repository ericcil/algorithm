package algorithm.graph.search;

import dataStructure.Digraph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: chenyubin
 * Date: 2017/10/30
 * Time: 10:12
 * Description
 * 寻找有向图中的环
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g){
        onStack = new boolean[g.v()];
        edgeTo = new int[g.v()];
        marked = new boolean[g.v()];
        for(int v=0;v<g.v();v++){
            if(!marked[v])
            {
                dfs(g,v);
            }
        }
    }

    private void dfs(Digraph g,int v){
        onStack[v] = true;
        marked[v] = true;
        for(int w:g.adj(v)){
            if(this.hasCycle()){
                return;
            }else if(!marked[w]){
                edgeTo[w] = v;
                dfs(g,w);
            }else if(onStack[w]){
                cycle = new Stack<Integer>();
                for(int x = v;x!=w;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public  Iterable<Integer> cycle(){
        return  cycle;
    }
}
