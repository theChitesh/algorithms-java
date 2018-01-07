
import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	
	private int data;
	private boolean visited;
	private List<Vertex> neighourList;
	
	
	public Vertex(int data){
		this.data = data;
		this.neighourList = new ArrayList<>();
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public boolean isVisited() {
		return visited;
	}


	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	public List<Vertex> getNeighourList() {
		return neighourList;
	}


	public void setNeighourList(List<Vertex> neighourList) {
		this.neighourList = neighourList;
	}

	public void addNeighbourVertex(Vertex vertex){
		this.neighourList.add(vertex);
	}
	
	@Override
	public String toString(){
		return "" + this.data;
	}
	
	
}
