package exemplo01;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Informe o nome");
		Pessoa pe = new Pessoa();
		Pessoa p = new Pessoa(nome);
	}
}
