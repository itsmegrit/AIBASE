import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_DFS {
  private int numOfVertices;

  private LinkedList<LinkedList<Integer>> AdjacencyList;

  // Constructor
  BFS_DFS(int numberOfVertices) {
    this.numOfVertices = numberOfVertices;
    this.AdjacencyList = new LinkedList<LinkedList<Integer>>();
    for (int i = 0; i < this.numOfVertices; i++) {
      this.AdjacencyList.add(new LinkedList<Integer>());
    }
  }

  // addEdge
  public void addEdge(int source, int destination) {
    this.AdjacencyList.get(source).add(destination);
    this.AdjacencyList.get(destination).add(source);
  }

  // printGraph
  public void printGraph() {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        System.out.print("Vertex [" + i + "] AdjList: ");
        for (int neighbor : this.AdjacencyList.get(i)) {
          System.out.print(" -> " + neighbor);
        }
        System.out.println();
      }
    }
  }

  // BFS
  public void BFS(int start) {
    boolean[] isVisited = new boolean[this.numOfVertices];
    for (int i = 0; i < this.numOfVertices; i++) {
      isVisited[i] = false;
    }
    isVisited[start] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    Queue<Integer> rsq = new LinkedList<>();

    while (queue.isEmpty() == false) {
      int vertext = queue.peek();
      rsq.add(vertext);
      queue.remove();
      for (int neighbor : this.AdjacencyList.get(vertext)) {
        if (isVisited[neighbor] == false) {
          queue.add(neighbor);
          isVisited[neighbor] = true;
        }
      }
    }
    System.out.println("Thu tu duyet (BFS): " + rsq.toString());
  }

  public void DFS(int st) {
    boolean[] visit = new boolean[this.AdjacencyList.size()];
    for (int i = 0; i < visit.length; i++) {
      visit[i] = false;
    }
    Stack<Integer> s = new Stack<Integer>();
    s.add(st);
    visit[st] = true;
    Stack<Integer> rss = new Stack<Integer>();
    while (!s.isEmpty()) {
      int vertext = s.peek();
      s.pop();
      rss.push(vertext);
      for (int neighbor : this.AdjacencyList.get(vertext)) {
        // if (visit[neighbor]) {
        // continue;
        // }
        if (!visit[neighbor]) {
          s.push(neighbor);
          visit[neighbor] = true;
        }
      }
    }
    System.out.println("Thu tu duyet (DFS): " + rss.toString());
  }
}
