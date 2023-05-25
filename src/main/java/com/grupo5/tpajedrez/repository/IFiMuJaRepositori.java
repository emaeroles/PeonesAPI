package com.grupo5.tpajedrez.repository;

import com.grupo5.tpajedrez.models.FichaMueveJaque;
import com.grupo5.tpajedrez.models.Tablero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFiMuJaRepositori extends CrudRepository<FichaMueveJaque, Integer> {
}
