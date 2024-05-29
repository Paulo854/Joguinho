package jogoA3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class jogoPrincipal extends JFrame {
    cena1 c1 = new cena1();
    verificabanco banco = new verificabanco();
    public JLabel lbl_iniciar;
    public JLabel lbl_score;
    public JLabel lbl_title;
    public JLabel imgLabel;

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
        setTitle("Menu inicial");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("telatitulo.png"));
        Image backgroundImage = backgroundImageIcon.getImage();

        // Carregar as duas imagens para alternar
        ImageIcon imgIcon1 = new ImageIcon(getClass().getResource("title1.png"));
        ImageIcon imgIcon2 = new ImageIcon(getClass().getResource("title2.png"));

        // Criar o JPanel com a imagem de fundo
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null);

        lbl_title = new JLabel();

        lbl_iniciar = new JLabel();
        lbl_iniciar.setIcon(new ImageIcon(getClass().getResource("botao_play.png")));
        lbl_iniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // c1.setVisible(true);
                Fase1 f1 = new Fase1();
                f1.setVisible(true);
                dispose();
            }
        });
        lbl_iniciar.setBounds(450, 500, 253, 117);
        backgroundPanel.add(lbl_iniciar);

        lbl_score = new JLabel();
        lbl_score.setText(banco.getNomeDoScore() + " teve a maior pontuaçã: " + banco.getMelhorScore());
        Font fonteTamanho = new Font("Press Start 2P", Font.PLAIN, 25);
        lbl_score.setFont(fonteTamanho);
        lbl_score.setForeground(Color.ORANGE);
        lbl_score.setBounds(10, 10, 9999, 50);
        backgroundPanel.add(lbl_score);

        // Adicionar o JLabel que alterna entre as imagens
        imgLabel = new JLabel(imgIcon1);
        imgLabel.setBounds(380, 1, imgIcon1.getIconWidth(), imgIcon1.getIconHeight());
        backgroundPanel.add(imgLabel);

        // Configurar o Timer para alternar as imagens // tive que usar chat GPT
        Timer timer = new Timer(500, new ActionListener() {
            private boolean toggle = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                imgLabel.setIcon(toggle ? imgIcon2 : imgIcon1);
                toggle = !toggle;
            }
        });
        timer.start();

        setContentPane(backgroundPanel);
    }

    public static void main(String[] args) {
        boolean repeticao = true;
        jogoPrincipal jogoPrincipal = new jogoPrincipal();
        verificarCampo verifica = new verificarCampo();
        ArmazenaControle controlador = new ArmazenaControle();
        do {
            try {
                jogoPrincipal.setVisible(true);
                String nome = (JOptionPane.showInputDialog("Informe qual será seu Username"));
                verifica.verificarCampo(nome);
                controlador.setNome(nome);
                repeticao = false;
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (repeticao);
    }
}
