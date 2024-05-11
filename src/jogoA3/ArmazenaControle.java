package jogoA3;

public class ArmazenaControle{
	private String nome;
	private double score1;
	private double score2;
	
	public ArmazenaControle() {
		
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setScore1(double score) {
		this.score1 = score;
	}
	public double getScore1() {
		return this.score1;
	}
	public void setScore2(double score) {
		this.score2 = score;
	}
	public double getScore2() {
		return this.score2;
	}

}
