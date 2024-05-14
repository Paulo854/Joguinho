package jogoA3;

import java. util.Random;
public class Protagonista extends Personagem{


public Protagonista(int maxVida, int vida, int ataque) {

super.setMaxVida(maxVida);
super.setVida(vida);
super.setAtaque(ataque);
}



public boolean getDefesa(){
return super.getDefesa();
}

public void atacar(){

//Construtor para gerar nÃºmeros aleatÃ³rios
Random r = new Random();
//VariÃ¡vel de controle
int i;

i=r.nextInt(10);

//10% de chance de errar
if (i<2){

super.setDano(0);
}

// 30% chance de ataque crÃ­tico
else if (i>7){

super.setDano(super.getAtaque()*1.1);
}

//60% chance de ataque normal
else{

super.setDano(super.getAtaque());
}

}

public void defender(){

super.setDano(0);
super.setDefesa(true);
}

}
}
