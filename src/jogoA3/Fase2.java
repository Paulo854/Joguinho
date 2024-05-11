package jogoA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fase2 extends Fase1 implements ActionListener{
	ArmazenaControle controlador = new ArmazenaControle();
	
	
	public void Fase2(Double score) {
		super.score = score;
	}
		
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			super.lbl_botaoAtaqueN.addMouseListener(new MouseAdapter() {
	            @Override 
	            public void mouseClicked(MouseEvent e) {
	                barraVilao2.setValue(barraVilao2.getValue() - 2);
	            }
	        });
			
			super.lbl_vilao.setVisible(false);
			super.lbl_vilao2.setVisible(true);
			super.lbl_ataqueMolho.setBounds(750, 450, 360, 360);
			super.barraVilao2.setVisible(true);;
			super.setTitle("Batala 2 Ouv e Melo");
		}

}
