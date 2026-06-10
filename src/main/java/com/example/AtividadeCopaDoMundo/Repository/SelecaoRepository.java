package com.example.AtividadeCopaDoMundo.Repository;

import com.example.AtividadeCopaDoMundo.Model.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelecaoRepository extends JpaRepository<Selecao, Long> {

    @Query("SELECT s FROM Selecao s ORDER BY s.grupo ASC, s.nome ASC")
    List<Selecao> findAllByOrderByGrupo();

    List <Selecao> findByjogadoresDisponiveisLessThanEqualOrJogadoresDisponiveisGreaterThanEqual(Integer min , Integer max);


}
