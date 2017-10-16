package dataStructure.impl;

import dataStructure.Digraph;

/**
 * Author: chenyubin
 * Date: 2017/10/16
 * Time: 14:43
 * Description
 * 《算法》P365
 */
public class SimpleDigraph extends Digraph {

    private int v;
    private int e;
    private Bag<Integer>[] adj;

    public SimpleDigraph(int v){
        this.v = v;
        this.e = 0;
        adj = new Bag[v];
        for(int i = 0;i<v;i++){
            adj[i] = new Bag<Integer>();
        }
    }

    @Override
    public int v() {
        return v;
    }

    @Override
    public int e() {
        return e;
    }

    @Override
    public void addEdge(int v, int w) {
        //
        adj[v].add(w);
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverse() {
        Digraph r = new SimpleDigraph(v);
        for(int i =0 ;i<v;i++){
            for(int w:adj(i)){
                r.addEdge(w,v);
            }
        }
        return r;
    }
}
