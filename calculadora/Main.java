package exemplo01;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		JFrame principal = new JFrame();
		principal.setSize(400, 550);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setLayout(null);
		JTextField monitor = new JTextField();
		monitor.setBounds(0, 0, 400, 100);
		monitor.setBackground(Color.LIGHT_GRAY);
		
		//botoes numericos
		JButton btn1 = new JButton("1");
		btn1.setBounds(5, 250, 50, 50);
		JButton btn2 = new JButton("2");
		btn2.setBounds(60, 250, 50, 50);
		JButton btn3 = new JButton("3");
		btn3.setBounds(115, 250, 50, 50);
		JButton btn4 = new JButton("4");
		btn4.setBounds(5, 305, 50, 50);
		JButton btn5 = new JButton("5");
		btn5.setBounds(60, 305, 50, 50);
		JButton btn6 = new JButton("6");
		btn6.setBounds(115, 305, 50, 50);
		JButton btn7 = new JButton("7");
		btn7.setBounds(5, 360, 50, 50);
		JButton btn8 = new JButton("8");
		btn8.setBounds(60, 360, 50, 50);
		JButton btn9 = new JButton("9");
		btn9.setBounds(115, 360, 50, 50);
		JButton btn0 = new JButton("0");
		btn0.setBounds(5, 415, 160, 50);
		
		
		principal.add(btn1);
		principal.add(btn2);
		principal.add(btn3);
		principal.add(btn4);
		principal.add(btn5);
		principal.add(btn6);
		principal.add(btn7);
		principal.add(btn8);
		principal.add(btn9);
		principal.add(btn0);
		principal.add(monitor);
		
		//botoes operacionais
		JButton soma = new JButton("+");
		soma.setBounds(200, 250, 50, 50);
		principal.add(soma);
		principal.setVisible(true);
	}
}
