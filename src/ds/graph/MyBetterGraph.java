package ds.graph;

import java.util.ArrayList;

import ds.graph.BetterGraph.Node;


// DOES NOT WORK



public class MyBetterGraph {
	private int vCount; // number of vertices
	private int numOfVertices = 0;
	private int eCount; // Number of edges
	
	private Vertex[] arrayOfLists; // array of integer lists
	
	class Node{
		
		public int vertexIndex;
		public Node next;
		
		public Node(int vertexIndex, Node nextNode){
			this.vertexIndex = vertexIndex;
			this.next = nextNode;
		}
	}
	
	class Vertex {
		
		String name;
		Node adjacentList;
		
		public Vertex(String name, Node node) {
			this.name = name;
			this.adjacentList = node;
		}
		
	}
	
	public MyBetterGraph(int vCount){
		this.vCount = vCount;
		this.eCount = 0;
		arrayOfLists = new Vertex[vCount];
		
		/*for(int i = 0; i < vCount; i++){
			arrayOfLists[i] = new ArrayList();
		}*/
	}
	
	public int getVertexCount(){
		return vCount;
	}
	
	public int getEdgeCount(){
		return eCount;
	}
	
	public void addVertex(String vertex){
		
		arrayOfLists[numOfVertices] = new Vertex(vertex, null);
		numOfVertices++;
	}
	
	public boolean addEdge(String vertex, String edge){
		
		// find the correct vertex
		int index = 0;
		int vertexIndex = -1;
		int edgeIndex = -1;
		
		// get the index for the vertex and the edge
		while(vertexIndex < 0 || edgeIndex < 0) {

			// set the index for the vertex
			if(arrayOfLists[index].name.equals(vertex))
				vertexIndex = index;
			
			// set the index for the edge
			if(arrayOfLists[index].name.equals(edge))
				edgeIndex = index;
				
			index++;
				
			// if all vertices checked 
			if(index >= vCount)
				return false;
		}
		
		arrayOfLists[edgeIndex].adjacentList = new Node(vertexIndex, arrayOfLists[edgeIndex].adjacentList);
		
		
		eCount++;
		return true;
	}
	
	public Vertex adj(int src){
		return arrayOfLists[src];
	}

	/*public void print() {

		for(Vertex  vertex: arrayOfLists) {
			System.out.print(vertex.name);
			Node node = vertex.adjacentList;
			while(node != null) {
				System.out.print(" --> "+arrayOfLists[node.vertexId].name);
			}
			System.out.println();
		}
		
	}*/   
    
   public void print() {
       System.out.println();
       for (int v=0; v < arrayOfLists.length; v++) {
           System.out.print(arrayOfLists[v].name);
           for (Node aNode = arrayOfLists[v].adjacentList; aNode != null; aNode = aNode.next) {
               System.out.print(" --> " + arrayOfLists[aNode.vertexIndex].name);
           }
           System.out.println("\n");
       }
   }

}
