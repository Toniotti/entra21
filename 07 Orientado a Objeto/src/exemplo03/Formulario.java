package exemplo03;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Formulario {
	String titulo;
	
	void formulario() {
		JFrame f = new JFrame();
		f.setSize(500, 300);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		f.add(painel());
		f.setTitle(titulo);
	}
	
	JPanel painel() {
		JPanel p = new JPanel();
		p.setBounds(10, 10, 200, 200);
		p.setBackground(Color.BLACK);
		
		return p;
	}
}
