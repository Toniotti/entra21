package biblioteca;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
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
		principal.setResizable(false);

		principal.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png"));
		
		
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
		JTextField codigoEditar = new JTextField();
		codigoEditar.setBounds(70, 30, 160, 20);
		codigoEditar.setVisible(false);
		
		JTextField nomeEditar = new JTextField();
		nomeEditar.setBounds(70, 55, 160, 20);
		nomeEditar.setVisible(false);
		
		JTextField qtdEditar = new JTextField();
		qtdEditar.setBounds(70, 80, 160, 20);
		qtdEditar.setVisible(false);
		
		
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
		painel2.add(codigoEditar);
		
		painel2.add(nomeTxtA);
		nomeTxtA.setVisible(false);
		painel2.add(codigoTxtA);
		codigoTxtA.setVisible(false);
		painel2.add(qtdTxtA);
		qtdTxtA.setVisible(false);
		
		
		//painel de exibi��o
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
		
		//A��o do btnFnCad
		btnFnCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean qtdV = false;
				//o try verifica se a quantidade informada � um n�mero
				try {
					int quantidade = Integer.parseInt(qtdTxt.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "A quantidade deve ser um n�mero.");
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
						if(eq == false) {//verifica se o codigo n�o foi encontrado, caso nao for encontrado exibira um erro
							JOptionPane.showMessageDialog(null, "O codigo informado n�o existe.");
						}		
				}
				
			}
		});
		
		JButton btnFnAlu = new JButton("Alugar");//botao de finalizar o aluguel
		btnFnAlu.setBounds(80, 130, 120, 30);
		btnFnAlu.setVisible(false);
		
		//A��o do btnFnAlu
		btnFnAlu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//limpa os campos e deixa o campo nome como foco
				nomeTxt.setText("");
				nomeTxt.requestFocus();
				codigoTxt.setText("");
				qtdTxt.setText("");
				
				if((codigoTxtA.getText()!= null) && (nomeTxtA.getText()!= null) && (qtdTxtA.getText()!= null)) {
					int qtdR = 0;
					for (int i = 0; i < 300; i++) {
						if(codigoTxtA.getText().equals(bk[i][0])) {
							qtdR = Integer.parseInt(bk[i][2])-1;
							bk[i][2] = Integer.toString(qtdR);
							break;
						}
					}
					String tstr = "";
					for (int i = 0; i < 300; i++) {
						if(bk[i][0] != null) {
						tstr += bk[i][0]+","+bk[i][1]+","+bk[i][2]+","+System.lineSeparator();
						}
					}
					
					//apaga todo o texto do arquivo txt
					FileWriter writer;
					try {
						writer = new FileWriter("cadastro.txt", false);
						PrintWriter printWriter = new PrintWriter(writer);
					    printWriter.print("");
					    printWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//insere o texto novo.
					try {
						writer = new FileWriter("cadastro.txt", true);
						PrintWriter printWriter = new PrintWriter(writer);
					    printWriter.print(tstr);
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
				}
			}
		);
		
		JLabel inf = new JLabel("! Aperte enter ap�s digitar o codigo.");
		inf.setFont(inf.getFont().deriveFont(12f));
		inf.setBounds(10, 105, 230, 20);
		inf.setVisible(false);
		
		painel2.add(inf);
		
		JButton edit = new JButton("Editar.");
		edit.setBounds(80, 130, 120, 30);
		edit.setVisible(false);
		painel2.add(edit);
		
		
		JButton btnCadastrar = new JButton("Cadastrar.");
		btnCadastrar.setBounds(10, 5, 110, 30);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				qtdEditar.setVisible(false);
				nomeEditar.setVisible(false);
				codigoEditar.setVisible(false);
				edit.setVisible(false);
				codigoTxt.setEditable(false);
				inf.setVisible(false);
				codigoTxtA.setVisible(false);
				nomeTxtA.setVisible(false);
				nomeTxtA.setEditable(false);
				qtdTxtA.setVisible(false);
				qtdTxtA.setEditable(false);
				
				codigoTxt.setVisible(true);
				nomeTxt.setVisible(true);
				nomeTxt.setEditable(true);
				qtdTxt.setVisible(true);
				qtdTxt.setEditable(true);
				
				nomeTxt.requestFocus();
				btnFnAlu.setVisible(false);
				btnFnCad.setVisible(true);
				
				//limpa os campos e deixa o campo nome como foco
				nomeTxt.setText("");
				nomeTxt.requestFocus();
				codigoTxt.setText("");
				qtdTxt.setText("");
				
				//limpa os campos do aluguel
				codigoTxtA.setText("");
				nomeTxtA.setText("");
				qtdTxtA.setText("");
			}
		});
		
		JButton btnAlugar = new JButton("Alugar.");
		btnAlugar.setBounds(125, 5, 110, 30);
		btnAlugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				qtdEditar.setVisible(false);
				nomeEditar.setVisible(false);
				codigoEditar.setVisible(false);
				edit.setVisible(false);
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
				
				inf.setVisible(true);
				
				//limpa os campos do cadastro
				nomeTxt.setText("");
				codigoTxt.setText("");
				qtdTxt.setText("");
			}
		});
		
		
		
		JButton btnEditar = new JButton("Editar.");
		btnEditar.setBounds(240, 5, 110, 30);
		btnEditar.setVisible(true);
		
		painel2.add(qtdEditar);
		painel2.add(nomeEditar);
		
		btnEditar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				edit.setVisible(true);
				qtdEditar.setVisible(true);
				nomeEditar.setVisible(true);
				codigoEditar.setVisible(true);
				codigoTxt.setVisible(false);
				nomeTxt.setVisible(false);
				qtdTxt.setVisible(false);
				codigoTxtA.setVisible(false);
				nomeTxtA.setVisible(false);
				qtdTxtA.setVisible(false);
				btnFnCad.setVisible(false);
				btnFnAlu.setVisible(false);
				inf.setVisible(true);
				
				codigoEditar.setEditable(true);
				nomeEditar.setEditable(false);
				qtdEditar.setEditable(false);
				
			}
		});
		
		codigoEditar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		codigoEditar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					String cod = codigoEditar.getText();
					boolean eq = false;
						for(int t = 0; t < 300; t++) {//verifica se o codigo informado existe
							if(cod.equals(bk[t][0])) {
								nomeEditar.setEditable(true);
								qtdEditar.setEditable(true);
								eq = true;
								break;
							}
						
					}
						if(eq == false) {//verifica se o codigo n�o foi encontrado, caso nao for encontrado exibira um erro
							JOptionPane.showMessageDialog(null, "O codigo informado n�o existe.");
						}		
				}
			}
		});
		
		edit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				if(!nomeEditar.equals(null)) {
					String nm, qt, cod = null;
					nm = nomeEditar.getText();
					qt = qtdEditar.getText();
					cod = codigoEditar.getText();
					
					for (int i = 0; i < 300; i++) {
						if(cod.equals(bk[i][0])) {
							bk[i][1] = nm;
							bk[i][2] = qt;
							break;
						}
					}
					
					String tstr = "";
					for (int i = 0; i < 300; i++) {
						if(bk[i][0] != null) {
						tstr += bk[i][0]+","+bk[i][1]+","+bk[i][2]+","+System.lineSeparator();
						}
					}
					
					//apaga todo o texto do arquivo txt
					FileWriter writer;
					try {
						writer = new FileWriter("cadastro.txt", false);
						PrintWriter printWriter = new PrintWriter(writer);
					    printWriter.print("");
					    printWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//insere o texto novo.
					try {
						writer = new FileWriter("cadastro.txt", true);
						PrintWriter printWriter = new PrintWriter(writer);
					    printWriter.print(tstr);
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
				
			}
		});
		
		painel2.add(edit);
		
		//task bar
		JPanel tskBar = new JPanel();
		tskBar.setBounds(0, 0, 800, 45);
		tskBar.setBackground(new Color(202, 204, 206)); //seta a cor da task bar
		tskBar.add(btnCadastrar); // add o botao cadastrar a task bar
		tskBar.add(btnAlugar); // add o botao alugar a task bar
		tskBar.add(btnEditar);
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
		
		//painel de informa��o
		JFrame informacao = new JFrame();
		informacao.setSize(400, 500);
		informacao.setResizable(false);
		informacao.setTitle("Informa��es: Como utilizar o programa?");
		informacao.setLocationRelativeTo(null);
		informacao.setLayout(null);
		informacao.setIconImage(Toolkit.getDefaultToolkit().getImage("img/info.jpg"));
		
		JTextArea infm = new JTextArea("    1 - Cadastrar\r\n" + 
				"         *Clique em \"Nome\" e informe o nome do livro.\r\n" + 
				"         *Clique em \"Qtd\" e informe a quantidade desse livro.\r\n" + 
				"         *Clique em \"Cadastrar\".\r\n" + 
				"\r\n" + 
				"    2 - Alugar\r\n" + 
				"         *Clique em \"Codigo\" e informe o codigo do livro.\r\n" + 
				"         *Pressione \"Enter\".\r\n" + 
				"         *O codigo de todos os livros pode ser visto a direita.\r\n" + 
				"         *Clique em \"Alugar\".");
		
		infm.setEditable(false);
		
		infm.setBounds(10, 10, 365, 443);
		informacao.add(infm);
		
		ImageIcon imgInf = new ImageIcon("img/info.jpg");
		JButton info = new JButton(imgInf);
		info.setBounds(745, 10, 30, 30);

		tskBar.add(info);
		
		info.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				informacao.setVisible(true);
				
			}
		});
		
		//show
		principal.setVisible(true);
		
		
		nomeTxt.requestFocus();//deixa o campo de nome em foco
	}
}