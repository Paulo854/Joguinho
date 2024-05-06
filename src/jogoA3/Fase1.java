package jogoA3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.Timer;

import javax.swing.*;

public class Fase1 extends JFrame implements ActionListener{
    public JLabel lbl_vidas;
    public JLabel lbl_vidas_iconVilao;
    public JLabel lbl_vilao;
    public JLabel lbl_contVidas;
    public JLabel lbl_heroi;
    public JLabel lbl_pontos;
    public JLabel lbl_ataqueMolho;
    public JLabel lbl_botaoAtaqueN;
    public int pontos = 0;
    public double score = 0;
    public int ataques;
    public Timer timer;
    JProgressBar barraHeroi = new JProgressBar();
    JProgressBar barraVilao = new JProgressBar();
    
   
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
        barraHeroi.setBounds(40, 50, 100, 30);
        barraHeroi.setStringPainted(true);
        barraHeroi.setValue(100);
        barraHeroi.setForeground(Color.red);
        backgroundPanel.add(barraHeroi);
        
        Timer timerAtaqueMolho = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_ataqueMolho.setVisible(false);
            }
        });
        timerAtaqueMolho.setRepeats(false);
           
        lbl_botaoAtaqueN = new JLabel();
        lbl_botaoAtaqueN.setIcon(new ImageIcon(getClass().getResource("botão.png")));
        lbl_botaoAtaqueN.addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e) {
                barraVilao.setValue(barraVilao.getValue() - 2);
                lbl_ataqueMolho.setVisible(true);
                ++pontos;
                timerAtaqueMolho.restart();
            }
        });
        
        lbl_botaoAtaqueN.setBounds(10, 290, 100,100);
        backgroundPanel.add(lbl_botaoAtaqueN);
        
        lbl_vidas = new JLabel();
        lbl_vidas.setIcon(new ImageIcon(getClass().getResource("vida.png")));
        lbl_vidas.setBounds(10, 52, 25, 25);
        backgroundPanel.add(lbl_vidas);
        
        lbl_ataqueMolho = new JLabel();
        lbl_ataqueMolho.setIcon(new ImageIcon(getClass().getResource("ataque.png")));
        lbl_ataqueMolho.setBounds(750, 350, 360, 360);
        lbl_ataqueMolho.setVisible(false);
        backgroundPanel.add(lbl_ataqueMolho);
        
        barraVilao.setBounds(1050, 50, 100, 30);
        barraVilao.setStringPainted(true);
        barraVilao.setMaximum(400);
        barraVilao.setValue(400);
        barraVilao.setForeground(Color.red);
        backgroundPanel.add(barraVilao);

        lbl_vidas_iconVilao = new JLabel();
        lbl_vidas_iconVilao.setIcon(new ImageIcon(getClass().getResource("vida.png")));
        lbl_vidas_iconVilao.setBounds(1150, 52, 25, 25);
        backgroundPanel.add(lbl_vidas_iconVilao);
        
        lbl_vilao = new JLabel();
        lbl_vilao.setIcon(new ImageIcon(getClass().getResource("Bacaxi.png")));
        lbl_vilao.setBounds(750, 260, 435, 554);
        backgroundPanel.add(lbl_vilao);
        
        

        lbl_heroi = new JLabel();
        lbl_heroi.setIcon(new ImageIcon(getClass().getResource("Burguinho.png")));
        lbl_heroi.setBounds(1, 250, 554, 554);
        backgroundPanel.add(lbl_heroi);

        // Adicionar o JPanel de fundo ao JFrame
        setContentPane(backgroundPanel);
        
        
        
        timer = new Timer(50,this);
        timer.start();
    }


    
	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
		ataques = rand.nextInt(2);
		int ataquesValidos = rand.nextInt(36);
		int ganharVida = rand.nextInt(45);
		
		score = pontos*0.26;
		
		if(ataques == 1 || ataques == 2) {
			if(ataquesValidos == 18) {
			barraHeroi.setValue(barraHeroi.getValue()-5);
			}
		}
		if(barraHeroi.getValue()<=0) {
			JOptionPane.showMessageDialog(null, "Nunca mas volte para o nosso reino, seu score foi de: "+score);
			dispose();
			barraHeroi.setValue(100);
			timer.stop();
		}
		if(barraHeroi.getValue()<=25) {
			JOptionPane.showMessageDialog(null, "Vamos dizer que você tem sorte, vai ganhar"+ganharVida);
			barraHeroi.setValue(barraHeroi.getValue()+ganharVida);
		}
		if(barraVilao.getValue()<=0) {
			JOptionPane.showMessageDialog(null, "Parábens você conseguiu, seu score foi de: "+score);
			dispose();
			timer.stop();
			barraHeroi.setValue(100);
		}
		
		
	}
}
