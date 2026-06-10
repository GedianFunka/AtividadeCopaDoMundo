package com.example.AtividadeCopaDoMundo.Service;

import com.example.AtividadeCopaDoMundo.Model.Convocacao;
import com.example.AtividadeCopaDoMundo.Model.Partida;
import com.example.AtividadeCopaDoMundo.Model.Selecao;
import com.example.AtividadeCopaDoMundo.Repository.ConvocacaoRepository;
import com.example.AtividadeCopaDoMundo.Repository.PartidaRepository;
import com.example.AtividadeCopaDoMundo.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final SelecaoRepository selecaoRepository;

        public Partida registrar (Partida partida){
        Selecao selecao =
            selecaoRepository.findById(partida.getSelecao().getId()).orElseThrow (() -> new RuntimeException("Seleção não encontrada"));

        if (selecao.getJogadoresDisponiveis() < partida.getQuantidade()){
            throw new RuntimeException("Quantidade indisponível de jogadores");
        }

        selecao.setJogadoresDisponiveis(selecao.getJogadoresDisponiveis() - partida.getQuantidade());

        selecaoRepository.save(selecao);
        partida.setSelecao();
        return partidaRepository.save(partida);
    }
}