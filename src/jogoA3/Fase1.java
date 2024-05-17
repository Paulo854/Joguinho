package jogoA3;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.*;

public class Fase1 extends JFrame implements ActionListener {
    public JLabel lbl_vidas;
    public JLabel lbl_vidas_iconVilao;
    public JLabel lbl_vilao;
    public JLabel lbl_vilao2;
    public JLabel lbl_vilao3;
    public JLabel lbl_contVidas;
    public JLabel lbl_heroi;
    public JLabel lbl_pontos;
    public JLabel lbl_ataqueMolho;
    public JLabel lbl_botaoAtaqueN;
    public JLabel lbl_botaoAtaqueN2;
    public JLabel lbl_botaoAtaqueN3;
    public int pontos = 0;
    public int pontos2 = 0;
    public int ataques;
    public Timer timer;

    ArmazenaControle controlador = new ArmazenaControle();
    JProgressBar barraHeroi = new JProgressBar();
    JProgressBar barraVilao = new JProgressBar();
    JProgressBar barraVilao2 = new JProgressBar();
    JProgressBar barraVilao3 = new JProgressBar();

    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public Fase1() {
        setTitle("Batalha 1 Bacaxi");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("cenario.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);

        barraHeroi.setBounds(40, 50, 100, 30);
        barraHeroi.setStringPainted(true);
        barraHeroi.setMaximum(1000);
        barraHeroi.setValue(1000);
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
            	int vida;
            	int bacaxi;
            	int normalAtaque = 7;
            	int ataqueBacaxi = 5;
            	Random r = new Random();
            	vida = r.nextInt(10);
            	bacaxi = r.nextInt(10);
            	if(vida <= 4) {
            		System.out.print("Você errou o ataque");
            	}else if(vida >= 8) {
            		System.out.print("Você acetou um ataque normal");
            		barraVilao.setValue(barraVilao.getValue() - normalAtaque);
            	}else {
            		System.out.print("Você deu um superAtaque");
            		barraVilao.setValue(barraVilao.getValue() - normalAtaque*2);
            	}
            	if(bacaxi <= 4) {
            		System.out.print("O Bacaxi errou o ataque dele");
            	}else if(bacaxi >= 8) {
            		System.out.print("O bacaxi acertou um ataque em você de: "+ataqueBacaxi);
            		barraHeroi.setValue(barraHeroi.getValue() - ataqueBacaxi);
            	}else {
            		System.out.print("O bacaxi acertou um super ataque de: "+ataqueBacaxi*2);
            		barraHeroi.setValue(barraHeroi.getValue() - ataqueBacaxi*2);
            	}
                lbl_ataqueMolho.setVisible(true);
                ++pontos;
                timerAtaqueMolho.restart();
            }
        });
        lbl_botaoAtaqueN.setBounds(10, 290, 100, 100);
        backgroundPanel.add(lbl_botaoAtaqueN);

        lbl_botaoAtaqueN2 = new JLabel();
        lbl_botaoAtaqueN2.setIcon(new ImageIcon(getClass().getResource("botão.png")));
        lbl_botaoAtaqueN2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barraVilao2.setValue(barraVilao2.getValue() - 50);
                lbl_ataqueMolho.setVisible(true);
                ++pontos;
                timerAtaqueMolho.restart();
            }
        });
        lbl_botaoAtaqueN2.setVisible(false);
        lbl_botaoAtaqueN2.setBounds(10, 290, 100, 100);
        backgroundPanel.add(lbl_botaoAtaqueN2);

        lbl_botaoAtaqueN3 = new JLabel();
        lbl_botaoAtaqueN3.setIcon(new ImageIcon(getClass().getResource("botão.png")));
        lbl_botaoAtaqueN3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barraVilao3.setValue(barraVilao3.getValue() - 50);
                lbl_ataqueMolho.setVisible(true);
                ++pontos;
                timerAtaqueMolho.restart();
            }
        });
        lbl_botaoAtaqueN3.setVisible(false);
        lbl_botaoAtaqueN3.setBounds(10, 290, 100, 100);
        backgroundPanel.add(lbl_botaoAtaqueN3);

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

        barraVilao2.setBounds(1050, 50, 100, 30);
        barraVilao2.setStringPainted(true);
        barraVilao2.setMaximum(800);
        barraVilao2.setValue(800);
        barraVilao2.setVisible(false);
        barraVilao2.setForeground(Color.red);
        backgroundPanel.add(barraVilao2);

        barraVilao3.setBounds(1050, 50, 100, 30);
        barraVilao3.setStringPainted(true);
        barraVilao3.setMaximum(1500);
        barraVilao3.setValue(1500);
        barraVilao3.setVisible(false);
        barraVilao3.setForeground(Color.red);
        backgroundPanel.add(barraVilao3);

        lbl_vidas_iconVilao = new JLabel();
        lbl_vidas_iconVilao.setIcon(new ImageIcon(getClass().getResource("vida.png")));
        lbl_vidas_iconVilao.setBounds(1150, 52, 25, 25);
        backgroundPanel.add(lbl_vidas_iconVilao);

        lbl_vilao = new JLabel();
        lbl_vilao.setIcon(new ImageIcon(getClass().getResource("Bacaxi.png")));
        lbl_vilao.setBounds(750, 260, 435, 554);
        backgroundPanel.add(lbl_vilao);

        lbl_vilao2 = new JLabel();
        lbl_vilao2.setIcon(new ImageIcon(getClass().getResource("OuveMelo.png")));
        lbl_vilao2.setVisible(false);
        lbl_vilao2.setBounds(750, 260, 435, 554);
        backgroundPanel.add(lbl_vilao2);

        lbl_vilao3 = new JLabel();
        lbl_vilao3.setIcon(new ImageIcon(getClass().getResource("PericlesoPicles.png")));
        lbl_vilao3.setVisible(false);
        lbl_vilao3.setBounds(700, 260, 554, 554);
        backgroundPanel.add(lbl_vilao3);

        lbl_heroi = new JLabel();
        lbl_heroi.setIcon(new ImageIcon(getClass().getResource("Burguinho.png")));
        lbl_heroi.setBounds(1, 250, 554, 554);
        backgroundPanel.add(lbl_heroi);

        setContentPane(backgroundPanel);


        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        int ganharVida = rand.nextInt(45);

        controlador.setScore1(pontos * 0.26);

        if (barraHeroi.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Nunca mais volte para o nosso reino, seu score foi de: " + controlador.getScore1());
            dispose();
            barraHeroi.setValue(100);
            timer.stop();
        }
        if (barraHeroi.getValue() <= 25) {
            JOptionPane.showMessageDialog(null, "Vamos dizer que você tem sorte, vai ganhar " + ganharVida);
            barraHeroi.setValue(barraHeroi.getValue() + ganharVida);
        }
        if (barraVilao.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Parabéns você conseguiu, seu score foi de: " + controlador.getScore1());
            Fase2 f2 = new Fase2(pontos);
            f2.setVisible(true);
            dispose();
            timer.stop();
            barraHeroi.setValue(1000);
        }
    }

    
 
}
