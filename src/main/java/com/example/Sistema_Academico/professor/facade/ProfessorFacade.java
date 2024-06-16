package com.example.Sistema_Academico.professor.facade;

import com.example.Sistema_Academico.professor.dto.ProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorFacade {

    private List<ProfessorDTO> professores = new ArrayList<>();
    private long idCounter = 1;

    // Cria um novo professor
    public ProfessorDTO criar(ProfessorDTO professorDTO) {
        professorDTO.setId(idCounter++);
        professores.add(professorDTO);
        return professorDTO;
    }

    // Atualiza um professor existente
    public ProfessorDTO atualizar(ProfessorDTO professorDTO, Long professorId) {
        Optional<ProfessorDTO> optionalProfessor = professores.stream()
                .filter(p -> p.getId().equals(professorId))
                .findFirst();

        if (optionalProfessor.isPresent()) {
            ProfessorDTO professorExistente = optionalProfessor.get();
            professorExistente.setNome(professorDTO.getNome());
            professorExistente.setCpf(professorDTO.getCpf());
            professorExistente.setDataNascimento(professorDTO.getDataNascimento());
            professorExistente.setRg(professorDTO.getRg());
            professorExistente.setSerie(professorDTO.getSerie());
            professorExistente.setTurno(professorDTO.getTurno());
            professorExistente.setNis(professorDTO.getNis());
            professorExistente.setFoto(professorDTO.getFoto());

            professorExistente.setNomeMae(professorDTO.getNomeMae());
            professorExistente.setDataNascimentoMae(professorDTO.getDataNascimentoMae());
            professorExistente.setNomePai(professorDTO.getNomePai());

            professorExistente.setRua(professorDTO.getRua());
            professorExistente.setBairro(professorDTO.getBairro());
            professorExistente.setComplemento(professorDTO.getComplemento());
            return professorExistente;
        } else {
            return null; // Professor não encontrado
        }
    }

    // Retorna todos os professores
    public List<ProfessorDTO> getAll() {
        return new ArrayList<>(professores);
    }

    // Busca um professor pelo ID
    public ProfessorDTO getById(Long professorId) {
        return professores.stream()
                .filter(p -> p.getId().equals(professorId))
                .findFirst()
                .orElse(null);
    }

    // Deleta um professor pelo ID
    public String delete(Long professorId) {
        Optional<ProfessorDTO> optionalProfessor = professores.stream()
                .filter(p -> p.getId().equals(professorId))
                .findFirst();

        if (optionalProfessor.isPresent()) {
            professores.remove(optionalProfessor.get());
            return "Professor deletado com sucesso";
        } else {
            return "Professor não encontrado";
        }
    }
}
