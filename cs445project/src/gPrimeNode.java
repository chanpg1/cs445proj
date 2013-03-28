import java.util.ArrayList;

//Class for a node in the G' graph, i.e. a node from large graph G that correspond to query graph p
public class gPrimeNode {
	private String name;
	private ArrayList<gPrimeNode> nextNodes;
	private int id1;  //identify node level
	private int id2;  //identify node's number at that level
	
	public gPrimeNode(){
		this.name = "";
		nextNodes = new ArrayList<gPrimeNode>();
		id1 = -1;
		id2 = -1;
	}
	
	public gPrimeNode(String id, ArrayList<gPrimeNode> next, int n1, int n2){
		this.name = id;
		this.nextNodes = next;
		this.id1 = n1;
		this.id2 = n2;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<gPrimeNode> getNextNodes(){
		return nextNodes;
	}
	
	public int getId1(){
		return id1;
	}
	
	public int getId2(){
		return id2;
	}
	
	public void setname(String name){
		this.name = name;
	}
	
	public void setNextNodes(ArrayList<gPrimeNode> next){
		this.nextNodes = next;
	}
	public void setId1(int n1){
		this.id1 = n1;
	}
	
	public void setId2(int n2){
		this.id2 = n2;
	}
	
}
