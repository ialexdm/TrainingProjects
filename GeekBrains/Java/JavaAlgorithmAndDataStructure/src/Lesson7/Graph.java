package Lesson7;


import java.util.LinkedList;
import java.util.Queue;

public  class Graph{
    private static final int MAX_VERTEXES = 32;
    private Vertex[] vertexes;
    private int[][] adjustMatrix;
    private int size;

    public Graph(){
        vertexes = new Vertex[MAX_VERTEXES];
        adjustMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        size = 0;
        for(int i = 0; i < MAX_VERTEXES; i++){
            for(int j = 0; j < MAX_VERTEXES; j++){
                adjustMatrix[i][j]	 = 0;
            }
        }
    }
    public void addVertex(char label){
        vertexes[size++] = new Vertex(label);
    }
    public void addEdge(int start, int end){
        adjustMatrix[start][end] = 1;
        adjustMatrix[end][start] = 1;
    }
    public void displayVertex(int vertex){
        System.out.println(vertexes[vertex].label);
    }
    private int getAdjustUnvisitedVertex(int vertex){
        for(int i=0; i< size; i++){
            if(adjustMatrix[vertex][i] == 1 && vertexes[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void dfs(int f){
        vertexes[f].wasVisited = true;
        for (int i = 0; i < size; i++){
            int v = getAdjustUnvisitedVertex(f);
            if (!vertexes[i].wasVisited && v!=-1 && i==v){
                fullDisplayVertex(f, v);
                dfs(i);
            }
        }
    }



    public void bfs(int v){
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;

        vertexes[v].wasVisited = true;
        queue[qT++] = v;

        displayVertex(0);

        int v2;
        while (qH < qT){
            v = queue[qH++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjustUnvisitedVertex(v);
                if (!vertexes[i].wasVisited && v2 != -1){
                    vertexes[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        resetVisited();
    }
    public void resetVisited(){
        for (int i = 0; i < size; i++) {
            vertexes[i].wasVisited = false;
        }
    }

    private void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.printf("Вершины %s - %s\n", vertexes[vertex1].label, vertexes[vertex2].label);
    }

    public  class Vertex{
        public char label;
        public boolean wasVisited;
        public Vertex(char label){
            this.label = label;
            this.wasVisited = false;
        }
    }

}
