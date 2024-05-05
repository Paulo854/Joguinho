import java.util.Random;
public class Inimigo extends Personagem{





public Inimigo( int maxVida, int vida, int ataque) {

 super.setMaxVida(maxVida);
 super.setVida(vida);
 super.setAtaque(ataque);
}





// Sorteia a ação do inimigo
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

//Construtor para gerar números aleatórios
Random r = new Random();
//Variável de controle
int i;

i=r.nextInt(10);


//30% chance de errar ataque
if (i<4){

dano=0;
}

//20% chance de ataque crítico 
else if (i>8){

dano=super.getAtaque()*1.1;
}

//50% chance de ataque normal
else{

dano=super.getAtaque();
}
}

public void defender(){

dano=0;
super.setDefesa(true);;
}

public void passarVez(){
dano=0;
}

}