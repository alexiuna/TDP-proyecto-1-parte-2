import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph 
{
	protected Map<Integer, Nodo> nodes;
	protected Map<String, Edge> edges;
	private static Logger logger;
	
	
	public Graph(){
		this.nodes = new HashMap<Integer, Nodo>();
		this.edges = new HashMap<String, Edge>();
		//Edge es una clase que encapsula dos enteros para representar un arco.
		
		if (logger == null){
			logger = Logger.getLogger(Graph.class.getName());
			
			logger.setLevel(Level.INFO);
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.WARNING);
			logger.addHandler(hnd);
			
			
			//Setea el nivel del logger padre como "OFF", evitando que tambien muestre mensajes.
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}	
	}
	
	
	public void addNode(int node){
		boolean estaN = this.nodes.containsKey(node);
		//De acuerdo al valor de estaN se sabe si node es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN es falso o verdadero.
		if(!estaN){
			Nodo nodo = new Nodo(node);
			Nodo value = this.nodes.put(node, nodo);
			
			if(value==null){
				//Significa que el nodo no estaba.
				logger.info("El nodo "+node+" fue agregado a la estructura.");
			}
		}
		else{
			//Significa que el nodo ya estaba.
			logger.warning("El nodo "+node+" ya existe en la estructura.");
		}
	}
	
	
	public void addEdge(int node1, int node2){
		boolean estaN1 = this.nodes.containsKey(node1);
		//De acuerdo al valor de estaN1 se sabe si node1 es un nodo que esta en la ED o no.
		boolean estaN2 = this.nodes.containsKey(node2);
		//De acuerdo al valor de estaN2 se sabe si node2 es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN1 es falso o verdadero y lo mismo para estaN2.
		if(estaN1 && estaN2){
			Edge edge = new Edge(node1, node2);
			String key = node1 + "," + node2;
			Edge value = this.edges.put(key, edge);
			
			if(value!=null){
				//Significa que el arco ya estaba
				logger.warning("El arco que va desde "+node1+" a "+node2+" ya existe en la estructura.");
			}
			else{
				//Significa que el arco no estaba
				logger.info("El arco que va desde "+node1+" a "+node2+" fue agregado a la estructura.");
			}
		}
		else{
			logger.warning("Uno o ambos nodos, "+node1+" y "+node2+", no pertenecian a la estructura");
		}
	}
	
	
	public void removeNode(int node){
		boolean estaN = this.nodes.containsKey(node);
		//De acuerdo al valor de estaN se sabe si node es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN es falso o verdadero.
		if(estaN){
			LinkedList<String> copia= new LinkedList<String>();
			
			for (Edge arquito: edges.values()) {
				if(arquito.getNodo1()==node|| arquito.getNodo2()==node) {
					String key = arquito.getNodo1() + "," + arquito.getNodo2();
					copia.add(key);	
				}
			}
			for(String llavecita : copia) {
				edges.remove(llavecita);
			}
			Nodo value = this.nodes.remove(node);
			
			if(value!=null){
				//Significa que el nodo ya estaba.
				logger.info("El nodo "+node+" fue eliminado de la estructura.");
			}
		}
		else{
			//Significa que el nodo no estaba.
			logger.warning("El nodo "+node+" no existe en la estructura.");
		}
	}
	
	
	public void removeEdge(int node1, int node2){
		boolean estaN1 = this.nodes.containsKey(node1);
		//De acuerdo al valor de estaN1 se sabe si node1 es un nodo que esta en la ED o no.
		boolean estaN2 = this.nodes.containsKey(node2);
		//De acuerdo al valor de estaN2 se sabe si node2 es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN1 es falso o verdadero y lo mismo para estaN2.
		if(estaN1 && estaN2){
			String key = node1 + "," + node2;
			Edge value = this.edges.remove(key);
			
			if(value!=null){
				//Significa que el arco ya estaba
				logger.info("El arco que va desde "+node1+" a "+node2+" fue removido de la estructura.");
			}
			else{
				//Significa que el arco no estaba
				logger.warning("El arco que va desde "+node1+" a "+node2+" no existia en la estructura.");
			}
		}
		else{
			logger.warning("Uno o ambos nodos, "+node1+" y "+node2+", no pertenecian a la estructura");
		}
	}
}
