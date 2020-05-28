package sistema;

public class Aluno {
	
	 
	private String nome;
	private int idade;
	private Seminario seminario;
	
	
	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	public Aluno() {
		
	}
	
	public void printAluno() {
		System.out.println("--------------------PRINT ALUNO--------------------");
		System.out.println("Nome: "+this.nome);
		System.out.println("Idade: "+this.idade);
		if(this.seminario != null) {
			System.out.println("Seminario: "+this.seminario.getTitulo());//imprimindo uma variável de referência. queremos apenas o dado 'titulo'
		} else {
			System.out.println("Aluno não inscrito em seminario");
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Seminario getSeminario() {
		return seminario;
	}
	public void setSeminario(Seminario seminario) {
		this.seminario = seminario;
	}

}
