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

public class Convocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataConvocacao;

    @Positive(message = "A quantidade deve ser maior que 0")
    private Integer quantidade;

    @ManyToOne
    private Selecao selecao;
}
