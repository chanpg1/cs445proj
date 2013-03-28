import java.util.ArrayList;

//Class for a node in query path
public class qNode {
	private int nodeNum;
	private String name;
	private ArrayList<qNode> nextNodes;
	private ArrayList<gNode> corrNodes; //list of corresponding nodes in G
	
	public qNode(){
		nodeNum = -1;
		name = "N/A";
		nextNodes = new ArrayList<qNode>();
		corrNodes = new ArrayList<gNode>();			
	}
	
	public qNode(int nNum, String nName, ArrayList<qNode> qNodes, ArrayList<gNode> gNodes){
		nodeNum = nNum;
		name = nName;
		nextNodes = qNodes;
		corrNodes = gNodes;			
	}
	
	public int getNodeNum(){
		return nodeNum;
	}
	
	public String getName(){
		return name;
	}
	
	//return nodes that this node points to
	public ArrayList<qNode> getNextNodes(){
		return nextNodes;
	}
	
	//return corresponding nodes in G
	public ArrayList<gNode> getCorrNodes(){
		return corrNodes;
	}
	
	public void setNodeNum(int num){
		nodeNum = num;
	}
	
	public void setName(String nName){
		name = nName;
	}
	
	public void setNextNodes(ArrayList<qNode> qNodes){
		nextNodes = qNodes;
	}
	
	public void setCorrNodes(ArrayList<gNode> gNodes){
		corrNodes = gNodes;
	}
}
