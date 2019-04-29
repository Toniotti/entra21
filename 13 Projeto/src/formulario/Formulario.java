package formulario;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Formulario {
	
	//construtor
	public Formulario() {
		JFrame f = new JFrame("Sistema Simples");
		f.setSize(500, 400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(listarDados());
		f.setVisible(true);
	}
	
	//listar dados
	
	private JPanel listarDados() {
		JPanel p = new JPanel();
		p.setBounds(10, 10, 400, 250);
		p.setBackground(Color.BLUE);
		
		JScrollPane barra = new JScrollPane(tabela());
		barra.setBounds(10, 10, 400, 250);
		p.add(barra);
		
		return p;
	}
	
	//tabela
	
	private JTable tabela() {
		//dados
		DefaultTableModel dados = new DefaultTableModel();
		
		dados.addColumn("Nome");
		dados.addColumn("Idade");
		dados.addColumn("Cidade");
		dados.addRow(new Object[] {"Carlos", 46, "Blumenau"});
		dados.addRow(new Object[] {"Bianca", 22, "Pomerode"});
		dados.addRow(new Object[] {"Leticia", 29, "Joiville"});
		
		//Tabela
		
		JTable tabela = new JTable(dados);
		
		//retorno
		return tabela;
		
	}
}
