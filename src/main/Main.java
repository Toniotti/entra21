package main;

import Acao.Acao;
import beans.Login;
import frame.Frame;

public class Main {
	public static void main(String[] args) {
		Login l = new Login();
		Acao a = new Acao();
		
		
		l.setLogin("admin");
		l.setSenha("admin");
		l.setHie(1);
		
		a.cadastrar(l);
		
		Frame f = new Frame();
		f.setVisible(true);
		
	}
}
