/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcadepong;

import jplay.Keyboard;
import jplay.Sprite;

/**
 *
 * @author Ricardo Barbosa da Cunha Macedo
 */
public class Barra extends Sprite{
    private int sentido;
    private int teclaCima;
    private int teclaBaixo;
    private int pontos;
    
    
    public Barra(String barra){
        super(barra);
    }
    
    
    public void setPosition(int x, int y){
        setX(x);
        setY(y);
    }
    
    public void mover(Keyboard teclado){
        if((teclado.keyDown(getTeclaCima()) && this.y >= Definicoes.limite_cima + 5)){
            this.y--;
        } else {
            if((teclado.keyDown(getTeclaBaixo()) && this.y <= Definicoes.limite_baixo - 80)){
                this.y++;
            }
        }
    }
    
    public void controleSentido(Keyboard teclado){
        if(teclado.keyDown(getTeclaCima())){
            setSentido(Definicoes.UP);
        }
        else if(teclado.keyDown(getTeclaBaixo())){
            setSentido(Definicoes.DOWN);
        }
        else{
            setSentido(Definicoes.STOP);
        }
    }

    public int getSentido() {
        return sentido;
    }

    public void setSentido(int sentido) {
        this.sentido = sentido;
    }

    public int getTeclaCima() {
        return teclaCima;
    }

    public void setTeclaCima(int teclaCima) {
        this.teclaCima = teclaCima;
    }

    public int getTeclaBaixo() {
        return teclaBaixo;
    }

    public void setTeclaBaixo(int teclaBaixo) {
        this.teclaBaixo = teclaBaixo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
