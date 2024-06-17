package com.example.Sistema_Academico.ocorrencia.api;

import com.example.Sistema_Academico.ocorrencia.dto.OcorrenciaDTO;
import com.example.Sistema_Academico.ocorrencia.facade.OcorrenciaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ocorrencias", produces = MediaType.APPLICATION_JSON_VALUE)
public class OcorrenciaAPI {

    @Autowired
    private OcorrenciaFacade ocorrenciaFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO criar(@RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ocorrenciaFacade.criar(ocorrenciaDTO);
    }

    @PutMapping("/{ocorrenciaId}")
    public OcorrenciaDTO atualizar(@PathVariable Long ocorrenciaId, @RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ocorrenciaFacade.atualizar(ocorrenciaDTO, ocorrenciaId);
    }

    @GetMapping
    public List<OcorrenciaDTO> getAll() {
        return ocorrenciaFacade.getAll();
    }

    @GetMapping("/{ocorrenciaId}")
    public OcorrenciaDTO getById(@PathVariable Long ocorrenciaId) {
        return ocorrenciaFacade.getById(ocorrenciaId);
    }

    @DeleteMapping("/{ocorrenciaId}")
    public void delete(@PathVariable Long ocorrenciaId) {
        ocorrenciaFacade.delete(ocorrenciaId);
    }
}
