/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcadepong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Window;

/**
 *
 * @author PC
 */
public class ArcadePong {
    
    
    public ArcadePong(){
        Window janela = new Window(Definicoes.altura,Definicoes.largura);
        janela.setTitle("Ping Pong");
        GameImage fundo = new GameImage("resoucers/fundo1.png");
        Barra barra1 = new Barra("resoucers/barra1.png");
        Barra barra2 = new Barra("resoucers/barra2.png");
        Sound bate = new Sound("resoucers/bate.wav");
        Font fonte = new Font("A.C.M.E. Secret Agent", Font.BOLD,15);
        Explosao explosaoDireita = new Explosao("resoucers/explosaoDireita.png");
        Explosao explosaoEsquerda = new Explosao("resoucers/explosaoEsquerda.png");
        
        //explosaoDireita.setPosision(746, 100);
        //explosaoEsquerda.setPosision(12, 100);
        
        Keyboard teclado = janela.getKeyboard();
        Bola bola = new Bola();
        bola.setSentidoXY(Definicoes.RIGHT,Definicoes.STOP);
        
        //seta as posiçoes das duas barras
        barra1.setPosition(12, 255);
        barra2.setPosition(762, 255);
        
        //adiciona as teclas W e S no teclado para serem usadas em uma
        //das barras.
        teclado.addKey(KeyEvent.VK_W,Keyboard.DETECT_EVERY_PRESS );
        teclado.addKey(KeyEvent.VK_S,Keyboard.DETECT_EVERY_PRESS );
        
        barra1.setTeclaCima(KeyEvent.VK_W);
        barra1.setTeclaBaixo(KeyEvent.VK_S);
        
        barra2.setTeclaCima(Keyboard.UP_KEY);
        barra2.setTeclaBaixo(Keyboard.DOWN_KEY);
               
        boolean p1MarcouPonto = false;
        boolean p2MarcouPonto = false;
        boolean iniciar1 = false;
        boolean iniciar2 = false;
        String play1, play2;
        
        play1 = JOptionPane.showInputDialog(null,"Nome","Jogador 1");
        play2 = JOptionPane.showInputDialog(null,"Nome","Jogador 2");
        
        boolean loop = true;
        long contador = 0, tempo = 0;
        
        while(loop){
            
            fundo.draw();
            bola.draw();
            barra1.draw();
            barra2.draw();
            
            janela.drawText(play1 +" : "+Integer.toString(barra1.getPontos()), 20, 28, Color.GREEN,fonte);
            janela.drawText(play2 +" : "+Integer.toString(barra2.getPontos()), 645, 28, Color.GREEN, fonte);            
            
            bola.moveX();
            bola.moveY();
            barra1.mover(teclado);
            barra2.mover(teclado);
            barra1.controleSentido(teclado);
            barra2.controleSentido(teclado);
            
            if(bola.collided(barra1)){
                bola.setSentidoX(Definicoes.RIGHT);
                if(barra1.getSentido() == Definicoes.STOP){
                    if(bola.getSentidoY() == Definicoes.UP || bola.getSentidoY() == Definicoes.DOWN){
                    }
                } else {
                    bola.setSentidoY(barra1.getSentido());
                }
                new Sound("resoucers/bate.wav").play();
            }
            if(bola.collided(barra2)){
                bola.setSentidoX(Definicoes.LEFT);
                if(barra2.getSentido() == Definicoes.STOP){
                    if(bola.getSentidoY() == Definicoes.UP || bola.getSentidoY() == Definicoes.DOWN){
                    }
                } else {
                    bola.setSentidoY(barra2.getSentido());
                }
                new Sound("resoucers/bate.wav").play();
            }
            
            if(bola.atribuiPontosP1() && p1MarcouPonto == false){
                tempo = contador + 1500000;
                p1MarcouPonto = true;
                bola.hide();
            } 
            
            if(p1MarcouPonto && contador <= tempo){
                explosaoDireita.setPosision((int)bola.getX() - explosaoDireita.width + 15, (int)bola.getY() - bola.width);
                explosaoDireita.draw();
            } else {
                if(p1MarcouPonto){
                    barra1.setPontos(barra1.getPontos() + 1);
                    bola.centralizaBola();
                    p1MarcouPonto = false;
                    iniciar1 = true;
                    tempo = 0;
                    barra1.setPosition(12, 255);
                    barra2.setPosition(762, 255);
                    bola.unhide();
                    janela.restoreScreen();
                }
            }
            
            if(bola.atribuiPontosP2() && p2MarcouPonto == false){
                tempo = contador + 1500000;
                p2MarcouPonto = true;
                bola.hide();
            } 
            
            if(p2MarcouPonto && contador <= tempo){
                explosaoEsquerda.setPosision((int)bola.getX() + explosaoEsquerda.width - 35, (int)bola.getY());
                explosaoEsquerda.draw();
            } else {
                if(p2MarcouPonto){
                    barra2.setPontos(barra2.getPontos() + 1);
                    bola.centralizaBola();
                    p2MarcouPonto = false;
                    iniciar2 = true;
                    tempo = 0;
                    barra1.setPosition(12, 255);
                    barra2.setPosition(762, 255);
                    bola.unhide();
                    janela.restoreScreen();
                }
            }
            
            if(iniciar1){
                if(teclado.keyDown(Keyboard.SPACE_KEY)){
                    bola.setSentidoX(Definicoes.LEFT);
                    p1MarcouPonto = false;
                }
            } else if(iniciar2){
                       if(teclado.keyDown(Keyboard.SPACE_KEY)){
                            bola.setSentidoX(Definicoes.RIGHT);
                            p2MarcouPonto = false;
                       }
            }
            
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                loop = false;
            }
            
            contador += janela.timeElapsed();
            janela.update();

        }
        janela.exit();
    }
}
