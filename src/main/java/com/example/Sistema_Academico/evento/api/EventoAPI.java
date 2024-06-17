package com.example.Sistema_Academico.evento.api;

import com.example.Sistema_Academico.evento.dto.EventoDTO;
import com.example.Sistema_Academico.evento.facade.EventoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/eventos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoAPI {

    @Autowired
    private EventoFacade eventoFacade;

    @PostMapping
    @ResponseBody
    public EventoDTO criar(@RequestBody EventoDTO eventoDTO) {
        return eventoFacade.criar(eventoDTO);
    }

    @PutMapping("/{eventoId}")
    @ResponseBody
    public EventoDTO atualizar(@PathVariable("eventoId") Long eventoId, @RequestBody EventoDTO eventoDTO) {
        EventoDTO atualizado = eventoFacade.atualizar(eventoDTO, eventoId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<EventoDTO> getAll() {
        return eventoFacade.getAll();
    }

    @GetMapping("/{eventoId}")
    @ResponseBody
    public EventoDTO getById(@PathVariable("eventoId") Long eventoId) {
        EventoDTO evento = eventoFacade.getById(eventoId);
        if (evento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado");
        }
        return evento;
    }

    @DeleteMapping("/{eventoId}")
    @ResponseBody
    public String deletar(@PathVariable("eventoId") Long eventoId) {
        String result = eventoFacade.delete(eventoId);
        if ("Evento não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado");
        }
        return result;
    }
}
