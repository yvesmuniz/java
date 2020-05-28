package sistema;

public class Seminario {
		
	private String titulo;
	private Professor professor;
	private Aluno[] aluno;
	private Local local;

	public Seminario(String titulo) {
		this.titulo = titulo;
	}
	public Seminario() {
		
	}
	
	public void printSeminario() {
		System.out.println("--------------------PRINT SEMINARIO--------------------");
		if(this.titulo != null) {
			System.out.println("Titulo: "+this.titulo);
		} else {
			System.out.println("Não há seminario cadastrado");
		}
		
		if(professor != null) {
			System.out.println("Professor: "+this.professor.getNome());
		}else {
			System.out.println("Seminario sem professor");
		}
		if(aluno != null && aluno.length != 0) {
			for(Aluno alu : aluno) {
				System.out.println("Aluno: "+alu.getNome());
			}
		} else {
			System.out.println("Não há alunos no seminario");
		}
		if(local != null) {
			System.out.println("Local: "+this.local.getBairro()+", "+this.local.getRua());
		}else {
			System.out.println("Local não cadastrado");
		}	
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Aluno[] getAluno() {
		return aluno;
	}
	public void setAluno(Aluno[] aluno) {
		this.aluno = aluno;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
}
