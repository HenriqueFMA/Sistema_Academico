package com.example.Sistema_Academico.ocorrencia.facade;

import com.example.Sistema_Academico.ocorrencia.dto.OcorrenciaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaFacade {

    private List<OcorrenciaDTO> ocorrencias = new ArrayList<>();
    private long idCounter = 1;

    // Cria uma nova ocorrência
    public OcorrenciaDTO criar(OcorrenciaDTO ocorrenciaDTO) {
        ocorrenciaDTO.setId(idCounter++);
        ocorrencias.add(ocorrenciaDTO);
        return ocorrenciaDTO;
    }

    // Atualiza uma ocorrência existente
    public OcorrenciaDTO atualizar(OcorrenciaDTO ocorrenciaDTO, Long ocorrenciaId) {
        Optional<OcorrenciaDTO> optionalOcorrencia = ocorrencias.stream()
                .filter(o -> o.getId().equals(ocorrenciaId))
                .findFirst();

        if (optionalOcorrencia.isPresent()) {
            OcorrenciaDTO ocorrenciaExistente = optionalOcorrencia.get();
            ocorrenciaExistente.setNome(ocorrenciaDTO.getNome());
            ocorrenciaExistente.setTurma(ocorrenciaDTO.getTurma());
            ocorrenciaExistente.setTurno(ocorrenciaDTO.getTurno());
            ocorrenciaExistente.setTipo(ocorrenciaDTO.getTipo());
            ocorrenciaExistente.setTitulo(ocorrenciaDTO.getTitulo());
            ocorrenciaExistente.setDescricao(ocorrenciaDTO.getDescricao());
            ocorrenciaExistente.setFileLinks(ocorrenciaDTO.getFileLinks());
            return ocorrenciaExistente;
        } else {
            return null; // Ocorrência não encontrada
        }
    }

    // Retorna todas as ocorrências
    public List<OcorrenciaDTO> getAll() {
        return new ArrayList<>(ocorrencias);
    }

    // Busca uma ocorrência pelo ID
    public OcorrenciaDTO getById(Long ocorrenciaId) {
        return ocorrencias.stream()
                .filter(o -> o.getId().equals(ocorrenciaId))
                .findFirst()
                .orElse(null);
    }

    // Deleta uma ocorrência pelo ID
    public String delete(Long ocorrenciaId) {
        Optional<OcorrenciaDTO> optionalOcorrencia = ocorrencias.stream()
                .filter(o -> o.getId().equals(ocorrenciaId))
                .findFirst();

        if (optionalOcorrencia.isPresent()) {
            ocorrencias.remove(optionalOcorrencia.get());
            return "Ocorrência deletada com sucesso";
        } else {
            return "Ocorrência não encontrada";
        }
    }
}
