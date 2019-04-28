package teste;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {
	public static void main(String[] args) throws IOException {
		//vetor
		String[][] bk = new String[300][3]; 
		
		
		//Criar o formulario principal
		JFrame principal = new JFrame();
		principal.setSize(800, 600);
		principal.setTitle("Sistema de Biblioteca.");
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setLocationRelativeTo(null);
		principal.setLayout(null);
		
		//label
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(10, 55, 50, 20);
		JLabel codigo = new JLabel("Codigo:");
		codigo.setBounds(10, 30, 50, 20);
		JLabel qtd = new JLabel("Qtd:");
		qtd.setBounds(10, 80, 50, 20);
		
		//texflied para cadastro
		JTextField nomeTxt = new JTextField();
		nomeTxt.setBounds(70, 55, 160, 20);
		JTextField codigoTxt = new JTextField();
		codigoTxt.setEditable(false);
		codigoTxt.setBounds(70, 30, 160, 20);
		JTextField qtdTxt = new JTextField();
		qtdTxt.setBounds(70, 80, 160, 20);
		
		//texflied para aluguel
		JTextField nomeTxtA = new JTextField();
		nomeTxtA.setEditable(false);
		nomeTxtA.setBounds(70, 55, 160, 20);
		JTextField codigoTxtA = new JTextField();
		codigoTxtA.setBounds(70, 30, 160, 20);
		JTextField qtdTxtA = new JTextField();
		qtdTxtA.setEditable(false);
		qtdTxtA.setBounds(70, 80, 160, 20);
		
		nomeTxt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				while(codigoTxt.getDocument().getLength() <= 5) {
					codigoTxt.setEditable(true);
					Random rnm = new Random();
					int[] nmr = new int[7];
					
					for(int i=0; i<7; i++) {
						nmr[i] = rnm.nextInt(9);
						codigoTxt.setText(codigoTxt.getText()+nmr[i]);
				
			}
				codigoTxt.setEditable(false);	
				}
		}});
		
		qtdTxt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				while(codigoTxt.getDocument().getLength() <= 5) {
					codigoTxt.setEditable(true);
					Random rnm = new Random();
					int[] nmr = new int[7];
					
					for(int i=0; i<7; i++) {
						nmr[i] = rnm.nextInt(9);
						codigoTxt.setText(codigoTxt.getText()+nmr[i]);
				
			}
				codigoTxt.setEditable(false);	
				}
		}});
		
		
		//painel de cadastro e aluguel
		
		JPanel painel2 = new JPanel();
		painel2.setBounds(0, 48, 250, 600);
		painel2.setBackground(new Color(202, 204, 206));
		painel2.setLayout(null);
		
		//add labels ao painel2
		painel2.add(nome);
		painel2.add(codigo);
		painel2.add(qtd);
		
		//add textField ao painel2
		painel2.add(nomeTxt);
		painel2.add(codigoTxt);
		painel2.add(qtdTxt);
		
		painel2.add(nomeTxtA);
		nomeTxtA.setVisible(false);
		painel2.add(codigoTxtA);
		codigoTxtA.setVisible(false);
		painel2.add(qtdTxtA);
		qtdTxtA.setVisible(false);
		
		//painel de exibição
		JPanel exib = new JPanel();
		exib.setBounds(253, 48, 550, 600);
		exib.setBackground(new Color(222, 223, 224));
		exib.setLayout(null);
		
		JTextArea exb = new JTextArea();
		exb.setFont(exb.getFont().deriveFont(18f));
		exb.setEditable(false);
	
		JScrollPane scroll = new JScrollPane(exb);
		scroll.setBounds(10, 10, 510, 493);
		exib.add(scroll);
		
		//buttons
		
		
		JButton btnFnCad = new JButton("Cadastrar");//botao de finalizar o cadastro
		btnFnCad.setBounds(80, 130, 120, 30);
		btnFnCad.setVisible(true);
		
		//Ação do btnFnCad
		btnFnCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean qtdV = false;
				int quantidade=0;
				//o try verifica se a quantidade informada é um número
				try {
					quantidade = Integer.parseInt(qtdTxt.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "A quantidade deve ser um número.");
					qtdV = true;
				}
				if(qtdV != true) {
					FileWriter writer;
					try {
						writer = new FileWriter("cadastro.txt", true);
						PrintWriter printWriter = new PrintWriter(writer);
					    printWriter.println(codigoTxt.getText()+","+nomeTxt.getText()+","+qtdTxt.getText());
					    printWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						FileReader reader = new FileReader("cadastro.txt");
						BufferedReader bfr = new BufferedReader(reader);
						String ln = "";
						int i=0;
						String str = "";
						while((ln = bfr.readLine()) != null) {
							
							//insere o cadastro no vetor
								String[] strSeparado = ln.split(",");
								bk[i][0] = strSeparado[0];
								bk[i][1] = strSeparado[1];
								bk[i][2] = strSeparado[2];
								str += "Codigo: "+bk[i][0]+" || Nome: "+bk[i][1]+" || Quantidade: "+bk[i][2]+System.lineSeparator();
							i++;
						}
						exb.setText("");
						exb.setText(str);
						bfr.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//limpa os campos e deixa o campo nome como foco
				nomeTxt.setText("");
				nomeTxt.requestFocus();
				codigoTxt.setText("");
				qtdTxt.setText("");
				
			}
		});
		
		codigoTxtA.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					String cod = codigoTxtA.getText();
					boolean eq = false;
						for(int t = 0; t < 300; t++) {//verifica se o codigo informado existe, se existir mostrara o nome e quantidade do referido codigo.
							if(cod.equals(bk[t][0])) {
								nomeTxtA.setEditable(true);
								qtdTxtA.setEditable(true);
								nomeTxtA.setText(bk[t][1]);
								qtdTxtA.setText(bk[t][2]);
								nomeTxtA.setEditable(false);
								qtdTxtA.setEditable(false);
								eq = true;
								break;
							}
						
					}
						if(eq == false) {//verifica se o codigo não foi encontrado, caso nao for encontrado exibira um erro
							JOptionPane.showMessageDialog(null, "O codigo informado não existe.");
						}		
				}
				
			}
		});
		
		JButton btnFnAlu = new JButton("Alugar");//botao de finalizar o aluguel
		btnFnAlu.setBounds(80, 130, 120, 30);
		btnFnAlu.setVisible(false);
		
		//Ação do btnFnAlu
		btnFnAlu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//limpa os campos e deixa o campo nome como foco
				nomeTxt.setText("");
				nomeTxt.requestFocus();
				codigoTxt.setText("");
				qtdTxt.setText("");
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar.");
		btnCadastrar.setBounds(10, 5, 110, 30);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				codigoTxtA.setVisible(false);
				nomeTxtA.setVisible(false);
				nomeTxtA.setEditable(false);
				qtdTxtA.setVisible(false);
				qtdTxtA.setEditable(false);
				
				codigoTxt.setVisible(true);
				nomeTxt.setVisible(true);
				qtdTxt.setVisible(true);
				
				nomeTxt.requestFocus();
				btnFnAlu.setVisible(false);
				btnFnCad.setVisible(true);
				
				//limpa os campos e deixa o campo nome como foco
				nomeTxt.setText("");
				nomeTxt.requestFocus();
				codigoTxt.setText("");
				qtdTxt.setText("");
			}
		});
		
		JButton btnAlugar = new JButton("Alugar.");
		btnAlugar.setBounds(125, 5, 110, 30);
		btnAlugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				codigoTxtA.setVisible(true);
				nomeTxtA.setVisible(true);
				nomeTxtA.setEditable(false);
				qtdTxtA.setVisible(true);
				qtdTxtA.setEditable(false);
				
				codigoTxt.setVisible(false);
				nomeTxt.setVisible(false);
				qtdTxt.setVisible(false);
				
				nomeTxt.requestFocus();
				btnFnCad.setVisible(false);
				btnFnAlu.setVisible(true);
			}
		});
		
		
		
		//task bar
		JPanel tskBar = new JPanel();
		tskBar.setBounds(0, 0, 800, 45);
		tskBar.setBackground(new Color(202, 204, 206)); //seta a cor da task bar
		tskBar.add(btnCadastrar); // add o botao cadastrar a task bar
		tskBar.add(btnAlugar); // add o botao alugar a task bar
		tskBar.setLayout(null);
		
		//linha
		JPanel linha = new JPanel();
		linha.setBounds(0, 45, 800, 3);
		linha.setBackground(Color.BLACK);
		
		//linha2
		JPanel linha2 = new JPanel();
		linha2.setBounds(250, 48, 3, 600);
		linha2.setBackground(Color.BLACK);
		
		
		
		//add ao formulario principal
		principal.add(tskBar);
		principal.add(linha);
		principal.add(painel2);
		painel2.add(btnFnCad);
		painel2.add(btnFnAlu);
		principal.add(linha2);
		principal.add(exib);
		
		//mostra valores do db
		
		try {
			FileReader reader = new FileReader("cadastro.txt");
			BufferedReader bfr = new BufferedReader(reader);
			String ln = "";
			int i=0;
			while((ln = bfr.readLine()) != null) {
				
				//insere o cadastro no vetor
					String[] strSeparado = ln.split(",");
					bk[i][0] = strSeparado[0];
					bk[i][1] = strSeparado[1];
					bk[i][2] = strSeparado[2];
				i++;
			}
			bfr.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 300; i++) {
			if(bk[i][0] != null) {
				exb.append("Codigo: "+bk[i][0]+" || Nome: "+bk[i][1]+" || Quantidade: "+bk[i][2]+System.lineSeparator());
			}
		}
		
		
		//show
		principal.setVisible(true);
		
		
		nomeTxt.requestFocus();//deixa o campo de nome em foco
	}
}
