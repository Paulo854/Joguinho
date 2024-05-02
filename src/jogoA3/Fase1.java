package jogoA3;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;





public class Fase1 extends JFrame implements ActionListener{
    public JLabel lbl_vidas;
    public JLabel lbl_vilao;
    public JLabel lbl_contVidas;
    public JLabel lbl_heroi;
    public JLabel lbl_pontos;

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
    
    public Fase1() {
        setTitle("Jogo fase 1");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Carregar a imagem de fundo
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("cenario.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        // Criar o JPanel com a imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);

        // Adicionar componentes ao JPanel de fundo
        lbl_vidas = new JLabel();
        lbl_vidas.setText("vidas: ");
        lbl_vidas.setBounds(10, 10, 50, 10);
        backgroundPanel.add(lbl_vidas);
    
       
        lbl_contVidas = new JLabel();
        lbl_contVidas.setText("teste");
        lbl_contVidas.setBounds(47, 10, 50, 10);
        backgroundPanel.add(lbl_contVidas);

        lbl_vilao = new JLabel();
        lbl_vilao.setIcon(new ImageIcon(getClass().getResource("vilao.png")));
        lbl_vilao.setBounds(800, 450, 360, 360);
        backgroundPanel.add(lbl_vilao);

        lbl_heroi = new JLabel();
        lbl_heroi.setIcon(new ImageIcon(getClass().getResource("heroi.png")));
        lbl_heroi.setBounds(10, 400, 270, 360);
        backgroundPanel.add(lbl_heroi);

        // Adicionar o JPanel de fundo ao JFrame
        setContentPane(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Fase1().setVisible(true);
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
