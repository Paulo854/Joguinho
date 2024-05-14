package jogoA3;

import java.util.Random;
public class Inimigo extends Personagem{


public Inimigo( int maxVida, int vida, int ataque) {

 super.setMaxVida(maxVida);
 super.setVida(vida);
 super.setAtaque(ataque);
}

// Sorteia a aÃ§Ã£o do inimigo
public void defAcao(){

Random r =new Random();
  
int i;

i= r.nextInt(10);

if (i<5){
this.atacar();
}
else{
this.defender();
}
}

  

public void atacar(){

//Construtor para gerar nÃºmeros aleatÃ³rios
Random r = new Random();
//VariÃ¡vel de controle
int i;

i=r.nextInt(10);


//30% chance de errar ataque
if (i<4){

super.setDano(0);
}

//20% chance de ataque crÃ­tico 
else if (i>8){

super.setDano(super.getAtaque()*1.1);
}

//50% chance de ataque normal
else{

super.setDano(super.getAtaque());
}
}

public void defender(){

super.setDano(0);
super.setDefesa(true);;
}

public void passarVez(){
super.setDano(0);
}

}
