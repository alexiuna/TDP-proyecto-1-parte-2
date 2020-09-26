

public class Tester 
{
	public static void main(String[] args) 
	{
		//Crea el grafo.
		Graph grafo = new Graph();
		
		//Agrega nodos nuevos.
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		
		//Agrega arcos nuevos.
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 1);
		grafo.addEdge(2, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(4, 3);
		
		//Agrega un nodo ya existentes.
		grafo.addNode(2);
		
		//Agrega un arco ya existentes.
		grafo.addEdge(1, 2);
		
		//Elimina Arcos ya existentes.
		grafo.removeEdge(2, 1);
		
		//Elimina un Nodo ya existente.
		grafo.removeNode(2);
		
		//Elimina un Arco NO existente.
		grafo.removeEdge(4, 1);
				
		//Elimina un Nodo NO existente.
		grafo.removeNode(2);
		
		
	}
}
