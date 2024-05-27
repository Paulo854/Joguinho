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
	jogoPrincipal jogo = new jogoPrincipal();
	public int controladorPontos = 0;
	public  Fase2(int pontos, int vida, int acumadoDeVida) {
		if(acumadoDeVida > 2) {
    		acumaVida = 2;
    	}else {
    		acumadoDeVida = acumaVida;
    	}        
		super.pontos = pontos;
		super.acumaVida = acumaVida;
		super.barraHeroi.setValue(vida);
	}
		
		
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int pontosFinais = pontos - controladorPontos;
			
			controlador.setScore2(pontosFinais);
			super.vidaRecom = 50;
			
			
			super.lbl_botaoAtaqueN.setVisible(false);
			super.lbl_defesabacaxi.setVisible(false);
			super.lbl_defesaOuvEMelo.setVisible(true);
			super.lbl_botaoAtaqueN2.setVisible(true);
			super.lbl_vilao.setVisible(false);
			super.lbl_vilao2.setVisible(true);
			super.barraVilao.setVisible(false);
			super.lbl_ataqueMolho.setBounds(750, 450, 360, 360);
			super.barraVilao2.setVisible(true);;
			super.setTitle("Batalha 2 Cole e Melo");


			
			if(acumaVida + 1 <= 2) {
		        if(pontos  % 5 == 0) {
		        	++pontos;
		        	System.out.println("qtde antes: "+acumaVida);
		        	++controladorPontos;
		        	++acumaVida;
		        	System.out.println("Qtde dps"+acumaVida);
		        }
		        }else {
		        	
		        }     
			
			if(super.barraVilao2.getValue() <= 0 ) {
				JOptionPane.showMessageDialog(null, "Parabéns você conseguiu");
				int vidaHeroi = super.barraHeroi.getValue();
				Fase3 f3 = new Fase3(pontos, vidaHeroi, acumaVida);
				f3.setVisible(true);
				super.timer.stop();
				dispose();
			}
			if(super.barraHeroi.getValue() <= 0) {
				super.lbl_heroi.setIcon(new ImageIcon(getClass().getResource("morte.png")));
				lbl_botaoAtaqueN2.setVisible(false);
				lbl_defesaOuvEMelo.setVisible(false);
	        	lbl_liberarVida.setVisible(false);
	        	super.lbl_heroi.setBounds(1,320, 500, 500);
				JOptionPane.showMessageDialog(null, "O burguinho falhou em sua missão, o reino da cozinha perdeu seu principe\n seu score foi de: "+controlador.getScore2());
				super.timer.stop();
				jogo.setVisible(true);
				dispose();
			}
		}

}
