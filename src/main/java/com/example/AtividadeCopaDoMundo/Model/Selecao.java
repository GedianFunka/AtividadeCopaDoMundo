package com.example.AtividadeCopaDoMundo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O nome do grupo é obrigatório")
    private String grupo;

    private String fase;

    @Min(value = 0, message = "o  numero de gols marcados não pode ser negativo")
    private Integer golsMarcados;

    @Min(value = 0, message = "O numero de gols sofridos não pode ser negativo")
    private Integer golsSofridos;

    @Positive(message = "O valor do pantel precisa ser maior que 0")
    private double valorPlantel;

    private Integer jogadoresDisponiveis = 0;
}
