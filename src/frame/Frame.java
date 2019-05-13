package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

import Acao.Acao;
import beans.Login;
import dados.Dados;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField alterarLogin;
	private JTextField alterarSenha;

	
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
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListar.setVisible(false);
		btnListar.setBounds(10, 11, 107, 36);
		panel.add(btnListar);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBounds(121, 105, 329, 286);
		contentPane.add(pnLogin);
		pnLogin.setBackground(SystemColor.activeCaption);
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
		
		JPanel Alterar = new JPanel();
		Alterar.setBounds(24, 131, 356, 259);
		contentPane.add(Alterar);
		Alterar.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Alterar.setVisible(false);
		Alterar.setLayout(null);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acao a = new Acao();
				Login l = new Login();
				 
				String login = txtLogin.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				int hie=0;
				
				
				for (int i = 0; i < Dados.logins.size(); i++) {
					if(login.equals(Dados.logins.get(i).getLogin())) {
						if(Dados.logins.get(i).getHie() == 1) {
							hie=1;
						}else {
							hie=0;
						}
					}
				}
				
				l.setLogin(login);	
				l.setSenha(senha);

				if((txtLogin.getText().equals("")) || (String.valueOf(txtSenha.getPassword()).equals(""))) {
					JOptionPane.showMessageDialog(null, "Os campos precisam ser preenchidos");
				}else
					    if((a.logar(login, senha) == true) && (hie == 1)) {
					    Alterar.setVisible(false);
					    btnListar.setVisible(false);
						btnUsuarios.setVisible(true);
						btnUsuarios.setEnabled(true);
						lblNome.setText(txtLogin.getText());
						lblNome.setVisible(true);
						pnLogin.setVisible(false);
						btnOut.setEnabled(true);
					}else if((a.logar(login, senha) == true) && (hie == 0)) {
						Alterar.setVisible(true);
						btnUsuarios.setVisible(false);
						btnUsuarios.setEnabled(false);
						btnListar.setVisible(true);
						btnListar.setEnabled(true);
						lblNome.setText(txtLogin.getText());
						lblNome.setVisible(true);
						pnLogin.setVisible(false);
						btnOut.setEnabled(true);
					}
				
				
			}
		});
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogin.setBounds(103, 170, 140, 50);
		pnLogin.add(btnLogin);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(74, 72, 226, 33);
		pnLogin.add(txtSenha);
		
		
		JLabel lblAlterarLogin = new JLabel("Login");
		lblAlterarLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlterarLogin.setBounds(10, 11, 73, 35);
		Alterar.add(lblAlterarLogin);
		
		JLabel lblAlterarSenha = new JLabel("Senha");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlterarSenha.setBounds(10, 57, 73, 35);
		Alterar.add(lblAlterarSenha);
		
		alterarLogin = new JTextField();
		alterarLogin.setBounds(76, 17, 182, 31);
		Alterar.add(alterarLogin);
		alterarLogin.setColumns(10);
		
		alterarSenha = new JTextField();
		alterarSenha.setColumns(10);
		alterarSenha.setBounds(76, 57, 182, 31);
		Alterar.add(alterarSenha);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlterar.setBounds(93, 140, 131, 51);
		Alterar.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				for (int i = 0; i < Dados.logins.size(); i++) {
					if(lblNome.getText().equals(Dados.logins.get(i).getLogin())) {
						l.setLogin(alterarLogin.getText());
						l.setSenha(alterarSenha.getText());
						Dados.logins.set(i, l);
						lblNome.setText(l.getLogin());
						
						alterarLogin.setText("");
						alterarSenha.setText("");
					}
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
		
		btnListar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Listar l = new Listar();
				l.setVisible(true);
				
			}
		});
		
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Alterar.setVisible(false);
				btnUsuarios.setEnabled(false);
				btnUsuarios.setVisible(true);
				btnListar.setEnabled(false);
				btnListar.setVisible(false);
				btnOut.setEnabled(false);
				lblNome.setText("");
				
				
				txtLogin.setText("");
				txtSenha.setText("");
				pnLogin.setVisible(true);
				
			}
		});
	}
}
