package frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Acao.Acao;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Listar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Listar() {
		Acao a = new Acao();
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 417);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(a.exibir());
	}
}
