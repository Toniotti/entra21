package exemplo01;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		//Criar o ArrayList
		ArrayList<String> cursos = new ArrayList<String>();
		
		//cadastrar cursos
		cursos.add("Java");
		cursos.add("MySQL");
		cursos.add("HTML");
		cursos.add("CSS");
		cursos.add("JavaScript");
		
		//aleterar o curso
		cursos.set(4, "JQuery");
		
		//remover
		cursos.remove(1);
	
		//remove all
		cursos.clear();
		
		//exibir qtd reg
		System.out.println("Cursos: "+cursos.size()+"\n");
	
		
		//listar os cursos
		for (String curso : cursos) {
			System.out.println(curso);
		}
		
	}
}
