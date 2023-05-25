package com.grupo5.tpajedrez.repository;

import com.grupo5.tpajedrez.models.Tablero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Tablero, Integer> {
}
