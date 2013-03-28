import java.util.ArrayList;
import java.util.Iterator;


public class execute {
	private static data dat = new data();
	
	public static void testReadInputGraph(){
		
		ArrayList<gNode> inputGraph = dat.readInputGraph();
		Iterator<gNode> iter = inputGraph.iterator();
		int count = 0;
		gNode node;
		while(iter.hasNext()){
			node  = iter.next();
			String name = node.getName();
			ArrayList<gNode> subNodes = node.getNextNodes();
			for(gNode g:subNodes){
				name = name + " " + g.getName();
			}
			System.out.println(++count+": "+name);
		}
	}
	
	public static void testReadQueryGraph(){
		//TODO read corrGraph also
		ArrayList<qNode> queryGraph = dat.readQueryGraph();
		Iterator<qNode> iter = queryGraph.iterator();
		int count = 0;
		qNode node;
		while(iter.hasNext()){
			node  = iter.next();
			String name = node.getName();
			ArrayList<qNode> subNodes = node.getNextNodes();
			for(qNode q:subNodes){
				name = name + " [" + node.getNodeNum()+","+q.getNodeNum()+"]"+q.getName();
			}
			System.out.println(++count+": "+name);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testReadInputGraph();
		testReadQueryGraph();
				
	}

}
