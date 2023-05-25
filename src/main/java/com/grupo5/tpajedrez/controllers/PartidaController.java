package com.grupo5.tpajedrez.controllers;

import com.grupo5.tpajedrez.models.FichaMueveJaque;
import com.grupo5.tpajedrez.models.Partida;
import com.grupo5.tpajedrez.models.Tablero;
import com.grupo5.tpajedrez.repository.IFiMuJaRepositori;
import com.grupo5.tpajedrez.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PartidaController {
    Partida partida = new Partida();
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IFiMuJaRepositori fiMuJaRepositori;

    @GetMapping("/gettablero")
    public Tablero getTablero(){
        return partida.getTableroObj();
    }

    @GetMapping("/getmov/{posicion}")
    public FichaMueveJaque getMov(@PathVariable String posicion){
        return partida.movimientoTotal(posicion);
    }

    @GetMapping("/gettablero/{id}")
    public Optional<Tablero> getTableroById(@PathVariable int id){
        return usuarioRepository.findById(id);
    }

    @GetMapping("/save")
    public void guardarTablero(){
        usuarioRepository.save(partida.getTableroObj());
    }

    @PostMapping("/postprueba")
    public void postPrueba(@RequestBody FichaMueveJaque fmj){
        fiMuJaRepositori.save(fmj);
    }

    @PutMapping("/putprueba")
    public void putPrueba(@RequestBody FichaMueveJaque fmj){
        fiMuJaRepositori.save(fmj);
    }

    @DeleteMapping("/deleteprueba/{id}")
    public void deleteprueba(@PathVariable int id){
        try{
            Optional<FichaMueveJaque> fmj = fiMuJaRepositori.findById(id);
            fiMuJaRepositori.delete(fmj.get());
        } catch (Error e){

        }

    }

}
