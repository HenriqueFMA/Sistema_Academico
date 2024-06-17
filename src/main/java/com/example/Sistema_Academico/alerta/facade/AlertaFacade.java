package com.example.Sistema_Academico.alerta.facade;

import com.example.Sistema_Academico.alerta.dto.AlertaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertaFacade {

    private List<AlertaDTO> alertas = new ArrayList<>();
    private long idCounter = 1;

    // Cria um novo alerta
    public AlertaDTO criar(AlertaDTO alertaDTO) {
        alertaDTO.setId(idCounter++);
        alertas.add(alertaDTO);
        return alertaDTO;
    }

    // Atualiza um alerta existente
    public AlertaDTO atualizar(AlertaDTO alertaDTO, Long alertaId) {
        Optional<AlertaDTO> optionalAlerta = alertas.stream()
                .filter(a -> a.getId().equals(alertaId))
                .findFirst();

        if (optionalAlerta.isPresent()) {
            AlertaDTO alertaExistente = optionalAlerta.get();
            alertaExistente.setTitulo(alertaDTO.getTitulo());
            alertaExistente.setDescricao(alertaDTO.getDescricao());
            alertaExistente.setVencimento(alertaDTO.getVencimento());
            return alertaExistente;
        } else {
            return null; // Alerta não encontrado
        }
    }

    // Retorna todos os alertas
    public List<AlertaDTO> getAll() {
        return new ArrayList<>(alertas);
    }

    // Busca um alerta pelo ID
    public AlertaDTO getById(Long alertaId) {
        return alertas.stream()
                .filter(a -> a.getId().equals(alertaId))
                .findFirst()
                .orElse(null);
    }

    // Deleta um alerta pelo ID
    public String delete(Long alertaId) {
        Optional<AlertaDTO> optionalAlerta = alertas.stream()
                .filter(a -> a.getId().equals(alertaId))
                .findFirst();

        if (optionalAlerta.isPresent()) {
            alertas.remove(optionalAlerta.get());
            return "Alerta deletado com sucesso";
        } else {
            return "Alerta não encontrado";
        }
    }
}
