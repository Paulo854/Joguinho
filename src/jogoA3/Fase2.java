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
	
	
	public void Fase2(Double score) {
		super.score = score;
	}
		
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			super.lbl_botaoAtaqueN.setVisible(false);
			super.lbl_botaoAtaqueN2.setVisible(true);
			super.lbl_vilao.setVisible(false);
			super.lbl_vilao2.setVisible(true);
			super.lbl_ataqueMolho.setBounds(750, 450, 360, 360);
			super.barraVilao2.setVisible(true);;
			super.setTitle("Batala 2 Ouv e Melo");
		
			
			if(super.barraVilao2.getValue() <= 0 ) {
				JOptionPane.showMessageDialog(null, "Ganhou");
				super.timer.stop();
				dispose();
			}
		}

}
