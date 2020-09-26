

public class Edge 
{
	protected int nodo1;
	protected int nodo2;
	
	public Edge(int n1, int n2){
		nodo1 = n1;
		nodo2 = n2;
	}
	
	public int getNodo1(){
		return nodo1;
	}
	
	public int getNodo2(){
		return this.nodo2;
	}
	
	public void setNodes(int n1, int n2){
		nodo1 = n1;
		nodo2 = n2;
	}
}
