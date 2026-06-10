package com.example.AtividadeCopaDoMundo.Controller;

import com.example.AtividadeCopaDoMundo.Model.Partida;
import com.example.AtividadeCopaDoMundo.Repository.PartidaRepository;
import com.example.AtividadeCopaDoMundo.Service.PartidaService;
import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor

public class PartidaController {

    private  final PartidaService partidaService;
    private final PartidaRepository partidaRepository;

    @GetMapping
    public List <Partida> listar( ){
        return partidaRepository.findAllByOrderByDataPartidaDesc();
    }

    @PostMapping
    public ResponseEntity <Partida> registrar (@Valid @RequestBody Partida partida){
        return ResponseEntity.status(201).body(partidaService.registrar(partida));
    }
}
