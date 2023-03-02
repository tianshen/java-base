package com.example.base.数据结构和算法.书籍.图;


/**
 * @author jiwei.xue
 * @date 2021/1/7 18:12
 */
public class Graph {

    private final int MAX_VERTS = 20;

    private Vertex[] vertexList;

    private int[][] adjMat;

    private int nVerts;

    private StackX theStackX;

    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theStackX = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    /**
     * 深度优先算法
     */
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStackX.push(0);

        while (!theStackX.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStackX.peek());
            if (v == -1) {
                theStackX.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStackX.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    /**
     * 广度优先算法
     */
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }


    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }
}