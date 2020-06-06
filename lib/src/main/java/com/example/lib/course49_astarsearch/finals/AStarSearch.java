package com.example.lib.course49_astarsearch.finals;

import com.example.lib.course62_exercise.graph.Edge;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A*算法，启发式搜索算法，改进于dijkstra算法（最短路径算法），能够更加高效的求取从顶点s到顶点i的路线，但这条路线不是最短路线，
 * 只是相对较短的路线，
 * 启发式搜索算法利用了求两点的曼和顿距离，即启发函数，从而求出估价函数，通过估价函数避免跑偏路线，贪心的朝着最有可能到达终点的方向前进。
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


    // 地图中求两个位置的最短行驶路径：将每个路口视为一个顶点，路视为有向边，路的长度为边的权重，整个地图是一个有向有权图的数据结构
    // 这样实际问题就转化为可编程问题求解了


    private int v = 11; // 顶点个数
    private LinkedList<Edge>[] adj; // 邻接表-用来表示图的结构
    private ArrayList<Point> mPointArrayList;

    public AStarSearch() {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            // i是起始顶点的编号，列表保存从起始顶点i出发的所有边
            adj[i] = new LinkedList<>();
        }
        init();
    }

    public void init() {
        //        参考AStart.jpg图片
        // 这里忽略11,12,13这三个点
        mPointArrayList = new ArrayList<>();
        Point point0 = new Point(0, 320, 630);
        Point point1 = new Point(1, 300, 630);
        Point point2 = new Point(2, 280, 625);
        Point point3 = new Point(3, 270, 630);
        Point point4 = new Point(4, 320, 700);
        Point point5 = new Point(5, 360, 620);
        Point point6 = new Point(6, 320, 590);
        Point point7 = new Point(7, 370, 580);
        Point point8 = new Point(8, 350, 730);
        Point point9 = new Point(9, 390, 690);
        Point point10 = new Point(10, 400, 620);
        mPointArrayList.add(point0);
        mPointArrayList.add(point1);
        mPointArrayList.add(point2);
        mPointArrayList.add(point3);
        mPointArrayList.add(point4);
        mPointArrayList.add(point5);
        mPointArrayList.add(point6);
        mPointArrayList.add(point7);
        mPointArrayList.add(point8);
        mPointArrayList.add(point9);
        mPointArrayList.add(point10);

        addEdge(point0, point1, 20);
        addEdge(point0, point4, 60);
        addEdge(point0, point5, 60);
        addEdge(point0, point6, 60);
        addEdge(point1, point2, 20);
        addEdge(point2, point3, 10);
        addEdge(point3, point4, 80);
        addEdge(point3, point6, 80);
        addEdge(point4, point8, 50);
        addEdge(point5, point8, 70);
        addEdge(point5, point9, 80);
        addEdge(point5, point10, 50);
        addEdge(point6, point7, 70);
        addEdge(point7, point10, 110);
        addEdge(point8, point9, 50);
        addEdge(point9, point10, 60);
    }

    /**
     * 往图中添加一条边
     *
     * @param startPoint 起始顶点
     * @param endPoint   终止顶点
     * @param w          边的权重
     */
    public void addEdge(Point startPoint, Point endPoint, int w) {
    }

    /**
     * 求从顶点s到t的相对较短路径路径(打印出来)
     *
     * @param startPoint 其实顶点
     * @param endPoint   终止顶点
     */
    public void astart(Point startPoint, Point endPoint) {
    }

    private void printRoad(Point s, Point t, Point[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t.s], preVertex);
        System.out.print("->" + t.s);
    }

    /**
     * 求两个顶点的曼哈顿距离
     *
     * @return
     */
//    int hManhattan(Vertex v1, Vertex v2) { // Vertex 表示顶点
//    }

    public static void main(String[] args) {
        //        参考AStart.jpg图片
        // 这里忽略11,12,13这三个点


        AStarSearch myAStartSearch = new AStarSearch();


        // 求相对较短路径,0点到10点
        myAStartSearch.astart(myAStartSearch.mPointArrayList.get(0), myAStartSearch.mPointArrayList.get(10));
    }


}
