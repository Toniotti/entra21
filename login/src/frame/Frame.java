package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Acao.Acao;
import beans.Login;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 510, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setEnabled(false);
		btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUsuarios.setBounds(10, 11, 107, 36);
		panel.add(btnUsuarios);
		
		JButton btnOut = new JButton("Sair");
		btnOut.setEnabled(false);
		btnOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOut.setBounds(407, 11, 93, 36);
		panel.add(btnOut);
		
		JLabel lblNome = new JLabel("teste");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(177, 11, 156, 36);
		lblNome.setVisible(false);
		panel.add(lblNome);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBackground(SystemColor.activeCaption);
		pnLogin.setBounds(106, 126, 329, 286);
		contentPane.add(pnLogin);
		pnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(10, 32, 71, 14);
		pnLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(10, 80, 71, 14);
		pnLogin.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(74, 26, 226, 33);
		pnLogin.add(txtLogin);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acao a = new Acao();
				Login l = new Login();
				l.setLogin(txtLogin.getText());	
				l.setSenha(String.valueOf(txtSenha.getPassword()));

				
				if(a.logar() == true) {
					lblNome.setText(txtLogin.getText());
					lblNome.setVisible(true);
					pnLogin.setVisible(false);
					btnUsuarios.setEnabled(true);
					btnOut.setEnabled(true);
				}
			}
		});
		
		btnUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuarios u = new Usuarios();
				u.setVisible(true);
			}
		});
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogin.setBounds(103, 170, 140, 50);
		pnLogin.add(btnLogin);
		
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnUsuarios.setEnabled(false);
				btnOut.setEnabled(false);
				
				
				txtLogin.setText("");
				txtSenha.setText("");
				pnLogin.setVisible(true);
				
			}
		});
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(74, 72, 226, 33);
		pnLogin.add(txtSenha);
	}
}
