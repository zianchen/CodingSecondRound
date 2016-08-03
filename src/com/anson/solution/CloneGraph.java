package com.anson.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenzian on 6/17/16.
 */
public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        dfs(cloneMap, node);
        return head;
    }
    public void dfs(Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap, UndirectedGraphNode node) {
        if (!cloneMap.containsKey(node)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            cloneMap.put(node, newNode);
        }
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!cloneMap.containsKey(neighbor)) {
                UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                cloneMap.put(neighbor, newNeighbor);
            }
            cloneMap.get(neighbor).neighbors.add(node);
            dfs(cloneMap, neighbor);
        }
    }
}
