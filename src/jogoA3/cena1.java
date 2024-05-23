package jogoA3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class cena1 extends JFrame {
    private BackgroundPanel backgroundPanel;
    private Clip audioClip;

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

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("mesa.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);
        add(backgroundPanel); // Adiciona o painel de fundo ao JFrame
    }

    // Método para iniciar a música quando a janela é exibida
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) { // Se a janela está sendo exibida
            // Carrega e inicia a música
        	System.out.print("sistema iniciado");
            playBackgroundMusic("testemusica.wav");
        }
    }

    private void playBackgroundMusic(String resourceName) {
    	try {
            // Obtém o recurso como URL
            URL resource = getClass().getResource(resourceName);
            if (resource == null) {
                System.err.println("Arquivo de áudio não encontrado: " + resourceName);
                return;
            }

            // Abre o recurso de áudio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resource);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            // Adiciona um ouvinte de eventos para detectar quando a música termina
            audioClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                	Fase1 f1 = new Fase1();
                	f1.setVisible(true);
                    dispose();
                    
                }
            });

            // Reproduz o áudio
            audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Método para parar a música quando a janela é fechada
    @Override
    public void dispose() {
        super.dispose();
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
        }
    }
}
