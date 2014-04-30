/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcadepong;

import jplay.Sprite;

/**
 *
 * @author PC
 */
public class Explosao extends Sprite{
    private int posicaoX;
    private int posicaoY;
    
    public Explosao(String nome){
        super(nome);
    }
    
    
    public void setPosision(int posicaoX, int posicaoY){
        setX(posicaoX);
        setY(posicaoY);
    }
    
    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    
    
}
