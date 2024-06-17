package com.example.Sistema_Academico.ocorrencia.api;

import com.example.Sistema_Academico.ocorrencia.dto.OcorrenciaDTO;
import com.example.Sistema_Academico.ocorrencia.facade.OcorrenciaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/ocorrencias", produces = MediaType.APPLICATION_JSON_VALUE)
public class OcorrenciaAPI {

    @Autowired
    private OcorrenciaFacade ocorrenciaFacade;

    @PostMapping
    @ResponseBody
    public OcorrenciaDTO criar(@RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ocorrenciaFacade.criar(ocorrenciaDTO);
    }

    @PutMapping("/{ocorrenciaId}")
    @ResponseBody
    public OcorrenciaDTO atualizar(@PathVariable("ocorrenciaId") Long ocorrenciaId, @RequestBody OcorrenciaDTO ocorrenciaDTO) {
        OcorrenciaDTO atualizado = ocorrenciaFacade.atualizar(ocorrenciaDTO, ocorrenciaId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ocorrência não encontrada");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<OcorrenciaDTO> getAll() {
        return ocorrenciaFacade.getAll();
    }

    @GetMapping("/{ocorrenciaId}")
    @ResponseBody
    public OcorrenciaDTO getById(@PathVariable("ocorrenciaId") Long ocorrenciaId) {
        OcorrenciaDTO ocorrencia = ocorrenciaFacade.getById(ocorrenciaId);
        if (ocorrencia == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ocorrência não encontrada");
        }
        return ocorrencia;
    }

    @DeleteMapping("/{ocorrenciaId}")
    @ResponseBody
    public String deletar(@PathVariable("ocorrenciaId") Long ocorrenciaId) {
        String result = ocorrenciaFacade.delete(ocorrenciaId);
        if ("Ocorrência não encontrada".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ocorrência não encontrada");
        }
        return result;
    }
}
