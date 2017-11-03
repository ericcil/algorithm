package algorithm.graph.sort;

import dataStructure.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: chenyubin
 * Date: 2017/10/30
 * Time: 13:50
 * Description
 * 有向图中基于深度优先搜索的顶点排序
 * 《算法》P375
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;//所有顶点的前序排序
    private Queue<Integer> post;//所有顶点的后序排序
    private Stack<Integer> reversePost;//所有顶点的逆后序排序

    public DepthFirstOrder(Digraph g){
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[g.v()];
        for(int v=0;v<g.v();v++){
            if(!marked[v]){
                dfs(g,v);
            }
        }
    }

    private void dfs(Digraph g,int v){
        pre.add(v);
        marked[v] = true;
        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
