package sistema.test;

import sistema.Aluno;
import sistema.Local;
import sistema.Professor;
import sistema.Seminario;

public class SistemaTeste {
	public static void main(String args[]) {
		Aluno aluno = new Aluno("Yves", 25);
		Aluno aluno2 = new Aluno("Ribamar", 25);
		Professor professor = new Professor("Messi", "Jogar futebol como ninguém");
		Seminario seminario = new Seminario("Como ser um jogador profissional");
		Local local = new Local("Espanha", "Camp Nou");
		
		//associando classes
		
		aluno2.setSeminario(seminario);
		aluno.setSeminario(seminario);
		seminario.setProfessor(professor);
		seminario.setLocal(local);
		seminario.setAluno(new Aluno[] {aluno, aluno2});//passando array de alunos
		professor.setSeminario(new Seminario[] {seminario});
	
		
		aluno.printAluno();
		aluno2.printAluno();
		local.printLocal();
		professor.printProfessor();
		seminario.printSeminario();	
	}
}
