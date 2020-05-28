package sistema;

public class Professor {
	private String nome;
	private String skill;
	private Seminario[] seminario;
	
	public Professor(String nome, String skill) {
		this.nome = nome;
		this.skill = skill;
	}
	public Professor() {
		
	}
	
	public void printProfessor() {
		System.out.println("--------------------PRINT PROFESSOR--------------------");
		System.out.println("Nome: "+this.nome);
		System.out.println("skill: "+this.skill);
		if(seminario != null && seminario.length != 0) {
			for(Seminario semi : seminario) {
				System.out.println("Seminario: "+semi.getTitulo());//imprimindo array associado
			}
		} else {
			System.out.println("Pofessor não está palestrando em nenhum seminario");
		}
	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Seminario[] getSeminario() {
		return seminario;
	}
	public void setSeminario(Seminario[] seminario) {
		this.seminario = seminario;
	}
			
}
