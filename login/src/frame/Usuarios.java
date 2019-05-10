package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Acao.Acao;
import beans.Login;
import dados.Dados;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtLogin;
	private JButton btnCadastrar;
	private JPasswordField txtSenha;

	public Usuarios() {
		setBounds(100, 100, 450, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 414, 310);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(10, 11, 48, 20);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(10, 53, 48, 20);
		contentPane.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(68, 13, 188, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(24, 101, 96, 31);
		contentPane.add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(68, 55, 188, 20);
		contentPane.add(txtSenha);
		
		Acao a = new Acao();
		table.setModel(a.exibir());
		scrollPane.setViewportView(table);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setLogin(txtLogin.getText());
				l.setSenha(String.valueOf(txtSenha.getPassword()));
				
				a.cadastrar(l);
				table.setModel(a.exibir());
			}
		});
	}
}
