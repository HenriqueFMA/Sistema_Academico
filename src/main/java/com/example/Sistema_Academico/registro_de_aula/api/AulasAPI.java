package com.example.Sistema_Academico.registro_de_aula.api;

import com.example.Sistema_Academico.registro_de_aula.dto.AulaDTO;
import com.example.Sistema_Academico.registro_de_aula.facade.AulaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/aulas", produces = MediaType.APPLICATION_JSON_VALUE)
public class AulasAPI {

    @Autowired
    private AulaFacade aulaFacade;

    @PostMapping
    @ResponseBody
    public AulaDTO criar(@RequestBody AulaDTO aulaDTO) {
        return aulaFacade.criar(aulaDTO);
    }

    @PutMapping("/{aulaId}")
    @ResponseBody
    public AulaDTO atualizar(@PathVariable("aulaId") Long aulaId, @RequestBody AulaDTO aulaDTO) {
        AulaDTO atualizado = aulaFacade.atualizar(aulaDTO, aulaId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<AulaDTO> getAll() {
        return aulaFacade.getAll();
    }

    @GetMapping("/{aulaId}")
    @ResponseBody
    public AulaDTO getById(@PathVariable("aulaId") Long aulaId) {
        AulaDTO aula = aulaFacade.getById(aulaId);
        if (aula == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada");
        }
        return aula;
    }

    @DeleteMapping("/{aulaId}")
    @ResponseBody
    public String deletar(@PathVariable("aulaId") Long aulaId) {
        String result = aulaFacade.delete(aulaId);
        if ("Aula não encontrada".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada");
        }
        return result;
    }
}
