package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Acao.Acao;
import beans.Login;
import dados.Dados;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtLogin;
	private JButton btnCadastrar;
	private JPasswordField txtSenha;
	private JTextField txtHie;
	private JButton btnAlterar;

	int row;
	private JButton btnCancelar;
	private JButton btnDelet;
	public Usuarios() {
		setBounds(100, 100, 450, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 196, 414, 257);
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
		btnCadastrar.setBounds(10, 154, 96, 31);
		contentPane.add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(68, 55, 188, 20);
		contentPane.add(txtSenha);
		
		Acao a = new Acao();
		table.setModel(a.exibir());
		scrollPane.setViewportView(table);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(118, 154, 96, 31);
		contentPane.add(btnAlterar);
		
		
		
		btnAlterar.setEnabled(false);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnDelet.setEnabled(true);
				row = table.getSelectedRow();
				
				txtLogin.setText(Dados.logins.get(row).getLogin());
				txtSenha.setText(Dados.logins.get(row).getSenha());
				txtHie.setText(String.valueOf(Dados.logins.get(row).getHie()));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setLogin(txtLogin.getText());
				l.setSenha(String.copyValueOf(txtSenha.getPassword()));
				l.setHie(Integer.parseInt(txtHie.getText()));	
				
				Acao a = new Acao();
				a.alterar(l.getLogin(), l.getSenha(), l.getHie(), row);
				
				
				txtHie.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
				
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnDelet.setEnabled(false);
				
				table.setModel(a.exibir());
			}
		});
		
		JLabel lblhie = new JLabel("Nivel");
		lblhie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblhie.setBounds(10, 93, 48, 20);
		contentPane.add(lblhie);
		
		txtHie = new JTextField();
		txtHie.setColumns(10);
		txtHie.setBounds(68, 95, 188, 20);
		contentPane.add(txtHie);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(328, 154, 96, 31);
		contentPane.add(btnCancelar);
		
		btnDelet = new JButton("Excluir");
		btnDelet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelet.setEnabled(false);
		btnDelet.setBounds(222, 154, 96, 31);
		contentPane.add(btnDelet);
		
		btnDelet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Acao a = new Acao();
				Dados.logins.remove(table.getSelectedRow());
				
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnDelet.setEnabled(false);
				
				table.setModel(a.exibir());
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtHie.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
				
				txtHie.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
				
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnDelet.setEnabled(false);
				
			}
		});
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				
				l.setLogin(txtLogin.getText());
				l.setSenha(String.valueOf(txtSenha.getPassword()));
				l.setHie(Integer.parseInt(txtHie.getText()));	
				
				a.cadastrar(l);
				table.setModel(a.exibir());
				
				txtLogin.setText("");
				txtSenha.setText("");
				txtHie.setText("");
			}
		});
	}
}
