package dataStructure;

/**
 * Author: chenyubin
 * Date: 2017/10/16
 * Time: 14:35
 * Description
 * 有向图
 */
public abstract class Digraph {

    /**
     * 顶点总数
     * @return
     */
    public abstract int v();

    /**
     * 边总数
     * @return
     */
    public abstract int e();

    /**
     * 向图中添加一条边
     * v -> w
     * @param v
     * @param w
     */
    public abstract void addEdge(int v,int w);

    /**
     * 由v指出的边所连接的所有顶点
     * @param v
     * @return
     */
    public abstract Iterable<Integer> adj(int v);

    /**
     * 获取该图的反向图
     * @return
     */
    public abstract Digraph reverse();
}
