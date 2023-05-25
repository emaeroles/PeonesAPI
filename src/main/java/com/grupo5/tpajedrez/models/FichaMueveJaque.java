package com.grupo5.tpajedrez.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FichaMueveJaque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int respuesta;

    public FichaMueveJaque() {  }
    public FichaMueveJaque(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }


}
