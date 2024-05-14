package jogoA3;

//CLASSE CONTROLE

public abstract class Personagem{

private int maxVida, ataque;
private boolean defesa;
private double dano, vida;

//SETTERS
public void setMaxVida(int maxVida){
  this.maxVida=maxVida;
}
public void setVida(double vida){
  this.vida=vida;
}
public void setAtaque(int ataque){
 this.ataque=ataque;
}
public void setDefesa(boolean defesa){
  this.defesa=defesa;
}
public void setDano(double dano) {
	this.dano=dano;
}

//GETTERS  
public int getMaxVida(){
  return maxVida;
}
public int getVida(){
	 int vidaI = (int)vida;
	return vidaI;
	}
public int getAtaque(){
  return ataque;
}
public boolean getDefesa(){
  return defesa;
}
public double getDano() {
int danoI = (int)dano;
return danoI;
}

//MÃ‰TODOS ABSTRATOS
public abstract void atacar();
public abstract void defender();

}

//MÉTODOS ABSTRATOS
public abstract void atacar();
public abstract void defender();

}
