import java.util.Date;

public class Interp {
	
	private int PC;
	private int AC;
	private int instr;
	private int instr_type;
	private int data_loc;
	private int data;
	private boolean run_bit;
	private Integer[] memory;
	private int starting_address;
	private Date hora = new Date();
	private int siguiente;
	private int put;
	
	public Interp(Integer[] memory,int starting_address) {
		PC = 0;
		AC = 0;
		instr = 0;
		instr_type = 0;
		data_loc = 0;
		data = 0;
		run_bit = true;
		this.memory = memory;
		this.starting_address = starting_address;
		siguiente = 0;
		put = 0;
		
	}
	
	public void Interpret () {
		memory[25] = hora.getHours();
		memory[26] = hora.getMinutes();
		PC = starting_address;
		while(run_bit) {
			instr = memory[PC];
			PC++;
			instr_type = get_instr_type(instr);
			data_loc = find_data(instr,instr_type);
			if (data_loc >= 0)
				data = memory[data_loc];
			execute(instr_type,data);
		}
	}
	
	
	private int get_instr_type(int addr) {
		return addr;
	}
	
	private int find_data(int instr,int type) {
		siguiente = PC + 27;
		put = siguiente + 1;
		return PC + 26;
	}
	
	private void execute(int type, int data) {
		int resultado = 0;
		
		if (put == 49) 
			run_bit = false;
		
		if (put <= 49) {
			switch(type) {
			
			case 0:
				resultado = data + memory[siguiente];
				memory[put] = Math.abs(resultado);
				break;
			case 1:
				resultado = data - memory[siguiente];
				memory[put] = Math.abs(resultado);
				break;
			case 2:
				resultado = data * memory[siguiente];
				memory[put] = Math.abs(resultado);
				break;
			case 3:
				try {
				resultado = data / memory[siguiente];
				if (resultado == 0) {
					memory[put] = (int) (Math.random()*3 + 1);
				}else {
					memory[put] = Math.abs(resultado);
				}
				
				}catch (Exception ex) {
					memory[put] = 1;
				}
				
				
				break;
			}
			
			System.out.print("[");
			for (int o:memory) {
				System.out.print(o + ",");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	

}
