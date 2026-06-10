package com.example.AtividadeCopaDoMundo.Controller;

import com.example.AtividadeCopaDoMundo.Model.Selecao;
import com.example.AtividadeCopaDoMundo.Repository.SelecaoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selecoes")
@RequiredArgsConstructor

public class SelecaoController {

    private final SelecaoRepository selecaoRepository;

    @GetMapping
    public List <Selecao> listar(){
        return selecaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Selecao> cadastrar(@Valid @RequestBody Selecao selecao){
        return ResponseEntity.status(201).body(selecaoRepository.saveAll(selecao));
    }
}