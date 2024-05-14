package jogoA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fase2 extends Fase1 implements ActionListener{
	ArmazenaControle controlador = new ArmazenaControle();
	public  Fase2(int pontos) {
		super.pontos = pontos;
	}
		
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			controlador.setScore2(pontos*0.50);
			
			super.lbl_botaoAtaqueN.setVisible(false);
			super.lbl_botaoAtaqueN2.setVisible(true);
			super.lbl_vilao.setVisible(false);
			super.lbl_vilao2.setVisible(true);
			super.barraVilao3.setVisible(true);
			super.lbl_ataqueMolho.setBounds(750, 450, 360, 360);
			super.barraVilao2.setVisible(true);;
			super.setTitle("Batala 2 Ouv e Melo");

			// Personagens
			Protagonista p= new Protagonista(1000,1000,50);
	        Inimigo ouveMelo = new Inimigo(1000,1000,50);
	        
			JButton btn_atacar= new JButton();
	        JButton btn_defender = new JButton();
	        
	       gerarBotoes(p, ouveMelo, barraHeroi, barraVilao2, btn_atacar, btn_defender, pontos);
		    
	     	//gera os botões na tela
	     	  add(btn_atacar);
	     	  add(btn_defender);

			
			if(super.barraVilao2.getValue() <= 0 ) {
				JOptionPane.showMessageDialog(null, "Ganhou");
				JOptionPane.showMessageDialog(null, "sua pontuação foi de "+controlador.getScore2());
				Fase3 f3 = new Fase3(pontos);
				f3.setVisible(true);
				super.timer.stop();
				dispose();
			}
		}

}
