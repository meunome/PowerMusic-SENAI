/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

/**
 *
 * @author Samara
 */
import java.awt.Graphics;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlayExtras.Imagem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utilidades.Utilidades;



public class FaseEasy3 extends Musica {

    public FaseEasy3(){
        super("musicas/Independencia.mid", "videos/Independencia.mpg", "img_cenario/FOTOS_BANDAS/capital_inicial/capinicial1.png", "img_cenario/FOTOS_BANDAS/capital_inicial/capinicial2.png", 3);
    }

    public void gameOver() {
        GameOver.getInstance().setMusica(17);
        GameEngine.getInstance().setNextGameStateController(24);
    }

    public void nextMusic() {
        GameEngine.getInstance().setNextGameStateController(26);
    }
}
