import java. util.Random;
public class Protagonista extends Personagem{

private double dano;

public Protagonista(int maxVida, int vida, int ataque) {

super.setMaxVida(maxVida);
super.setVida(vida);
super.setAtaque(ataque);
}



public boolean getDefesa(){
return super.getDefesa();
}

public void atacar(){

//Construtor para gerar números aleatórios
Random r = new Random();
//Variável de controle
int i;

i=r.nextInt(10);

//10% de chance de errar
if (i<2){

dano=0;
}

// 30% chance de ataque crítico
else if (i>7){

dano=super.getAtaque()*1.1;
}

//60% chance de ataque normal
else{

dano=super.getAtaque();
}

}

public void defender(){

dano=0;
super.setDefesa(true);
}

}