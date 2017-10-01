import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		//menu
		Cinta cinta = new Cinta();
		int opc = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("1. Introducir cadena por teclado");
		System.out.println("2. Introducir cadena por fichero");
		System.out.print(">_");
		opc = in.nextInt();
		
		//Introducir cinta
		
		if(opc == 1) { //leer por teclado
			System.out.print("Cadena a procesar: ");
			cinta = new Cinta(in.next());
			cinta.mostrarCinta();
			System.out.println("tamano cinta " + cinta.getCinta().size());
		}
		else { //leer desde fichero
			try {
				File archivo = new File ("cinta.txt");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				cinta = new Cinta(linea);
				cinta.mostrarCinta();
				
				br.close();
			}catch(Exception e) {
				System.out.println("ERROR leer fichero");
			}
		}
		
		//Introducir Alfabeto
		ArrayList<Character> alfa = new ArrayList<Character>();
		alfa.add('a');
		alfa.add('b');
		Alfabeto alfabeto = new Alfabeto(alfa);
		alfabeto.mostrarAlfabeto();
		
		//Introducir Estados
		int nEstados = 5;
		ArrayList<Estado> estados = new ArrayList<Estado>();
		for(int i = 0; i < nEstados; i++) {
			estados.add(new Estado(i));
		}
		
		//Introducir Transiciones
		//Estado 0
		ArrayList<Transicion> t0 = new ArrayList<Transicion>();
		t0.add(new Transicion("a","a","r", 1));
		t0.add(new Transicion("b", "b","r", 0));
		
		estados.get(0).setTransiciones(t0);
		
		//Estado 1
		ArrayList<Transicion> t1 = new ArrayList<Transicion>();
		t1.add(new Transicion("a","a","r", 2));
		t1.add(new Transicion("b", "b","r", 0));
		
		estados.get(1).setTransiciones(t1);
		
		//Estado 2
		ArrayList<Transicion> t2 = new ArrayList<Transicion>();
		t2.add(new Transicion("a","a","r", 2));
		t2.add(new Transicion("b", "b","r", 3));
		
		estados.get(2).setTransiciones(t2);
		
		//Estado 3
		ArrayList<Transicion> t3 = new ArrayList<Transicion>();
		t3.add(new Transicion("a","a","r", 1));
		t3.add(new Transicion("b", "b","r", 0));
		t3.add(new Transicion("$", "$", "r", 4));
		
		estados.get(3).setTransiciones(t3);
		
		//Estado 4
		ArrayList<Transicion> t4 = new ArrayList<Transicion>();
		t4.add(new Transicion("$", "$", "r", 4));
		
		estados.get(4).setTransiciones(t4);
		
		/*for(int i = 0; i < nEstados; i++) {
			estados.get(i).mostrarEstado();
		}*/
		
		//Comprobacion
		int estadoActual = 0;
		int posArrayTransiciones = 0;
		boolean salir = false;
		int i = 1;
		while(!salir && i < cinta.getCinta().size()){
			if(estados.get(estadoActual).buscarTransicion(cinta.getElementoCinta(i)) != -1) {
				posArrayTransiciones = estados.get(estadoActual).buscarTransicion(cinta.getElementoCinta(i));
				estadoActual = estados.get(estadoActual).getTransicion(posArrayTransiciones).getProximoEstado();
			}
			else { //si no pertenece al alfabeto
				estadoActual = -1;
				salir = true;
			}
			i++;
		}
		if(estadoActual == 4) {
			System.out.println("Cadena Aceptada");
		}
		else {
			System.out.println("Cadena Rechazada");
		}
		in.close();
	}
}
