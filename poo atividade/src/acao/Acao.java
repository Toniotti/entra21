package acao;

import javax.swing.table.DefaultTableModel;

import beans.Curso;
import dados.Dados;

public class Acao {
	//CRUD - Create, Read, Update and Delete
	
	//cadastro
	public void cadastrar(Curso c) {
		Dados.arrayCursos.add(c);
	}
	
	//seleção
	public DefaultTableModel selecionar() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Curso");
		modelo.addColumn("Area");
		
		for(int i = 0; i < Dados.arrayCursos.size(); i++) {
			modelo.addRow(new Object[] {
					Dados.arrayCursos.get(i).getNomeCurso(),
					Dados.arrayCursos.get(i).getAreaCurso(),
			});
		}
		
		return modelo;
	}
	
	
	//alteração
	
	public void alterar(int indice, Curso c) {
		Dados.arrayCursos.set(indice, c);
	}
	
	//exclusao
	public void excluir(int indice) {
		Dados.arrayCursos.remove(indice);
	}
}
