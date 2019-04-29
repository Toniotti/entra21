package exemplo03;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Formulario f = new Formulario();
		f.titulo = JOptionPane.showInputDialog("Informe o titulo do jframe");
		f.formulario();
	}
}
