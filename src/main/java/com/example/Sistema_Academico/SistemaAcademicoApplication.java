package com.example.Sistema_Academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Sistema_Academico.aluno", "com.example.Sistema_Academico.professor", "com.example.Sistema_Academico.registro_de_aula"})
public class SistemaAcademicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaAcademicoApplication.class, args);
    }
}
