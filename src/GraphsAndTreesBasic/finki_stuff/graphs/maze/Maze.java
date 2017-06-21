package GraphsAndTreesBasic.finki_stuff.graphs.maze;

import java.util.Hashtable;
import java.util.Stack;

public class Maze {
	
	//Kje se koristi nenasocen graf implementiran so martica na sosednost
	//za pretstavuvanje na lavirintot
	//Teminjata vo grafot se samo indeksi
	//Iminjata na teminjata se preveduvaat vo broevi preku hash tabela
	//T.e. na pr. 1,1 kje se prevede vo 1 (1,1 kje se zacuva kako string)
	
	Graph g; 
	int start_node; //indeks temeto koe e vlez
	int end_node; //indeks na temeto koe e izlez
	
	Hashtable<String,Integer> h;
	
	public Maze() {
		h = new Hashtable<String,Integer>();
	}

	void generateGraph(int rows, int columns, String[] in){
		
		int num_nodes = 0;
		
		String key;
		
		for(int i=1; i<rows; i++){
			for(int j=1; j<columns; j++){
				if(in[i].charAt(j)!='#'){
					key = i+","+j;
					h.put(key, num_nodes);
					if(in[i].charAt(j)=='S')
						start_node = num_nodes;
					if(in[i].charAt(j)=='E')
						end_node = num_nodes;
					num_nodes++;
				}
			}
		}
		
		g = new Graph(num_nodes);
		
		int x;
		int y;
		//generiranje na matrica na sosednost
		for(int i=1; i<rows; i++){
			for(int j=1; j<columns; j++){
				if(in[i].charAt(j)!='#'){
					//dali ima teme pred nego
					if(in[i].charAt(j-1)!='#'){
						x = h.get(i+","+j);
						y = h.get(i+","+(j-1));
						g.addEdge(x, y);
					}
					//dali ima teme posle nego
					if(in[i].charAt(j+1)!='#'){
						x = h.get(i+","+j);
						y = h.get(i+","+(j+1));
						g.addEdge(x, y);
					}
					//dali ima teme nad nego
					if(in[i-1].charAt(j)!='#'){
						x = h.get(i+","+j);
						y = h.get((i-1)+","+j);
						g.addEdge(x, y);
					}
					//dali ima teme pod nego
					if(in[i+1].charAt(j)!='#'){
						x = h.get(i+","+j);
						y = h.get((i+1)+","+j);
						g.addEdge(x, y);
					}				
				}				
			}
		}		
	}
	
	void findPath(){
		boolean visited[] = new boolean[g.getNum_nodes()];
		for (int i = 0; i < g.getNum_nodes(); i++)
			visited[i] = false;
		visited[start_node] = true;
		Stack<Integer> s = new Stack<Integer>();
		s.push(start_node);

		int pom;
		while (!s.isEmpty() && s.peek()!=end_node) {
			pom = s.peek();
			int pom1 = pom;
			for (int i = 0; i < g.getNum_nodes(); i++) {
				if(g.adjacent(pom,i)==1){
					pom1 = i;
					if(!visited[i])
						break;
				}			
			}
			if(!visited[pom1]){
				visited[pom1] = true;
				//System.out.println(tmp.getIndex() + ": " + tmp.getInfo());
				s.push(pom1);
			}
			else
				s.pop();
		}
		if(s.isEmpty())
			System.out.println("Nema reshenie");
		else{
			Stack<Integer> os = new Stack<Integer>();
			while(!s.isEmpty())
				os.push(s.pop());
			while(!os.isEmpty())
				System.out.println(os.pop());
		}
	}
	
	
	
	public static void main(String args[]){
		Maze m = new Maze();
		int rows = 6;
		int columns = 6;
		String[] in = new String[rows];
		
		in[0] = "######";
		in[1] = "# # ##";
		in[2] = "# # S#";
		in[3] = "# # ##";
		in[4] = "# E  #";
		in[5] = "######";
		
		m.generateGraph(rows, columns, in);
		System.out.println("Pateka:");
		m.findPath();	
	}

}
