package exemplo02;

public class Produto {
	//atributo
	private static int contador = 0;
	
	//construtor
	public Produto() {
		System.out.println(contador);
		contador++;
	}
}
