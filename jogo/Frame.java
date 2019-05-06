package jogo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	Main m = new Main();
	
	
	JFrame principal = new JFrame();
	JPanel fn = new JPanel();
	JLabel r1 = new JLabel("1- "+m.perguntas[0][1]);
	JLabel r2 = new JLabel("2- "+m.perguntas[0][2]);
	JLabel r3 = new JLabel("1- "+m.perguntas[1][1]);
	JLabel r4 = new JLabel("2- "+m.perguntas[1][2]);
	JLabel r5 = new JLabel("1- "+m.perguntas[2][1]);
	JLabel r6 = new JLabel("2- "+m.perguntas[2][2]);
	
	public void pane() {
		JLabel pergunta = new JLabel();
		pergunta.setText(m.perguntas[m.aleatorio][0]);
		pergunta.setBounds(20, 20, 300, 50);
		
		fn.add(pergunta);
		
		r1.setBounds(20, 90, 180, 50);
		r1.setVisible(false);
		r2.setBounds(20, 120, 180, 50);
		r2.setVisible(false);
		r3.setBounds(20, 90, 180, 50);
		r3.setVisible(false);
		r4.setBounds(20, 120, 180, 50);
		r4.setVisible(false);
		r5.setBounds(20, 90, 180, 50);
		r5.setVisible(false);
		r6.setBounds(20, 120, 180, 50);
		r6.setVisible(false);
		
		if(m.aleatorio == 0) {
			r1.setVisible(true);
			r2.setVisible(true);
		}else if(m.aleatorio == 1) {
			r3.setVisible(true);
			r4.setVisible(true);
		}else if (m.aleatorio == 2) {
			r5.setVisible(true);
			r6.setVisible(true);
		}
		
		fn.add(r1);
		fn.add(r2);
		fn.add(r3);
		fn.add(r4);
		fn.add(r5);
		fn.add(r6);
		
	}
	
	public void gerarFrame() {
			principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			principal.setLayout(null);
			principal.setSize(350, 400);
			principal.add(fn);
			
			principal.setVisible(true);
	}
	
	
}
