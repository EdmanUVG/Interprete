
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] memory = new Integer[] {0,1,2,3,2,1,3,2,1,1,2,3,2,1,0,0,2,3,2,1,3,2,1,1,0,0,0,4,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int start = 0;
		
		Interp interprete = new Interp(memory,start);
		interprete.Interpret();
		
		
	}

}
