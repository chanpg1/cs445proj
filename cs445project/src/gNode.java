import java.util.ArrayList;

//A node in the large graph G that we match against 
public class gNode {

	//private int id;
	private String name;
	private ArrayList<gNode> nextNodes;
	
	public gNode(){
		name = "N/A";
		nextNodes = new ArrayList<gNode>();		
	}
	
	public gNode(String nName, ArrayList<gNode> gNodes){
		
		name = nName;
		nextNodes = gNodes;		
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<gNode> getNextNodes(){
		return nextNodes;
	}
	
	public void setName(String nName){
		name = nName;
	}
	
	public void setNextNodes(ArrayList<gNode> gNodes){
		nextNodes = gNodes;
	}

}
