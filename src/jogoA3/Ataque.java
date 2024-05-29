package jogoA3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Ataque extends Fase1 {
    private JLabel lbl_acaoHeroi;
    private JLabel lbl_acaoVilao;
    private JLabel lbl_ataqueMolho;
    private JProgressBar barraVilao;
    private JProgressBar barraHeroi;
    private Timer timerAtaqueMolho;
    private int pontos;

    public Ataque(int a, int b, int c, int d, int h, int ataqueVilao) {
        super(); // Chama o construtor da classe pai (Fase1)
        this.lbl_acaoHeroi = super.lbl_acao;
        this.lbl_acaoVilao = super.lbl_acao1;
        this.lbl_ataqueMolho = super.lbl_ataqueMolho;
        this.barraVilao = super.barraVilao;
        this.barraHeroi = super.barraHeroi;
        this.pontos = super.pontos;

        // Inicializa o Timer
        timerAtaqueMolho = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_ataqueMolho.setVisible(false);
            }
        });
        timerAtaqueMolho.setRepeats(false);

        // Adiciona o MouseListener ao botão de ataque
        super.lbl_botaoAtaqueN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                atacar(a, b, c, d, h, ataqueVilao);
            }
        });
    }

    public int atacar(int a, int b, int c, int d, int h, int ataqueVilao) {
        lbl_acaoHeroi.setVisible(false);
        lbl_acaoVilao.setVisible(false);

        int vida;
        int vilao;
        int normalAtaque = 7;
        Random r = new Random();
        vida = r.nextInt(10);
        vilao = r.nextInt(10);

        if (vida <= a) {
            lbl_acaoHeroi.setVisible(true);
            lbl_acaoHeroi.setText("Errou...");
        } else if (vida <= b) {
            lbl_acaoHeroi.setVisible(true);
            lbl_acaoHeroi.setText("Inimigo atingido!");
            barraVilao.setValue(barraVilao.getValue() - normalAtaque);
        } else if (vilao <= c) {
            lbl_acaoHeroi.setVisible(true);
            lbl_acaoHeroi.setText("Caramba! O inimigo defendeu!");
        } else {
            lbl_acaoHeroi.setVisible(true);
            lbl_acaoHeroi.setText("O ataque acertou um ponto fraco!");
            barraVilao.setValue(barraVilao.getValue() - normalAtaque * 2);
        }

        if (vilao <= d) {
            lbl_acaoVilao.setVisible(true);
            lbl_acaoVilao.setText("... que bom que ele errou");
            lbl_acaoVilao.setBounds(880, 10, 9999, 50);
        } else if (vilao >= h) {
            lbl_acaoVilao.setVisible(true);
            lbl_acaoVilao.setText("Você foi atingido!");
            lbl_acaoVilao.setBounds(970, 10, 9999, 50);
            barraHeroi.setValue(barraHeroi.getValue() - ataqueVilao);
        } else {
            lbl_acaoVilao.setVisible(true);
            lbl_acaoVilao.setText("Ai! Esse ataque foi muito forte...");
            lbl_acaoVilao.setBounds(800, 10, 9999, 50);
            barraHeroi.setValue(barraHeroi.getValue() - ataqueVilao * 2);
        }

        lbl_ataqueMolho.setVisible(true);
        timerAtaqueMolho.restart();
        ++pontos;

        return pontos;
    }
}
