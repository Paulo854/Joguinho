package jogoA3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class cena1 extends JFrame {
    private BackgroundPanel backgroundPanel;
    private Clip audioClip;
    private JLabel imageLabel;
    private Timer timer;
    private boolean firstImageShown;
    //private JLabel pularCena;

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

    public cena1() {
        setTitle("Cena 1");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        
        ImageIcon backgroundImageIcon1 = new ImageIcon(getClass().getResource("imagem2.png"));
        ImageIcon backgroundImageIcon2 = new ImageIcon(getClass().getResource("imagem1.png"));

       
        imageLabel = new JLabel(backgroundImageIcon1);
        imageLabel.setBounds(0, 0, 1200, 800); 

       
        backgroundPanel = new BackgroundPanel(backgroundImageIcon1.getImage());
        backgroundPanel.setLayout(null);
        backgroundPanel.add(imageLabel);
        add(backgroundPanel);

        /*pularCena1 = new JLabel();
        pularCena1.setText("Pular História");*/

        
        firstImageShown = true;
        timer = new Timer(25000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstImageShown) {
                    imageLabel.setIcon(backgroundImageIcon2);
                } else {
                    imageLabel.setIcon(backgroundImageIcon1);
                }
                firstImageShown = !firstImageShown;
                timer.stop();
            }
        });

        timer.start(); 
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            System.out.println("Sistema iniciado");
            playBackgroundMusic("narrador.wav");
        }
    }

    private void playBackgroundMusic(String resourceName) {
        try {
            URL resource = getClass().getResource(resourceName);
            if (resource == null) {
                System.err.println("Arquivo de áudio não encontrado: " + resourceName);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resource);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            audioClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    Fase1 f1 = new Fase1();
                    f1.setVisible(true);
                    dispose();
                }
            });

            audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
        }
    }
}
