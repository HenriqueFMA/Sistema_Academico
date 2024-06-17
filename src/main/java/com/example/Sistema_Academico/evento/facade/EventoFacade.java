package com.example.Sistema_Academico.evento.facade;

import com.example.Sistema_Academico.evento.dto.EventoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoFacade {

    private final List<EventoDTO> eventos = new ArrayList<>();

    public EventoDTO criar(EventoDTO eventoDTO) {
        eventoDTO.setId((long) (eventos.size() + 1));
        eventos.add(eventoDTO);
        return eventoDTO;
    }

    public EventoDTO atualizar(EventoDTO eventoDTO, Long id) {
        for (EventoDTO evento : eventos) {
            if (evento.getId().equals(id)) {
                evento.setTitulo(eventoDTO.getTitulo());
                evento.setData(eventoDTO.getData());
                return evento;
            }
        }
        return null;
    }

    public List<EventoDTO> getAll() {
        return new ArrayList<>(eventos);
    }

    public EventoDTO getById(Long id) {
        return eventos.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Long id) {
        eventos.removeIf(e -> e.getId().equals(id));
    }
}
