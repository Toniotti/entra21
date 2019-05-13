package Acao;

import javax.swing.table.DefaultTableModel;

import beans.Login;
import dados.Dados;

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
					Dados.logins.get(i).getHie(),
			});
		}
		return modelo;
	}
	
	public boolean logar(String login, String senha) {
		boolean l = false;
		for (int i = 0; i < Dados.logins.size(); i++) {
			if((login.equals(Dados.logins.get(i).getLogin())) && (senha.equals(Dados.logins.get(i).getSenha()))) {
				l = true;
				break;
			}
		}
		
		return l;
	}
	
	
	public void alterar(String login, String senha, int hie, int row) {
		Login l = new Login();
		l.setLogin(login);
		l.setSenha(senha);
		l.setHie(hie);
		
		Dados.logins.set(row, l);
		
	}
	
}
