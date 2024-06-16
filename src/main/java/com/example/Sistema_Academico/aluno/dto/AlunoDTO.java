package com.example.Sistema_Academico.aluno.dto;

import java.time.LocalDate;

public class AlunoDTO {

    // Dados do aluno
    private Long id;

    private String nomeAluno;
    private String cpfAluno;
    private LocalDate dataNascimentoAluno;
    private String rgAluno;
    private String serie;
    private String turno;
    private String nisAluno;
    private String fotoAluno; // Representando a foto como uma URL ou um identificador para simplificar

    // Dados da mãe
    private String nomeMae;
    private String cpfMae;
    private String rgMae;
    private LocalDate dataNascimentoMae;

    // Dados do pai
    private String nomePai;
    private String cpfPai;
    private String rgPai;
    private LocalDate dataNascimentoPai;

    // NIS do responsável
    private String nisResponsavel;

    // Endereço
    private String rua;
    private String bairro;
    private String complemento;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public LocalDate getDataNascimentoAluno() {
        return dataNascimentoAluno;
    }

    public void setDataNascimentoAluno(LocalDate dataNascimentoAluno) {
        this.dataNascimentoAluno = dataNascimentoAluno;
    }

    public String getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNisAluno() {
        return nisAluno;
    }

    public void setNisAluno(String nisAluno) {
        this.nisAluno = nisAluno;
    }

    public String getFotoAluno() {
        return fotoAluno;
    }

    public void setFotoAluno(String fotoAluno) {
        this.fotoAluno = fotoAluno;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpfMae() {
        return cpfMae;
    }

    public void setCpfMae(String cpfMae) {
        this.cpfMae = cpfMae;
    }

    public String getRgMae() {
        return rgMae;
    }

    public void setRgMae(String rgMae) {
        this.rgMae = rgMae;
    }

    public LocalDate getDataNascimentoMae() {
        return dataNascimentoMae;
    }

    public void setDataNascimentoMae(LocalDate dataNascimentoMae) {
        this.dataNascimentoMae = dataNascimentoMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getCpfPai() {
        return cpfPai;
    }

    public void setCpfPai(String cpfPai) {
        this.cpfPai = cpfPai;
    }

    public String getRgPai() {
        return rgPai;
    }

    public void setRgPai(String rgPai) {
        this.rgPai = rgPai;
    }

    public LocalDate getDataNascimentoPai() {
        return dataNascimentoPai;
    }

    public void setDataNascimentoPai(LocalDate dataNascimentoPai) {
        this.dataNascimentoPai = dataNascimentoPai;
    }

    public String getNisResponsavel() {
        return nisResponsavel;
    }

    public void setNisResponsavel(String nisResponsavel) {
        this.nisResponsavel = nisResponsavel;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
