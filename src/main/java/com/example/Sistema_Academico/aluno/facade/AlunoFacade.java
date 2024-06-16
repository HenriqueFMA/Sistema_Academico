package com.example.Sistema_Academico.aluno.facade;

import com.example.Sistema_Academico.aluno.dto.AlunoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoFacade {

    private List<AlunoDTO> alunos = new ArrayList<>();
    private long idCounter = 1;

    // Cria um novo aluno
    public AlunoDTO criar(AlunoDTO alunoDTO) {
        validateAlunoDTO(alunoDTO); // Validar dados antes de criar
        alunoDTO.setId(idCounter++);
        alunos.add(alunoDTO);
        return alunoDTO;
    }

    // Atualiza um aluno existente
    public AlunoDTO atualizar(AlunoDTO alunoDTO, Long alunoId) {
        validateAlunoDTO(alunoDTO); // Validar dados antes de atualizar
        Optional<AlunoDTO> optionalAluno = alunos.stream()
                .filter(a -> a.getId().equals(alunoId))
                .findFirst();

        if (optionalAluno.isPresent()) {
            AlunoDTO alunoExistente = optionalAluno.get();
            updateAlunoFromDTO(alunoExistente, alunoDTO); // Atualizar dados do aluno existente
            return alunoExistente;
        } else {
            return null; // Aluno não encontrado
        }
    }

    // Retorna todos os alunos
    public List<AlunoDTO> getAll() {
        return new ArrayList<>(alunos); // Retornar cópia para evitar modificações indesejadas
    }

    // Busca alunos pelo nome
    public List<AlunoDTO> getByName(String nome) {
        return alunos.stream()
                .filter(aluno -> aluno.getNomeAluno().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Busca aluno pelo ID
    public AlunoDTO getById(Long alunoId) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(alunoId))
                .findFirst()
                .orElse(null); // Retorna null se não encontrar o aluno
    }

    // Deleta um aluno pelo ID
    public String delete(Long alunoId) {
        Optional<AlunoDTO> optionalAluno = alunos.stream()
                .filter(a -> a.getId().equals(alunoId))
                .findFirst();

        if (optionalAluno.isPresent()) {
            alunos.remove(optionalAluno.get());
            return "Aluno deletado com sucesso";
        } else {
            return "Aluno não encontrado";
        }
    }

    // Método privado para validar dados do aluno
    private void validateAlunoDTO(AlunoDTO alunoDTO) {
        // Implementar validações necessárias, por exemplo:
        // if (alunoDTO.getNomeAluno() == null || alunoDTO.getNomeAluno().isEmpty()) {
        //     throw new IllegalArgumentException("Nome do aluno não pode ser nulo ou vazio");
        // }
    }

    // Método privado para atualizar dados do aluno existente com base no DTO recebido
    private void updateAlunoFromDTO(AlunoDTO alunoExistente, AlunoDTO alunoDTO) {
        alunoExistente.setNomeAluno(alunoDTO.getNomeAluno());
        alunoExistente.setCpfAluno(alunoDTO.getCpfAluno());
        alunoExistente.setDataNascimentoAluno(alunoDTO.getDataNascimentoAluno());
        alunoExistente.setRgAluno(alunoDTO.getRgAluno());
        alunoExistente.setSerie(alunoDTO.getSerie());
        alunoExistente.setTurno(alunoDTO.getTurno());
        alunoExistente.setNisAluno(alunoDTO.getNisAluno());
        alunoExistente.setFotoAluno(alunoDTO.getFotoAluno());
        alunoExistente.setNomeMae(alunoDTO.getNomeMae());
        alunoExistente.setCpfMae(alunoDTO.getCpfMae());
        alunoExistente.setRgMae(alunoDTO.getRgMae());
        alunoExistente.setDataNascimentoMae(alunoDTO.getDataNascimentoMae());
        alunoExistente.setNomePai(alunoDTO.getNomePai());
        alunoExistente.setCpfPai(alunoDTO.getCpfPai());
        alunoExistente.setRgPai(alunoDTO.getRgPai());
        alunoExistente.setDataNascimentoPai(alunoDTO.getDataNascimentoPai());
        alunoExistente.setNisResponsavel(alunoDTO.getNisResponsavel());
        alunoExistente.setRua(alunoDTO.getRua());
        alunoExistente.setBairro(alunoDTO.getBairro());
        alunoExistente.setComplemento(alunoDTO.getComplemento());
    }
}
