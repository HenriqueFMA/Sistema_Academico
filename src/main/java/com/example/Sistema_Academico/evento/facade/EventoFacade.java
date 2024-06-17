package com.example.Sistema_Academico.evento.facade;

import com.example.Sistema_Academico.evento.dto.EventoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoFacade {

    private List<EventoDTO> eventos = new ArrayList<>();
    private long idCounter = 1;

    // Cria um novo evento
    public EventoDTO criar(EventoDTO eventoDTO) {
        eventoDTO.setId(idCounter++);
        eventos.add(eventoDTO);
        return eventoDTO;
    }

    // Atualiza um evento existente
    public EventoDTO atualizar(EventoDTO eventoDTO, Long eventoId) {
        Optional<EventoDTO> optionalEvento = eventos.stream()
                .filter(e -> e.getId().equals(eventoId))
                .findFirst();

        if (optionalEvento.isPresent()) {
            EventoDTO eventoExistente = optionalEvento.get();
            eventoExistente.setData(eventoDTO.getData());
            eventoExistente.setTitulo(eventoDTO.getTitulo());
            return eventoExistente;
        } else {
            return null; // Evento não encontrado
        }
    }

    // Retorna todos os eventos
    public List<EventoDTO> getAll() {
        return new ArrayList<>(eventos);
    }

    // Busca um evento pelo ID
    public EventoDTO getById(Long eventoId) {
        return eventos.stream()
                .filter(e -> e.getId().equals(eventoId))
                .findFirst()
                .orElse(null);
    }

    // Deleta um evento pelo ID
    public String delete(Long eventoId) {
        Optional<EventoDTO> optionalEvento = eventos.stream()
                .filter(e -> e.getId().equals(eventoId))
                .findFirst();

        if (optionalEvento.isPresent()) {
            eventos.remove(optionalEvento.get());
            return "Evento deletado com sucesso";
        } else {
            return "Evento não encontrado";
        }
    }
}
