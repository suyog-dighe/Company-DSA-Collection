package AmazonGoogle;
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class cloneGraph {
    public static Node clone(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        return newcloneGraph(node, map);
    }

    public static Node newcloneGraph(Node node, HashMap<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neigh : node.neighbors) {
            copy.neighbors.add(newcloneGraph(neigh, map));
        }
        return copy;
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node[] nodes = new Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i <= adjList.length; i++) {
            for (int neighbor : adjList[i - 1]) {
                nodes[i].neighbors.add(nodes[neighbor]);
            }
        }
        Node clonedGraph = clone(nodes[1]);
        System.out.println("Original Graph:");
        printGraph(nodes[1]);
        System.out.println("\nCloned Graph:");
        printGraph(clonedGraph);
    }

    public static void printGraph(Node node) {
        if (node == null) {
            return;
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print("Node " + n.val + " neighbors: ");
            for (Node neigh : n.neighbors) {
                System.out.print(neigh.val + " ");
                if (!visited.contains(neigh)) {
                    queue.add(neigh);
                    visited.add(neigh);
                }
            }
            System.out.println();
        }
    }
}