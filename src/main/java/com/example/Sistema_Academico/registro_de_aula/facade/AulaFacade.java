package com.example.Sistema_Academico.registro_de_aula.facade;

import com.example.Sistema_Academico.registro_de_aula.dto.AulaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AulaFacade {

    private List<AulaDTO> aulas = new ArrayList<>();
    private long idCounter = 1;

    // Cria uma nova aula
    public AulaDTO criar(AulaDTO aulaDTO) {
        aulaDTO.setId(idCounter++);
        aulas.add(aulaDTO);
        return aulaDTO;
    }

    // Atualiza uma aula existente
    public AulaDTO atualizar(AulaDTO aulaDTO, Long aulaId) {
        Optional<AulaDTO> optionalAula = aulas.stream()
                .filter(a -> a.getId().equals(aulaId))
                .findFirst();

        if (optionalAula.isPresent()) {
            AulaDTO aulaExistente = optionalAula.get();
            aulaExistente.setDataAula(aulaDTO.getDataAula());
            aulaExistente.setHoraInicio(aulaDTO.getHoraInicio());
            aulaExistente.setHoraTermino(aulaDTO.getHoraTermino());
            aulaExistente.setLocalAula(aulaDTO.getLocalAula());
            aulaExistente.setNomeProfessor(aulaDTO.getNomeProfessor());
            aulaExistente.setDisciplina(aulaDTO.getDisciplina());
            aulaExistente.setTopicos(aulaDTO.getTopicos());
            aulaExistente.setMateriais(aulaDTO.getMateriais());
            aulaExistente.setFileLinks(aulaDTO.getFileLinks());
            return aulaExistente;
        } else {
            return null; // Aula não encontrada
        }
    }

    // Retorna todas as aulas
    public List<AulaDTO> getAll() {
        return new ArrayList<>(aulas);
    }

    // Busca uma aula pelo ID
    public AulaDTO getById(Long aulaId) {
        return aulas.stream()
                .filter(a -> a.getId().equals(aulaId))
                .findFirst()
                .orElse(null);
    }

    // Deleta uma aula pelo ID
    public String delete(Long aulaId) {
        Optional<AulaDTO> optionalAula = aulas.stream()
                .filter(a -> a.getId().equals(aulaId))
                .findFirst();

        if (optionalAula.isPresent()) {
            aulas.remove(optionalAula.get());
            return "Aula deletada com sucesso";
        } else {
            return "Aula não encontrada";
        }
    }
}
