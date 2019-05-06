package jogo;
import java.util.Random;


public class Main {
	static int aleatorio;
	static Random gerar = new Random();
	static String[][] perguntas = new String[3][3];
	public static void main(String[] args) {
		
		//array de perguntas
		perguntas[0][0] = "Qual a maior piramide do mundo?";
		perguntas[1][0] = "Quantos planetas tem no sistema solar?";
		perguntas[2][0] = "Quem é o presidente da India?";
		
		//primeira pergunta
		perguntas[0][1] = "Tepanapa";
		perguntas[0][2] = "Miquerinos";
		
		//segunda pergunta
		perguntas[1][1] = "8";
		perguntas[1][2] = "723";
		
		//terceira pergunta
		perguntas[2][1] = "Ram Nath Kovind";
		perguntas[2][2] = "kim jong un";
		
		//gerar numero randomico
		aleatorio = gerar.nextInt(3);
		Frame f = new Frame();
		f.gerarFrame();
		
		
	}
}
