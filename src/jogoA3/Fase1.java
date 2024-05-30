package jogoA3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class Fase1 extends JFrame implements ActionListener {
    public JLabel lbl_vidas;
    public JLabel lbl_vidas_iconVilao;
    public JLabel lbl_vilao;
    public JLabel lbl_vilao2;
    public JLabel lbl_vilao3;
    public JLabel lbl_contVidas;
    public JLabel lbl_heroi;
    public JLabel lbl_heroiFase3;
    public JLabel lbl_pontos;
    public JLabel lbl_ataqueMolho;
    public JLabel lbl_defesabacaxi;
    public JLabel lbl_defesaOuvEMelo;
    public JLabel lbl_defesaPericles;
    public JLabel lbl_botaoAtaqueN;
    public JLabel lbl_botaoAtaqueN2;
    public JLabel lbl_botaoAtaqueN3;
    public JLabel lbl_acao1;
    public JLabel lbl_acao;
    public JLabel lbl_liberarVida;
    public int vidaRecom = 30;
    public int defendeBacaxi;
    public int defendeOuvEMelo;
    public int defendepericles;
    public int ataqueNormalVilao;
    public int ataqueNormalHeroi;
    public int superAtaqueVilao;
    public int superAtaqueHeroi; 
    public int errarAtaqueVilao;
    public int errarAtaqueHeroi;
    public int pontos = 1;
    public Timer timer;
    public int finalPontos;
    public int controladorPontos;
    public int vidaBacaxi = 800;
    public int vidaOuvEmelo = 1200;
    public int vidaPericles = 1800;
    public int acumaVida = 0;

    ArmazenaControle controlador = new ArmazenaControle();
    JProgressBar barraHeroi = new JProgressBar();
    JProgressBar barraVilao = new JProgressBar();
    JProgressBar barraVilao2 = new JProgressBar();
    JProgressBar barraVilao3 = new JProgressBar();
    private BackgroundPanel backgroundPanel;

    
    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }

        public void setBackgroundImage(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            repaint();
        }
    }

    public Fase1() {
        setTitle("Batalha 1 Caxi");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("mesa.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        backgroundPanel = new BackgroundPanel(backgroundImage);
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

        lbl_defesabacaxi = new JLabel();
        lbl_defesabacaxi.setIcon(new ImageIcon(getClass().getResource("defesa.png")));

        lbl_defesabacaxi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	lbl_acao1.setVisible(false);
            	lbl_acao.setVisible(false);
                Random d = new Random();
                int defesa;
                defesa = d.nextInt(10);
                	if(defesa <= 5) {
                		lbl_acao.setVisible(true);
                    	lbl_acao.setText("Defendeu!");
                    	++pontos;
                    }else {
                    	lbl_acao.setVisible(true);
                    	lbl_acao.setText("Ah não! Sua defesa não foi forte o suficiente!");
                    	barraHeroi.setValue(barraHeroi.getValue() - 3);
                    	++pontos;
                    }
            }
         });
        
        lbl_defesabacaxi.setBounds(150, 290, 100, 100);
        backgroundPanel.add(lbl_defesabacaxi); 
        
        lbl_liberarVida = new JLabel();
        lbl_liberarVida.setIcon(new ImageIcon(getClass().getResource("btn_vida.png")));
        lbl_liberarVida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(acumaVida >= 1) {
            		barraHeroi.setValue(barraHeroi.getValue() + vidaRecom);
            		lbl_acao.setText("Parabens você ganhou "+	vidaRecom+" de vida");
            		 --acumaVida;
            		++pontos;
            		System.out.print("qtd acumulado "+acumaVida+" qtd acumulado ponto "+pontos +" Sua vida foi para: "+vidaRecom);
            	}else {
            		lbl_acao.setText("Você não atingiu o número de turno necessário");
            	}
            }
        });
        lbl_liberarVida.setBounds(250, 290, 100, 100);
        backgroundPanel.add(lbl_liberarVida);
        
        lbl_defesaOuvEMelo = new JLabel();
        lbl_defesaOuvEMelo.setIcon(new ImageIcon(getClass().getResource("defesa.png")));
        lbl_defesaOuvEMelo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random d = new Random();
                int defesa;
                defesa = d.nextInt(10);
                	if(defesa <= 5) {
                		lbl_acao.setVisible(true);
                    	lbl_acao.setText("Defendeu!");
                    	++pontos;
                    }else {
                    	lbl_acao.setVisible(true);
                    	lbl_acao.setText("Ah não! Sua defesa não foi forte o suficiente!");
                    	barraHeroi.setValue(barraHeroi.getValue() - 10);
                    	++pontos;
                    }
            }
        });
        lbl_defesaOuvEMelo.setBounds(150, 290, 100, 100);
        lbl_defesaOuvEMelo.setVisible(false);
        backgroundPanel.add(lbl_defesaOuvEMelo); 
        
        lbl_defesaPericles = new JLabel();
        lbl_defesaPericles.setIcon(new ImageIcon(getClass().getResource("defesa.png")));
        lbl_defesaPericles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	lbl_acao.setVisible(false);
            	lbl_acao1.setVisible(false);
                Random d = new Random();
                int defesa;
                defesa = d.nextInt(10);
                	if(defesa <= 5) {
                    	lbl_acao.setVisible(true);
                    	lbl_acao.setText("Defendeu!");
                    	++pontos;
                    }else {
                    	lbl_acao.setVisible(true);
                    	lbl_acao.setText("Ah não! Sua defesa não foi forte o suficiente!");
                    	barraHeroi.setValue(barraHeroi.getValue() - 25);
                    	++pontos;
                    }
            }
        });
        lbl_defesaPericles.setBounds(150, 200, 100, 100);
        lbl_defesaPericles.setVisible(false);
        backgroundPanel.add(lbl_defesaPericles); 
        
        lbl_botaoAtaqueN = new JLabel();
        lbl_botaoAtaqueN.setIcon(new ImageIcon(getClass().getResource("botão.png")));
        
        
        lbl_botaoAtaqueN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	lbl_acao.setVisible(false);
            	lbl_acao1.setVisible(false);
            	int vida;
                int bacaxi;
                int normalAtaque = 7;
                int ataqueBacaxi = 5;
                Random r = new Random();
                vida = r.nextInt(10);
                bacaxi = r.nextInt(10);
                if (vida <= 2) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Errou...");
                } else if (vida <= 6) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Inimigo atingido!");
                    barraVilao.setValue(barraVilao.getValue() - normalAtaque);
                }else if(bacaxi <= 8) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Caramba! O inimigo defendeu!");

                }else {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("O ataque acertou um ponto fraco!");
                    barraVilao.setValue(barraVilao.getValue() - normalAtaque * 2);
                }
                if (bacaxi <= 5) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("... que bom que ele errou");
            		lbl_acao1.setBounds(880, 10, 9999, 50);
                } else if (bacaxi >= 7) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("Você foi atingido!");
            		lbl_acao1.setBounds(970, 10, 9999, 50);
                    barraHeroi.setValue(barraHeroi.getValue() - ataqueBacaxi);
                } else {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("Ai! Esse ataque foi muito forte...");
            		lbl_acao1.setBounds(800, 10, 9999, 50);
                    barraHeroi.setValue(barraHeroi.getValue() - ataqueBacaxi * 2);
                }
            lbl_ataqueMolho.setVisible(true);
                timerAtaqueMolho.restart();
                ++pontos;
        }
        });
        lbl_botaoAtaqueN.setBounds(10, 290, 100, 100);
        backgroundPanel.add(lbl_botaoAtaqueN);
        
        
        lbl_botaoAtaqueN2 = new JLabel();
        lbl_botaoAtaqueN2.setIcon(new ImageIcon(getClass().getResource("botão.png")));
        
        lbl_botaoAtaqueN2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int vida;
                int coleEmelo;
                int normalAtaque = 12;
                int AtaqueleColeEMelo = 10;
                Random r = new Random();
                vida = r.nextInt(10);
                coleEmelo = r.nextInt(10);
                if (vida <= 2) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Errou...");
                } else if (vida <= 6) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Inimigo atingido!");
                    barraVilao2.setValue(barraVilao2.getValue() - normalAtaque);
                }else if(coleEmelo <= 8) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Caramba! O inimigo defendeu!");

                }else {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("O ataque acertou um ponto fraco!");
                    barraVilao2.setValue(barraVilao2.getValue() - normalAtaque * 2);
                }
                if (coleEmelo <= 5) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("... que bom que ele errou");
            		lbl_acao1.setBounds(880, 10, 9999, 50);
                } else if (coleEmelo <= 7) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("Você foi atingido!");
            		lbl_acao1.setBounds(990, 10, 9999, 50);
                    barraHeroi.setValue(barraHeroi.getValue() - AtaqueleColeEMelo);
                } else {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("Ai! Esse ataque foi muito forte...");
            		lbl_acao1.setBounds(800, 10, 9999, 50);
                    barraHeroi.setValue(barraHeroi.getValue() - AtaqueleColeEMelo * 2);
                }
            lbl_ataqueMolho.setVisible(true);
                timerAtaqueMolho.restart();
                ++pontos;
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
            	int vida;
                int pericles;
                int normalAtaque = 20;
                int AtaquePericles = 50;
                Random r = new Random();
                vida = r.nextInt(10);
                pericles = r.nextInt(10);
                if (vida <= 2) {
                	lbl_acao.setVisible(true);
                	
            		lbl_acao.setText("Errou...");
                } else if (vida <= 8) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Inimigo atingido!");
                    barraVilao3.setValue(barraVilao3.getValue() - normalAtaque);
                }else if(pericles == 9) {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("Caramba! O inimigo defendeu!");
                }else {
                	lbl_acao.setVisible(true);
            		lbl_acao.setText("O ataque acertou um ponto fraco!");
                    barraVilao3.setValue(barraVilao3.getValue() - normalAtaque * 2);
                }
                if (pericles <= 3) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("... que bom que ele errou");
            		lbl_acao1.setBounds(880, 10, 9999, 50);
                } else if (pericles > 3 && pericles <= 6) {
                	lbl_acao1.setVisible(true);
            		lbl_acao1.setText("Você foi atingido!");
            		lbl_acao1.setBounds(990, 10, 9999, 50);
                    barraHeroi.setValue(barraHeroi.getValue() - AtaquePericles);
                }else if(pericles > 6 && pericles <= 8) {
                    	lbl_acao1.setVisible(true);
                    	lbl_acao1.setText("Ai! Esse ataque foi muito forte...");
                		lbl_acao1.setBounds(800, 10, 9999, 50);
                        barraHeroi.setValue(barraHeroi.getValue() - AtaquePericles * 2);
                    } else {
                    	if(barraVilao3.getValue() <= 950) {
                    lbl_acao1.setVisible(true);
                	lbl_acao1.setText("Tome cuidado, ele regenerou vida");
                	lbl_acao1.setBounds(780, 10, 9999, 50);
                	barraVilao3.setValue(barraVilao3.getValue() + 40);
                    	}
                }
            lbl_ataqueMolho.setVisible(true);
                timerAtaqueMolho.restart();
                ++pontos;
        }
        });
        lbl_botaoAtaqueN3.setVisible(false);
        lbl_botaoAtaqueN3.setBounds(10, 200, 100, 100);
        backgroundPanel.add(lbl_botaoAtaqueN3);

        
        
        lbl_acao = new JLabel();
        Font fonteTamanho = new Font("Press Start 2P", Font.PLAIN, 25); 
        lbl_acao.setFont(fonteTamanho);
        lbl_acao.setForeground(Color.black); 
        lbl_acao.setBounds(10, 10, 9999, 50);
        backgroundPanel.add(lbl_acao);
        
        lbl_acao1 = new JLabel();
        Font fonteTamanho2 = new Font("Press Start 2P", Font.PLAIN, 25); 
        lbl_acao1.setFont(fonteTamanho2);
        lbl_acao1.setForeground(Color.black); 
        lbl_acao1.setBounds(800, 10, 9999, 50);
        backgroundPanel.add(lbl_acao1);
        
        
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
        barraVilao.setMaximum(vidaBacaxi);
        barraVilao.setValue(vidaBacaxi);
        barraVilao.setForeground(Color.red);
        backgroundPanel.add(barraVilao);

        barraVilao2.setBounds(1050, 50, 100, 30);
        barraVilao2.setStringPainted(true);
        barraVilao2.setMaximum(vidaOuvEmelo);
        barraVilao2.setValue(vidaOuvEmelo);
        barraVilao2.setVisible(false);
        barraVilao2.setForeground(Color.red);
        backgroundPanel.add(barraVilao2);

        barraVilao3.setBounds(1050, 50, 100, 30);
        barraVilao3.setStringPainted(true);
        barraVilao3.setMaximum(vidaPericles);
        barraVilao3.setValue(vidaPericles);
        barraVilao3.setVisible(false);
        barraVilao3.setForeground(Color.red);
        backgroundPanel.add(barraVilao3);

        lbl_vidas_iconVilao = new JLabel();
        lbl_vidas_iconVilao.setIcon(new ImageIcon(getClass().getResource("vida.png")));
        lbl_vidas_iconVilao.setBounds(1150, 52, 25, 25);
        backgroundPanel.add(lbl_vidas_iconVilao);

        lbl_vilao = new JLabel();
        lbl_vilao.setIcon(new ImageIcon(getClass().getResource("Bacaxi.png")));
        lbl_vilao.setBounds(750, 220, 435, 554);
        backgroundPanel.add(lbl_vilao);

        lbl_vilao2 = new JLabel();
        lbl_vilao2.setIcon(new ImageIcon(getClass().getResource("OuveMelo.png")));
        lbl_vilao2.setVisible(false);
        lbl_vilao2.setBounds(750, 260, 435, 554);
        backgroundPanel.add(lbl_vilao2);
        
        

        lbl_vilao3 = new JLabel();
        lbl_vilao3.setIcon(new ImageIcon(getClass().getResource("PericlesoPicles.png")));
        lbl_vilao3.setVisible(false);
        lbl_vilao3.setBounds(660, 200, 435, 554);
        backgroundPanel.add(lbl_vilao3);

        lbl_heroi = new JLabel();
        lbl_heroi.setIcon(new ImageIcon(getClass().getResource("Burguinho.png")));
        lbl_heroi.setBounds(1, 250, 554, 554);
        backgroundPanel.add(lbl_heroi);
        
        lbl_heroiFase3 = new JLabel();
        lbl_heroiFase3.setIcon(new ImageIcon(getClass().getResource("Burguinho.png")));
        lbl_heroiFase3.setVisible(false);
        lbl_heroiFase3.setBounds(1, 200, 554, 554);
        backgroundPanel.add(lbl_heroiFase3);

        setContentPane(backgroundPanel);

        timer = new Timer(50, this);
        timer.start();
    }

    public void setBackgroundImage(Image backgroundImage) {
        backgroundPanel.setBackgroundImage(backgroundImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();

        finalPontos = pontos - controladorPontos;
        finalPontos = finalPontos - 1;
        
        controlador.setScore1(finalPontos);

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
        if (barraHeroi.getValue() <= 0) {
        	lbl_heroi.setIcon(new ImageIcon(getClass().getResource("morte.png")));
        	lbl_botaoAtaqueN.setVisible(false);
        	lbl_defesabacaxi.setVisible(false);
        	lbl_liberarVida.setVisible(false);
        	lbl_heroi.setBounds(1,250, 500, 500);
            JOptionPane.showMessageDialog(null, "O burguinho falhou em sua missão, o reino da cozinha perdeu seu principe");
            timer.stop();
            dispose();
        }
        if (barraVilao.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "Parabéns você conseguiu");
            int vidaHeroi = barraHeroi.getValue();
            Fase2 f2 = new Fase2(pontos, vidaHeroi, acumaVida);
            f2.setVisible(true);
            timer.stop();
            dispose();
        }
    }
}
