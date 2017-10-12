package algorithm.graph.search;

import dataStructure.Graph;

/**
 * 基于DFS的连通分量计算
 * （由于需要预先生成完整的图，实际使用上的开销会大于 union-find算法
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;//连通分量

    public CC(Graph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for(int s = 0;s<g.V();s++){
            dfs(g,s);
            count++;//增加连通分量
        }
    }

    private void dfs(Graph g,int v){//遍历所有与v相邻的顶点，将其归纳到同一个连通分量
        marked[v] = true;       //将顶点置为已处理
        id[v] = count;
        for(int w:g.adj(v)){
            dfs(g,w);
        }
    }

    public boolean connected(int v,int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];//返回顶点v所在的连通分量
    }

    public int count(){
        return count;
    }
}
