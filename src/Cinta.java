import java.util.ArrayList;


public class Cinta {
	private ArrayList<String> cinta = new ArrayList<String>();
	
	public Cinta(){}
	
	public Cinta(String entrada) {
		setCinta(entrada);
	}
	
	public ArrayList<String> getCinta() {
		return cinta;
	}
	
	public void setCinta(String entrada) {
		cinta.add("$");
		char c[] = entrada.toCharArray();
		for(int i = 0; i < c.length; i++) {
			cinta.add(Character.toString(c[i]));
		}
		cinta.add("$");
	}
	
	public void modificarCinta(String caracter, int pos) {
		cinta.set(pos, caracter);
	}
	
	public String getElementoCinta(int pos) {
		return cinta.get(pos);
	}
	
	public void mostrarCinta() {
		System.out.println(getCinta());
	}
}
