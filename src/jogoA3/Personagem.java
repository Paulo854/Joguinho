//CLASSE CONTROLE

public abstract class Personagem{

private int maxVida, vida, ataque;
private boolean defesa;

//SETTERS
public void setMaxVida(int maxVida){
  this.maxVida=maxVida;
}
public void setVida(int vida){
  this.vida=vida;
}
public void setAtaque(int ataque){
 this.ataque=ataque;
}
public void setDefesa(boolean defesa){
  this.defesa=defesa;
}

//GETTERS  
public int getMaxVida(){
  return maxVida;
}
public int getVida(){
  return vida;
}
public int getAtaque(){
  return ataque;
}
public boolean getDefesa(){
  return defesa;
}
public double getDano(){
  return dano;
}

//MÉTODOS ABSTRATOS
public abstract void atacar();
public abstract void defender();

}