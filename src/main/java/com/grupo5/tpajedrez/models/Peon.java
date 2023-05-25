package com.grupo5.tpajedrez.models;

import java.util.ArrayList;
import java.util.List;

public class Peon {

    public List<int[]> movPosibles(int[][] tablero, int[] posicion){
        List<int[]> movimientosPosibles = new ArrayList<>();
        int[] movimientoPosible;
        int[][] escaques = tablero;
        int pasos;
        int c = posicion[0];
        int r = posicion[1];

        if(escaques[c][r] / 10 == 2 && posicion[1] == 2 || escaques[c][r] / 10 == 3 && posicion[1] == 7){
            pasos = 2;
        } else {
            pasos = 1;
        }

        if(escaques[c][r] / 10 == 2){
            do{
                r++;
                if(escaques[c][r] == 0){
                    escaques[c][r] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(escaques[c][r] == 100 && pasos > 0);

            c = posicion[0] + 1;
            r = posicion[1] + 1;
            for(int i = 0; i < 2; i++){
                if(escaques[c][r] / 10 == 3 && escaques[c][r] != 1){
                    escaques[c][r] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                }
                c -= 2;
            }
            c = posicion[0];
            r = posicion[1];
        }

        if(escaques[c][r] / 10 == 3){
            do{
                r--;
                if(escaques[c][r] == 0){
                    escaques[c][r] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(escaques[c][r] == 100 && pasos > 0);

            c = posicion[0] - 1;
            r = posicion[1] - 1;
            for(int i = 0; i < 2; i++){
                if(escaques[c][r] / 10 == 2 && escaques[c][r] != 1){
                    escaques[c][r] += 100;
                    movimientoPosible = new int[] {c,r};
                    movimientosPosibles.add(movimientoPosible);
                }
                c += 2;
            }
        }

        return movimientosPosibles;
    }
}
