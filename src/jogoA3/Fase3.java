package jogoA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Fase3 extends Fase1 implements ActionListener{
	ArmazenaControle controlador = new ArmazenaControle();
	
	public Fase3(int pontos) {
		super.pontos = pontos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		double score = pontos*1.75;
		
		super.lbl_botaoAtaqueN.setVisible(false);
		super.lbl_botaoAtaqueN2.setVisible(false);
		super.lbl_botaoAtaqueN3.setVisible(true);
		super.lbl_vilao.setVisible(false);
		super.lbl_vilao2.setVisible(false);
		super.lbl_vilao3.setVisible(true);
		super.lbl_ataqueMolho.setBounds(850, 350, 360, 360);
		super.barraVilao2.setVisible(false);;
		super.barraVilao.setVisible(false);
		super.barraVilao3.setVisible(true);
		super.setTitle("Batala 3 Ouv e Melo");
	
		if(super.barraVilao3.getValue() <= 0 ) {
			JOptionPane.showMessageDialog(null, "Ganhou, sua pontuação foi de "+score);
			double somar = controlador.getScore1() + controlador.getScore2() +  score;;
			JOptionPane.showMessageDialog(null, "Vamos ao resumo do seu game\n Batalha 1 Bacaxi = "+controlador.getScore1()+"\nBatalha 2 Ouv e Melo = "+controlador.getScore2()+"\n a soma do seus pontos resultou em: "+somar);
			
			super.timer.stop();
			dispose();
		}
	}

}
