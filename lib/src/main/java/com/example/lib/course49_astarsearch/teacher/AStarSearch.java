package com.example.lib.course49_astarsearch.teacher;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * A*算法，启发式搜索算法，改进于dijkstra算法（最短路径算法），能够更加高效的求取从顶点s到顶点i的路线，但这条路线不是最短路线，
 * 只是相对较短的路线，
 * 启发式搜索算法利用了求两点的曼哈顿距离，即启发函数，从而求出估价函数，通过估价函数避免跑偏路线，贪心的朝着最有可能到达终点的方向前进。
 */
public class AStarSearch {

    /**
     * 曼哈顿距离：两个顶点的纵横坐标的距离之和，计算如下：顶点s(x1,y2),i(x2,y2);
     * h(i) = Math.abs(x1 - x2) + Math.abs(y2 - y2);
     * <p>
     * <p>
     * 估价函数: f(i)
     * 启发函数(曼哈顿距离): h(i)
     * 起点s到终点i的路径长度: g(i)
     * f(i) = h(i) + g(i);
     * <p>
     * 用f(i)代替dijkstra算法中的两点距离，即g(i)，然后在while循环中只要遍历到顶点i就直接终止结束遍历
     * <p>
     * 加上曼哈顿距离主要是防止无效的遍历，现实中可以简单理解为直接往i点方向遍历，比如从s到i点，i在s点的东面，则
     * 直接往东方向寻找路线，而不是东南西北挨个方向去遍历，而且往东只要找到i点就行，并不需要遍历所有东方向可达i点的路线
     * 这有点类似贪心算法，虽然求得的结果不一定是最短路线，却能提高效率
     */

    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public AStarSearch(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边,s -> t
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }


    private class Vertex {
        public int id; // 顶点编号 ID
        public int dist; // 从起始顶点，到这个顶点的距离，也就是 g(i)
        public int f; // 新增：f(i)=g(i)+h(i)
        public int x, y; // 新增：顶点在地图中的坐标（x, y）

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.dist = Integer.MAX_VALUE;
        }
    }

    // Graph 类的成员变量，在构造函数中初始化
    Vertex[] vertexes = new Vertex[this.v];

    // 新增一个方法，添加顶点的坐标
    public void addVetex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
    }

    public void astar(int s, int t) { // 从顶点 s 到顶点 t 的路径
        int[] predecessor = new int[this.v]; // 用来还原路径
        // 按照 vertex 的 f 值构建的小顶堆，而不是按照 dist
        PriorityQueue<Vertex> queue = new PriorityQueue(this.v, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Vertex vertex1 = (Vertex) o1;
                Vertex vertex2 = (Vertex) o2;
                if (vertex1.f <= vertex2.f)
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条 minVetex 相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // 更新 next 的 dist,f
                    nextVertex.dist = minVertex.dist + e.w;
                    nextVertex.f
                            = nextVertex.dist + hManhattan(nextVertex, vertexes[t]);
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == t) { // 只要到达 t 就可以结束 while 了
                    queue.clear(); // 清空 queue，才能推出 while 循环
                    break;
                }
            }
        }
        // 输出路径
        System.out.print(s);
        print(s, t, predecessor); // print 函数请参看 dijkstra 算法的实现
    }

    int hManhattan(Vertex v1, Vertex v2) { // Vertex 表示顶点，后面有定义
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }


    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }


    public static void main(String[] args) {
//        参考AStart.jpg图片
        AStarSearch graph = new AStarSearch(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        graph.astar(0, 5);
    }


}
