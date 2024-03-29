package com.politecnicomalaga.madmaxroad.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Clase Fondo. Se encarga de dibujar y avanzar una simulación de "camara" por una imagen dada
 * En una escena tendremos varios fondos.
 */

public class Fondo {
    /////////////////////////////////////////////////////////////////////////////////////
    //
    //ESTADO
    //
    /////////////////////////////////////////////////////////////////////////////////////
    private final Texture imgFondo; //Nuestra imagen a pintar.

    private final int velocidadX;
    private final int velocidadY;

    private int posX;
    private int posY;
    private final int anchoVentana;
    private final int altoVentana;
    private final int ancho;
    private final int alto;

    /////////////////////////////////////////////////////////////////////////////////////
    //
    //COMPORTAMIENTOS
    //
    /////////////////////////////////////////////////////////////////////////////////////

    //CONSTRUCTOR/ES
    public Fondo(String fichero, int velImagenX, int velImagenY, int posIniX, int posIniY, int anV, int alV) {

        velocidadX = velImagenX;
        velocidadY = velImagenY;
        posX = posIniX;
        posY = posIniY;

        altoVentana = alV;
        anchoVentana = anV;
        imgFondo = new Texture(".\\assets\\" + fichero);
        ancho = imgFondo.getWidth();
        alto = imgFondo.getHeight();


    }

    //RESTO DE COMPORTAMIENTOS


    //método para avanzar la cámara
    public void avanzar() {

        posX = posX + velocidadX;
        posY = posY + velocidadY;
        if (posX + anchoVentana >= ancho && velocidadX > 0) {
            //nos hemos pasado del final del fondo, volvemos al principio
            posX = posX + anchoVentana - ancho;
        }
        if (posX <= 0 && velocidadX < 0) {
            posX = ancho - anchoVentana;
        }
        if (posY + altoVentana >= alto && velocidadY > 0) {
            posY = posY + altoVentana - alto;
        }
        if (posY <= 0 && velocidadY < 0) {
            posY = alto - altoVentana;
        }
    }

    //Comportamiento para pintar la ventana del fondo a utilizar
    public void pintate(SpriteBatch miSB) {
        TextureRegion ventana; //Nos sirve para mapear la imagen y pintarla.

        ventana = new TextureRegion(imgFondo, posX, posY, anchoVentana, altoVentana);
        miSB.begin();
        miSB.draw(ventana, 0, 0);
        miSB.end();
    }


    //Método para liberar recursos
    public void dispose() {
        imgFondo.dispose();
    }


    public int getAltoFondo() {
        return imgFondo.getHeight();
    }

    public int getAnchoFondo() {
        return imgFondo.getWidth();
    }
}















