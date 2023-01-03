package com.mentoram.api.controller;

import com.mentoram.api.dominio.entity.AlunoEntity;
import com.mentoram.api.service.AlunosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoController.class);

    @Autowired
    private AlunosService service;

    @PostMapping(value = "/cadastro")
    public void cadAluno(@RequestBody AlunoEntity alunoEntity) {
        LOGGER.info("Cadastrado com Sucesso!");
        service.cadAluno(alunoEntity);
    }

    @GetMapping(value = "/idade/{idade}")
    public List<AlunoEntity> buscarPorIdade(@PathVariable("idade") int idade) {
        LOGGER.info("Idade Buscada é " + idade);
        List<AlunoEntity> alunoEntities = service.listAlunoIdade(idade);
        return alunoEntities;
    }

    @GetMapping(value = "/nome/{nome}")
    public List<AlunoEntity> buscarPorNome(@PathVariable String nome) {
        List<AlunoEntity> alunoEntities = service.listAlunoNomes(nome);
        LOGGER.info("O Nome buscado é " + nome);
        return alunoEntities;
    }

    @PutMapping(value = "/update/{id}")
    public AlunoEntity buscarPorNome(@PathVariable("id") Long id, @RequestBody AlunoEntity alunoEntity) {
        AlunoEntity alunoEntities = service.updateAluno(id, alunoEntity);
        LOGGER.info("O id foi atualizado com sucesso!" + id);
        return alunoEntities;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletaAluno(@PathVariable Long id) {
        LOGGER.info("O Nome id foi deletado com sucesso!" + id);
        service.deletaAlunoId(id);
    }
}
