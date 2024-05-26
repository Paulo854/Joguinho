package jogoA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Fase3 extends Fase1 implements ActionListener {
    ArmazenaControle controlador = new ArmazenaControle();
    verificabanco banco = new verificabanco();
    jogoPrincipal jogo = new jogoPrincipal();

    public Fase3(int pontos, int vida, int acumadoDeVida) {
    	super();
    	if(acumadoDeVida > 2) {
    		acumaVida = 2;
    	}else {
    		acumadoDeVida = acumaVida;
    	}
        
        super.pontos = pontos;
        int novaVida = vida * 150;
        super.barraHeroi.setValue(novaVida);
        setBackgroundImage(new ImageIcon(getClass().getResource("fogao.jpg")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double score = pontos * 1.75;
        super.vidaRecom = 85;

        super.lbl_botaoAtaqueN.setVisible(false);
        super.lbl_botaoAtaqueN2.setVisible(false);
        super.lbl_botaoAtaqueN3.setVisible(true);
        super.lbl_defesabacaxi.setVisible(false);
		super.lbl_defesaOuvEMelo.setVisible(false);
		super.lbl_defesaPericles.setVisible(true);
		super.lbl_liberarVida.setBounds(250, 200, 100, 100);
        super.lbl_heroi.setVisible(false);
        super.lbl_heroiFase3.setVisible(true);
        super.lbl_vilao.setVisible(false);
        super.lbl_vilao2.setVisible(false);
        super.lbl_vilao3.setVisible(true);
        super.lbl_ataqueMolho.setBounds(850, 350, 360, 360);
        super.barraVilao2.setVisible(false);
        super.barraVilao.setVisible(false);
        super.barraVilao3.setVisible(true);
        super.setTitle("Batalha 3 P. R. Icles");

        if(acumaVida + 1 <= 2) {
	        if(pontos  % 5 == 0) {
	        	++pontos;
	        	System.out.println("qtde antes: "+acumaVida);
	        	++acumaVida;
	        	System.out.println("Qtde dps"+acumaVida);
	        }
	        }else {
	        	
	        }  
        
        
        if (super.barraVilao3.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "O principe cumpriu sua missão, P. R. Icles foi derrotado, burguinho retorna ao reino triunfante");
            double somar = controlador.getScore1() + controlador.getScore2() + score;
            banco.setBanco(controlador.getNome(), somar);
            JOptionPane.showMessageDialog(null, "Olá " + controlador.getNome() + " vamos resumo do seu game\nBatalha 1 Caxi = " + controlador.getScore1() + "\nBatalha 2 Cole e Melo = " + controlador.getScore2() + "\nBatalha com o P. R. Icles = "+score+"\nA soma do seus pontos resultou em: " + somar);
            super.timer.stop();
            dispose();
        }
        if(super.barraHeroi.getValue() <= 0) {
        	super.lbl_heroiFase3.setIcon(new ImageIcon(getClass().getResource("morte.png")));
        	lbl_botaoAtaqueN3.setVisible(false);
        	lbl_defesaPericles.setVisible(false);
        	lbl_liberarVida.setVisible(false);
        	super.lbl_heroiFase3.setBounds(1, 210, 500, 500);
        	JOptionPane.showMessageDialog(null, "Você não pertence mas a este reino saia daqui, seu score foi de: " + controlador.getScore1());
            super.timer.stop();
            jogo.setVisible(true);
            dispose();
        }
    }
}
