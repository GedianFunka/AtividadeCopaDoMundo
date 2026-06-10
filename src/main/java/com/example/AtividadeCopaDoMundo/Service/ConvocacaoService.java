package com.example.AtividadeCopaDoMundo.Service;

import com.example.AtividadeCopaDoMundo.Model.Convocacao;
import com.example.AtividadeCopaDoMundo.Model.Selecao;
import com.example.AtividadeCopaDoMundo.Repository.ConvocacaoRepository;
import com.example.AtividadeCopaDoMundo.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ConvocacaoService {

    private final ConvocacaoRepository convocacaoRepository;
    private final SelecaoRepository selecaoRepository;

    public Convocacao registrar (Convocacao convocacao){
        Selecao selecao =
                selecaoRepository.findById(convocacao.getSelecao().getId()) . orElseThrow(() -> new RuntimeException("Seleção não encontrada"));

        Integer saldoAtual = selecao.getJogadoresDisponiveis();
        selecao.setJogadoresDisponiveis((saldoAtual + convocacao.getQuantidade()));

        selecaoRepository.save(selecao);
        convocacao.setSelecao(selecao);
        return convocacaoRepository.save(convocacao);
    }

}