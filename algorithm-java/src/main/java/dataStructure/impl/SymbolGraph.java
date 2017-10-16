package dataStructure.impl;

import dataStructure.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chenyubin
 * Date: 2017/10/11
 * Time: 13:37
 * Description
 * 符号图
 */
public class SymbolGraph {

    private Map<String, Integer> st;//正向索引，符号名 -> 索引
    private String[] keys;//反向索引，索引 -> 符号名
    private Graph g;

    /**
     *
     *
     */
    public SymbolGraph(String[] stream, String sp) {
        this.st = new HashMap<String, Integer>();

        for (String str : stream) { //第一次遍历，添加正向索引
            String[] a = str.split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.containsKey(a[i]))
                    st.put(a[i], st.size());
            }
        }

        keys = new String[st.size()];
        for(String name : st.keySet()){//构建反向索引
            keys[st.get(name)] = name;
        }

        g = new SimpleGraph(st.size());
        for (String str : stream) { //第二次遍历，构建图
            String[] a = str.split(sp);
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                g.addEdge(v,st.get(a[i]));
            }
        }

    }

    public boolean contains(String s){
        return st.containsKey(s);
    }

    public int index(String s){
        return st.get(s);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph g(){
        return g;
    }
}
