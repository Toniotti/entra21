package Acao;

import javax.swing.table.DefaultTableModel;

import beans.Login;
import dados.Dados;
import frame.Frame;

public class Acao {
	public void cadastrar(Login l) {
		Dados.logins.add(l);
	}
	
	public DefaultTableModel exibir() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Login");
		modelo.addColumn("Senha");
		modelo.addColumn("Nivel");
		
		
		for(int i = 0; i < Dados.logins.size(); i++) {
			modelo.addRow(new Object[] {
					Dados.logins.get(i).getLogin(),
					Dados.logins.get(i).getSenha(),
			});
		}
		return modelo;
	}
	
	public boolean logar() {
		Login l = new Login();
		boolean log = false;
		String login = l.getLogin();
		String senha = l.getSenha();
		
			if(login.equals("admin") && senha.equals("admin")) {
				log = true;
		}else {
			for (int i = 0; i < Dados.logins.size(); i++) {
				if((login.equals(Dados.logins.get(i).getLogin())) && (senha.equals(Dados.logins.get(i).getSenha()))) {
					
				}
			}
		}
		return log;
	}
}
