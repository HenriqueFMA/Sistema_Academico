package com.example.Sistema_Academico.aluno.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Sistema_Academico.aluno.dto.AlunoDTO;
import com.example.Sistema_Academico.aluno.facade.AlunoFacade;

@RestController("alunosAPI")
@RequestMapping(value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlunosAPI {

    @Autowired
    private AlunoFacade alunosFacade;

    // Criar um novo aluno
    @PostMapping
    @ResponseBody
    public AlunoDTO criar(@RequestBody AlunoDTO alunoDTO) {
        return alunosFacade.criar(alunoDTO);
    }

    // Atualizar um aluno existente
    @PutMapping("/{alunoId}")
    @ResponseBody
    public AlunoDTO atualizar(@PathVariable("alunoId") Long alunoId, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO atualizado = alunosFacade.atualizar(alunoDTO, alunoId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return atualizado;
    }

    // Obter todos os alunos
    @GetMapping
    @ResponseBody
    public List<AlunoDTO> getAll() {
        return alunosFacade.getAll();
    }

    // Obter um aluno pelo ID
    @GetMapping("/{alunoId}")
    @ResponseBody
    public AlunoDTO getById(@PathVariable("alunoId") Long alunoId) {
        AlunoDTO aluno = alunosFacade.getById(alunoId);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return aluno;
    }

    // Obter alunos pelo nome
    @GetMapping("/nome/{nome}")
    @ResponseBody
    public List<AlunoDTO> getByNome(@PathVariable("nome") String nome) {
        List<AlunoDTO> alunos = alunosFacade.getByName(nome);
        if (alunos == null || alunos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o nome: " + nome);
        }
        return alunos;
    }

    // Deletar um aluno pelo ID
    @DeleteMapping("/{alunoId}")
    @ResponseBody
    public String deletar(@PathVariable("alunoId") Long alunoId) {
        String result = alunosFacade.delete(alunoId);
        if ("Aluno não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return result;
    }
}
