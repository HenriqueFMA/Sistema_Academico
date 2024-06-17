package com.example.Sistema_Academico.alerta.api;

import com.example.Sistema_Academico.alerta.dto.AlertaDTO;
import com.example.Sistema_Academico.alerta.facade.AlertaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/alertas", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlertaAPI {

    @Autowired
    private AlertaFacade alertaFacade;

    @PostMapping
    @ResponseBody
    public AlertaDTO criar(@RequestBody AlertaDTO alertaDTO) {
        return alertaFacade.criar(alertaDTO);
    }

    @PutMapping("/{alertaId}")
    @ResponseBody
    public AlertaDTO atualizar(@PathVariable("alertaId") Long alertaId, @RequestBody AlertaDTO alertaDTO) {
        AlertaDTO atualizado = alertaFacade.atualizar(alertaDTO, alertaId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<AlertaDTO> getAll() {
        return alertaFacade.getAll();
    }

    @GetMapping("/{alertaId}")
    @ResponseBody
    public AlertaDTO getById(@PathVariable("alertaId") Long alertaId) {
        AlertaDTO alerta = alertaFacade.getById(alertaId);
        if (alerta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        }
        return alerta;
    }

    @DeleteMapping("/{alertaId}")
    @ResponseBody
    public String deletar(@PathVariable("alertaId") Long alertaId) {
        String result = alertaFacade.delete(alertaId);
        if ("Alerta não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        }
        return result;
    }
}
