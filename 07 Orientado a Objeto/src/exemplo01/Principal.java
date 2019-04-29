package exemplo01;

public class Principal {
	public static void main(String[] args) {
		//instanciar
		Carro c1 = new Carro();
		c1.ano = 10;
		c1.modelo = "Landau";
		c1.cor = "Branco";
		c1.fabricante = "ford";
		
		Carro c2 = new Carro();
		c2.ano = 2019;
		c2.modelo = "Corolla";
		c2.cor = "Preto";
		c2.fabricante = "Toyota";
		
		
		c1.exibirDados();
		c2.exibirDados();
		
	}
}
