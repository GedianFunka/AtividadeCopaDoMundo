package com.example.AtividadeCopaDoMundo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataPartidade;

    @Positive(message = "A Quantidade deve ser maior que 0")
    private Integer quantidade;

    @ManyToOne
    private Selecao selecao;
}
