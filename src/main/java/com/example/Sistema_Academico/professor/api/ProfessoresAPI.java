package com.example.Sistema_Academico.professor.api;

import com.example.Sistema_Academico.professor.dto.ProfessorDTO;
import com.example.Sistema_Academico.professor.facade.ProfessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/professores", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfessoresAPI {

    @Autowired
    private ProfessorFacade professorFacade;

    // Criar um novo professor
    @PostMapping
    @ResponseBody
    public ProfessorDTO criar(@RequestBody ProfessorDTO professorDTO) {
        return professorFacade.criar(professorDTO);
    }

    // Atualizar um professor existente
    @PutMapping("/{professorId}")
    @ResponseBody
    public ProfessorDTO atualizar(@PathVariable("professorId") Long professorId, @RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO atualizado = professorFacade.atualizar(professorDTO, professorId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        return atualizado;
    }

    // Obter todos os professores
    @GetMapping
    @ResponseBody
    public List<ProfessorDTO> getAll() {
        return professorFacade.getAll();
    }

    // Obter um professor pelo ID
    @GetMapping("/{professorId}")
    @ResponseBody
    public ProfessorDTO getById(@PathVariable("professorId") Long professorId) {
        ProfessorDTO professor = professorFacade.getById(professorId);
        if (professor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        return professor;
    }

    // Deletar um professor pelo ID
    @DeleteMapping("/{professorId}")
    @ResponseBody
    public String deletar(@PathVariable("professorId") Long professorId) {
        String result = professorFacade.delete(professorId);
        if ("Professor não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        return result;
    }
}
