package jogoA3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import jogoA3.Fase1.BackgroundPanel;

public class jogoPrincipal extends JFrame{
	Fase1 f1 = new Fase1();
	public JLabel lbl_iniciar;
	 public class BackgroundPanel extends JPanel {
	        private Image backgroundImage;

	        public BackgroundPanel(Image backgroundImage) {
	            this.backgroundImage = backgroundImage;
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Desenha a imagem de fundo
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	
	public jogoPrincipal() {
		
		
		setTitle("Jogo fase 1");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("menu.jpeg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        // Criar o JPanel com a imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);
        
        lbl_iniciar = new JLabel();
        lbl_iniciar.setIcon(new ImageIcon(getClass().getResource("start.png")));
        lbl_iniciar.addMouseListener(new MouseAdapter(){@Override public void mouseClicked(MouseEvent e){
            f1.setVisible(true);
            dispose();
        }});
        lbl_iniciar.setBounds(525, 650, 256, 120);
        backgroundPanel.add(lbl_iniciar);
        
     // Adicionar o JPanel de fundo ao JFrame
        setContentPane(backgroundPanel);
	}

	public static void main(String[] args) {
	
		jogoPrincipal jogoPrincipal = new jogoPrincipal();
		jogoPrincipal.setVisible(true);
	}

}
