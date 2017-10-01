import java.util.ArrayList;


public class Alfabeto {
	private ArrayList<Character> alfabeto = new ArrayList<Character>();
	
	public Alfabeto(ArrayList<Character> alfa) {
		alfabeto = alfa;
	}

	public ArrayList<Character> getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(ArrayList<Character> alfabeto) {
		this.alfabeto = alfabeto;
	}
	
	public void mostrarAlfabeto() {
		System.out.println(getAlfabeto());
	}
}
