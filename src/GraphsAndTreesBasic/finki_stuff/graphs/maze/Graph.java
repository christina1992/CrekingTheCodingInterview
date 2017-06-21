package GraphsAndTreesBasic.finki_stuff.graphs.maze;

public class Graph {
	
	int num_nodes; // broj na jazli
    int adjMat[][];  // matrica na sosednost
    
	public Graph(int num_nodes) {
		this.num_nodes = num_nodes;
		adjMat = new int[num_nodes][num_nodes];
		
		for(int i=0;i<this.num_nodes;i++)
			for(int j=0;j<this.num_nodes;j++)
				adjMat[i][j]=0;
	}

	public Graph(int num_nodes, int[][] adjMat) {
		this.num_nodes = num_nodes;
		this.adjMat = adjMat;
	}


	int adjacent(int x,int y)
	{  // proveruva dali ima vrska od jazelot so indeks x do jazelot so indeks y
	   return (adjMat[x][y]!=0)?1:0;
	}
	
	void addEdge(int x,int y)
	{  // dodava vrska megu jazlite so indeksi x i y
	   adjMat[x][y]=1;
	   adjMat[y][x]=1;
	}
	
	void deleteEdge(int x,int y)
	{
	   // ja brise vrskata megu jazlite so indeksi x i y
	   adjMat[x][y]=0;
	   adjMat[y][x]=0;
	}
	
	public int getNum_nodes() {
		return num_nodes;
	}

	public void setNum_nodes(int num_nodes) {
		this.num_nodes = num_nodes;
	}



	@Override
	public String toString() {
		String ret="  ";
		for(int i=0;i<num_nodes;i++)
			ret+=i+" ";
		ret+="\n";
		for(int i=0;i<num_nodes;i++){
			ret+=i+" ";
			for(int j=0;j<num_nodes;j++)
				ret+=adjMat[i][j]+" ";
			ret+="\n";
		}
		return ret;
	}
	
	
}
