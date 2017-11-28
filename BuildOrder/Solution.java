/**
 * Solution
 */

/**
 * GraphNode
 */
 import java.util.*;
class GraphNode {
    String data;
    HashMap<String, GraphNode> children;


    int num_requirements; 
    boolean visited;
    public GraphNode(String data){
        this.data = data;
        this.children = new HashMap<String, GraphNode>();
    }

    void completeReq(){
        this.num_requirements--;
        if(this.num_requirements == 0)
            visited = true;
    }

    void addChildren(GraphNode node){
        this.children.put(node.data, node);
    }

    void addChildren(String data){
        addChildren(new GraphNode(data));
    }
    void addMultipleChildren(GraphNode[] nodes){
        for(GraphNode node : nodes){
            addChildren(node);
        }
    }
}


class Graph{
    HashMap<String, GraphNode> nodes;

    public Graph(){
        this.nodes = new HashMap<String, GraphNode>();
    }
    public GraphNode getOrCreate(String data){
        if(nodes.containsKey(data)){
            return nodes.get(data);
        }
        GraphNode new_node = new GraphNode(data);
        nodes.put(data, new_node);
        return new_node;
    }

    public void insertNode(GraphNode node){
        if(!nodes.containsKey(node.data)){
            nodes.put(node.data, node);
        }
    }
}


public class Solution {
    
    static public Graph buildGraph(GraphNode[] nodes, GraphNode[][] reqs){
        // Initial graph
        Graph graph = new Graph();

        // Create starter node
        GraphNode start = new GraphNode("Start");
        start.addMultipleChildren(nodes);

        /* For every set of reqs: Append The second element to the list of children of the first element
        * and remove the second element from the children of the starter node */

        return graph;

    }

    public static void main(String[] args) {
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");

        // Create req tuples
        GraphNode[] nodes = {A, B, C, D, E, F};
        GraphNode[][] reqs = {{A,D}, {F,B}, {B,D}, {B,D}, {F,A}, {D,C}};
        Graph graph = buildGraph(nodes, reqs);
    }
}