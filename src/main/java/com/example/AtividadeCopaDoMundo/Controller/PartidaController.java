package com.example.AtividadeCopaDoMundo.Controller;

import com.example.AtividadeCopaDoMundo.Model.Partida;
import com.example.AtividadeCopaDoMundo.Repository.PartidaRepository;
import com.example.AtividadeCopaDoMundo.Service.PartidaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/historico")
    public List <Partida> historico(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal){

        return partidaRepository.findByDataPartidaBetweenOrderByDataPartidaAsc(dataInicial, dataFinal);
    }

    @GetMapping("/mais-escalados")
    public List <Partida> maisEscalados(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        return partidaRepository.findMaisEscaladasNoPeriodo(dataInicial, dataFinal);
    }
    }