package com.grupo5.tpajedrez.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tablero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int[][] tablero;

    public Tablero() {
        tablero = new int[5][5];
    }
    public Tablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int[][] getTablero() {
        return tablero;
    }
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
}
