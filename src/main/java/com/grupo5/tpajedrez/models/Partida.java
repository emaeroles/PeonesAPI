package com.grupo5.tpajedrez.models;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    Tablero tableroObj;
    private int[][] tablero;
    int turno = 2;
    boolean segundoTouch;
    int[] posicionVieja;
    List<int[]> movimientosPosibles;
    Peon peon;

    public Partida() {
        tableroObj = new Tablero();
        tablero = tableroObj.getTablero();
        iniciarEscaques();
        rellenerEscaques();
        segundoTouch = false;
        peon = new Peon();
    }

    public int[][] getTablero() {
        return tablero;
    }
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    public Tablero getTableroObj() {
        return tableroObj;
    }
    public void setTableroObj(Tablero tableroObj) {
        this.tableroObj = tableroObj;
    }

    public int getContenidoEscaque(int[] posicion) {
        return tablero[posicion[0]][posicion[1]];
    }
    public void setContenidoEscaque(int[] posicion, int contenido) {
        getTablero()[posicion[0]][posicion[1]] = contenido;
    }

    public FichaMueveJaque movimientoTotal(String posicion) {

        int[] posicionBoton = new int[posicion.length()];
        for (int i = 0; i < posicion.length(); i++) {
            posicionBoton[i] = Character.getNumericValue(posicion.charAt(i));
        }

        int contenidoEscaque = 0;
        contenidoEscaque = getContenidoEscaque(posicionBoton);

        if (!segundoTouch && contenidoEscaque / 10 == turno) {
            movimientosPosibles = peon.movPosibles(tablero, posicionBoton);
            posicionVieja = posicionBoton;
            segundoTouch = true;
            return new FichaMueveJaque(1);
        } else if (segundoTouch && contenidoEscaque >= 100) {
            borrarPosibles(movimientosPosibles);
            movimiento(posicionVieja, posicionBoton);
            segundoTouch = false;
            cambiarTurno();
            return new FichaMueveJaque(2);
        } else {
            return new FichaMueveJaque(3);
        }
    }

    private void cambiarTurno() {
        if (turno == 2) {
            turno = 3;
        } else {
            turno = 2;
        }
    }

    public void movimiento(int[] posicion1, int[] posicion2) {
        int contenido = getContenidoEscaque(posicion1);
        setContenidoEscaque(posicion2, contenido);
        setContenidoEscaque(posicion1, 0);
    }

    public void borrarPosibles(List<int[]> movimientosPosibles) {
        for (int[] movimientoPosible : movimientosPosibles) {
            tablero[movimientoPosible[1]][movimientoPosible[0]] -= 100;
        }
    }

    private void iniciarEscaques() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || j == 0 || i == 4 || j == 4) {
                    tablero[i][j] = 1;
                }
            }
        }
    }

    private void rellenerEscaques() {
        tablero[2][1] = 24;
        tablero[1][3] = 34;
    }
}

