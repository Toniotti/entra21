package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;
import beans.Curso;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Formulario extends JFrame {
	private static int codigoCurso;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtArea;
	private JTable table;
	
	private void limparCampo() {
		//limpar
		txtArea.setText("");
		txtNome.setText("");
		
		//focus
		txtNome.requestFocus();
	}
	
	
	public Formulario() {
		
		//Objeto da classe acao
		Acao a = new Acao();
		
		JButton btnCancelar = new JButton("Cancelar");
		JButton btnExcluir = new JButton("Excluir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 14, 62, 38);
		contentPane.add(lblNome);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArea.setBounds(10, 52, 62, 38);
		contentPane.add(lblArea);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(82, 24, 184, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtArea = new JTextField();
		txtArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtArea.setColumns(10);
		txtArea.setBounds(82, 62, 184, 20);
		contentPane.add(txtArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//crair objeto curso
				Curso c = new Curso();
				c.setNomeCurso(txtNome.getText());
				c.setAreaCurso(txtArea.getText());
				
				//cadastrar
				a.cadastrar(c);
				
				//atualizar tablea
				table.setModel(a.selecionar());
				
				limparCampo();
			}
		});
		btnCadastrar.setBounds(10, 123, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia objeto classe Curso
				Curso c = new Curso();
				
				c.setNomeCurso(txtNome.getText());
				c.setAreaCurso(txtArea.getText());
				
				//realizar alteação
				
				a.alterar(codigoCurso, c);
				
				limparCampo();
				
				//botoes
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
				
				table.setModel(a.selecionar());
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterar.setBounds(127, 123, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//remover curso
				a.excluir(codigoCurso);
				
				//att
				table.setModel(a.selecionar());
				
				limparCampo();
				
				//botoes
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.setBounds(226, 123, 89, 23);
		contentPane.add(btnExcluir);
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampo();
				
				//botoes
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(325, 123, 95, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 410, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//obter indice da table
				int indice = table.getSelectedRow();
				
				//add valor do indice no atributo
				codigoCurso = indice;
				
				//Slecionando dados do curso
				txtNome.setText(table.getValueAt(indice, 0).toString());
				txtArea.setText(table.getValueAt(indice, 1).toString());
				
				//botoes
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelar.setEnabled(true);
				
			}
		});
		table.setModel(a.selecionar());
		scrollPane.setViewportView(table);
		
	}
}
