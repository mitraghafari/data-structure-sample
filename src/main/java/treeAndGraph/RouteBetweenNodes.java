package treeAndGraph;

import java.util.*;

class GraphNode {
    String name;
    List<GraphNode> neighbors;

    public GraphNode(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }
}

public class RouteBetweenNodes {
    public enum State { Unvisited, Visiting, Visited }

    public static boolean search(GraphNode start, GraphNode end) {
        if (start == end) return true;

        LinkedList<GraphNode> queue = new LinkedList<>();
        HashMap<GraphNode, State> visited = new HashMap<>();

        for (GraphNode node : getAllNodes(start)) {
            visited.put(node, State.Unvisited);
        }

        queue.add(start);
        visited.put(start, State.Visiting);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();

            if (current == end) return true;

            for (GraphNode neighbor : current.neighbors) {
                if (visited.get(neighbor) == State.Unvisited) {
                    visited.put(neighbor, State.Visiting);
                    queue.add(neighbor);
                }
            }

            visited.put(current, State.Visited);
        }

        return false;
    }

    private static Set<GraphNode> getAllNodes(GraphNode start) {
        Set<GraphNode> nodes = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if (!nodes.contains(node)) {
                nodes.add(node);
                queue.addAll(node.neighbors);
            }
        }

        return nodes;
    }
}
