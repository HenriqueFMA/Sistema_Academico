package com.example.Sistema_Academico.evento.api;

import com.example.Sistema_Academico.evento.dto.EventoDTO;
import com.example.Sistema_Academico.evento.facade.EventoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/eventos")
public class EventoAPI {

    @Autowired
    private EventoFacade eventoFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventoDTO criar(@RequestBody EventoDTO eventoDTO) {
        return eventoFacade.criar(eventoDTO);
    }

    @PutMapping("/{eventoId}")
    public EventoDTO atualizar(@PathVariable Long eventoId, @RequestBody EventoDTO eventoDTO) {
        return eventoFacade.atualizar(eventoDTO, eventoId);
    }

    @GetMapping
    public List<EventoDTO> getAll() {
        return eventoFacade.getAll();
    }

    @GetMapping("/{eventoId}")
    public EventoDTO getById(@PathVariable Long eventoId) {
        return eventoFacade.getById(eventoId);
    }

    @DeleteMapping("/{eventoId}")
    public void delete(@PathVariable Long eventoId) {
        eventoFacade.delete(eventoId);
    }
}
