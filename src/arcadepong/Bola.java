package arcadepong;

import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;

/**
 *
 * @author Ricardo Barbosa da Cunha Macêdo
 * 
 */
public class Bola extends Sprite{
    private int sentidoX;
    private int sentidoY;
    private double velocidadeX = 0.5;
    private double velocidadeY = 0.5;
    
    public Bola(){
        super("resoucers/bola3.png");
        centralizaBola();
    }
    
    public void setSentidoXY(int sentidoX, int sentidoY){
        setSentidoX(sentidoX);
        setSentidoY(sentidoY);
    }
    
    public void centralizaBola(){
       this.setX(Definicoes.altura/2);
       this.setY(Definicoes.largura/2);
       sentidoX = Definicoes.STOP;
       sentidoY = Definicoes.STOP;
    }
    
    public void moveX(){
        
        if(getSentidoX() == Definicoes.RIGHT && this.x <= Definicoes.limite_direito){
            this.x += velocidadeX;
        }
        else{
            if(getSentidoX() == Definicoes.LEFT && this.x >= Definicoes.limite_esquerdo){
                this.x -= velocidadeX;
            }
        }
    }
    
    public void moveY(){
        if(getSentidoY() == Definicoes.UP && this.y >= Definicoes.limite_cima){
            this.y -= velocidadeY;
        }
        else{ 
            if(getSentidoY() == Definicoes.DOWN && this.y <= Definicoes.limite_baixo){
                this.y += velocidadeY;
            }
            else{
                boolean bateu = false;
                if(getSentidoY() == Definicoes.UP && this.y <= Definicoes.limite_cima){
                    setSentidoY(Definicoes.DOWN);
                    bateu = true;
                }
                else
                if(getSentidoY() == Definicoes.DOWN && this.y >= Definicoes.limite_baixo){
                    setSentidoY(Definicoes.UP);
                    bateu = true;
                }
            }
        }
    }
    
    public boolean atribuiPontosP1(){
        boolean retorno = false;
        if(this.x >= Definicoes.limite_direito){
            retorno = true;
        }
        return retorno;
    }
    
    public boolean atribuiPontosP2(){
        boolean retorno = false;
        if(this.x <= Definicoes.limite_esquerdo){
            retorno = true;
        }
        return retorno;
    }

    public int getSentidoX() {
        return sentidoX;
    }

    public void setSentidoX(int sentidoX) {
        this.sentidoX = sentidoX;
    }

    public int getSentidoY() {
        return sentidoY;
    }

    public void setSentidoY(int sentidoY) {
        this.sentidoY = sentidoY;
    }
}
