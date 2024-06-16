package com.example.Sistema_Academico.registro_de_aula.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AulaDTO {

    private Long id;
    private LocalDate dataAula;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private String localAula;
    private String nomeProfessor;
    private String disciplina;
    private String topicos;
    private String materiais;
    private List<String> fileLinks;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAula() {
        return dataAula;
    }

    public void setDataAula(LocalDate dataAula) {
        this.dataAula = dataAula;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getLocalAula() {
        return localAula;
    }

    public void setLocalAula(String localAula) {
        this.localAula = localAula;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTopicos() {
        return topicos;
    }

    public void setTopicos(String topicos) {
        this.topicos = topicos;
    }

    public String getMateriais() {
        return materiais;
    }

    public void setMateriais(String materiais) {
        this.materiais = materiais;
    }

    public List<String> getFileLinks() {
        return fileLinks;
    }

    public void setFileLinks(List<String> fileLinks) {
        this.fileLinks = fileLinks;
    }
}
