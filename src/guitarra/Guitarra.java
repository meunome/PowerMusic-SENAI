/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarra;

import java.awt.Graphics;
import java.util.ArrayList;
import javaPlay.GameObject;

/**
 *
 * @author fernando_mota
 */
public class Guitarra extends GameObject{
    public static Guitarra instancia = null;
    protected int[][] notas;
    protected Esfera[] esferas;
    protected int level;
    protected ArrayList<Esfera> notasEsferas;
    protected long timeElapsed;
    public Guitarra(){
        this.esferas = new Esfera[5];
        this.esferas[0] = new Vermelha();
        this.esferas[1] = new Azul();
        this.esferas[2] = new Verde();
        this.esferas[3] = new Laranja();
        this.esferas[4] = new Amarela();
        this.notasEsferas = new ArrayList<Esfera>();
    }
    static Guitarra getInstance() {
        if(Guitarra.instancia == null){
            Guitarra.instancia = new Guitarra();
        }
        return Guitarra.instancia;
    }
    public void setLevel(int level){
        this.level = level+1;
    }
    private Esfera[] getNotas(){
        for(int[] nota: notas){
            if(nota.length<this.level){
                continue;//Ignora notas com menos de 1 elemento
            }
            if(this.getSecondsElapsed() == nota[0]){//Verifica se é a nota à ser considerada
                Esfera[] esferasNotas = new Esfera[this.level];
                for(int c=0;c<this.level;c++){
                    esferasNotas[c] = this.esferas[nota[c]].getNewInstance();
                }
            }
        }
    }
    protected int getSecondsElapsed(){
        return (int) (this.timeElapsed/1000);
    }
    public void step(long timeElapsed) {
        this.timeElapsed += timeElapsed;
        for(Esfera nota: this.notasEsferas){
            nota.step(timeElapsed);
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Esfera nota: this.notasEsferas){
            nota.draw(g);
        }
    }
}