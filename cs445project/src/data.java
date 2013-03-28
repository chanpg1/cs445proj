import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class data {

	private ArrayList<gNode> inputGraph;
	private ArrayList<qNode> queryGraph;
	private ArrayList<gPrimeNode> corrGraph;
	
	public data(){
		inputGraph = new ArrayList<gNode>();
		queryGraph = new ArrayList<qNode>();
		corrGraph = new ArrayList<gPrimeNode>();
	}
	
	public data(ArrayList<gNode> iGraph, ArrayList<qNode> qGraph, ArrayList<gPrimeNode> cGraph){
		inputGraph = iGraph;
		queryGraph = qGraph;
		corrGraph = cGraph;
	}

	public ArrayList<gNode> getInputGraph(){
		return inputGraph;
	}
	
	public ArrayList<qNode> getQueryGraph(){
		return queryGraph;
	}
	
	public ArrayList<gPrimeNode> getCorrGraph(){
		return corrGraph;
	}
	
	public void setInputGraph(ArrayList<gNode> iGraph){
		inputGraph = iGraph;
	}
	
	public void setQueryGraph(ArrayList<qNode> qGraph){
		queryGraph = qGraph;
	}
	
	public void setCorrGraph(ArrayList<gPrimeNode> cGraph){
		corrGraph = cGraph;
	}
	
	//Withdraw a gNode from inputGraph
	public gNode withdrawGNode(String name){
		Iterator<gNode> iter = inputGraph.iterator();
		gNode gn;
		//remove target gNode from inputGraph, then return it
		while(iter.hasNext()){
			gn = iter.next();
			if(gn.getName()==name){
				iter.remove();			
				return gn;				
			}
		}
		//if target gNode does not exist, returns null gNode with name = "-1"
		gn = new gNode(); 
		return gn;
	}
	
	//read in the input graph
	public ArrayList<gNode> readInputGraph(){		
		try{
		    	FileInputStream fstream = new FileInputStream("input");
		        DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		        String strLine;
		        while ((strLine = br.readLine()) != null)   {
		        	String[] tokens = strLine.split("\\s++");
		        	String nodeName = tokens[0];
		        	for(int i = 1; i < tokens.length; i++){
		        		gNode node = withdrawGNode(nodeName);
		        		gNode subNode = new gNode(tokens[i], new ArrayList<gNode>()); 
		        		if(node.getName()!="N/A"){
		        			node.getNextNodes().add(subNode);		        			
		        		}
		        		else{
		        			ArrayList<gNode> nodes = new ArrayList<gNode>();
		        			nodes.add(subNode);
		        			node = new gNode(nodeName, nodes);
		        		}
		        		inputGraph.add(node);
		        	}		        	
		        }
		   in.close();
		   }catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }
		return inputGraph;
	}
	
	//Withdraw a qNode from queryGraph
		public qNode withdrawQNode(String name){
			Iterator<qNode> iter = queryGraph.iterator();
			qNode qn;
			//remove target gNode from inputGraph, then return it
			while(iter.hasNext()){
				qn = iter.next();
				if(qn.getName()==name){
					iter.remove();			
					return qn;				
				}
			}
			//if target gNode does not exist, returns null gNode with name = "-1"
			qn = new qNode(); 
			return qn;
		}
	
	//read in the query graph
	public ArrayList<qNode> readQueryGraph(){		
		try{
		    	FileInputStream fstream = new FileInputStream("query");
		        DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		        String strLine;
		        int nodeNum = 1;
		        while ((strLine = br.readLine()) != null)   {
		        	String[] tokens = strLine.split("\\s++");
		        	String nodeName = tokens[0];		        	
		        	for(int i = 1; i < tokens.length; i++){
		        		qNode node = withdrawQNode(nodeName);
		        		qNode subNode = new qNode(i, tokens[i], new ArrayList<qNode>(), new ArrayList<gNode>()); 
		        		if(node.getName()!="N/A"){
		        			node.getNextNodes().add(subNode);		//TODO: add corrNodes        			
		        		}
		        		else{
		        			ArrayList<qNode> nodes = new ArrayList<qNode>();
		        			nodes.add(subNode);
		        			node = new qNode(nodeNum++, nodeName, nodes, new ArrayList<gNode>());  //TODO: add corrNodes  
		        		}
		        		queryGraph.add(node);
		        	}		        	
		        }
		   in.close();
		   }catch (Exception e){
		     System.err.println("Error: " + e.getMessage());
		   }
		return queryGraph;
	}
	
}
