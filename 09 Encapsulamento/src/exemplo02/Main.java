package exemplo02;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Informe o nome");
		
		Pessoa p = new Pessoa();
		
		p.setNome(nome);
		
		System.out.println(p.getNome());
		
	}
}
