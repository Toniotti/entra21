package exemplo03;

public class Pessoa {
	private String nome;
	private int idade;
	
	//Bob o construtor
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		exibirDados();
		situacaoIdade();
	}
	
	//metodo para exibir dados
	private void exibirDados() {
		System.out.println(nome+"\n"+idade);
	}
	
	//metodo para retornar a situação da idade
	private void situacaoIdade() {
		int idade = 0;
		System.out.println(idade >= 18 ? "Maior de idade" : "Menor de idade");
	}
}
