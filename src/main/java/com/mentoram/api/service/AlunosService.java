package com.mentoram.api.service;

import com.mentoram.api.dominio.entity.AlunoEntity;
import com.mentoram.api.dominio.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {
    @Autowired
    private AlunoRepository repository;

    public void cadAluno(AlunoEntity alunoEntity) {
        repository.save(alunoEntity);
    }

    public List<AlunoEntity> listAlunoIdade(int idade) {
        return repository.findAlunoEntitiesByIdade(idade);
    }

    public List<AlunoEntity> listAlunoNomes(String nome) {
        return repository.findAlunoEntitiesByNome(nome);
    }

    public Optional<AlunoEntity> buscaAlunoId(Long id) {
        Optional<AlunoEntity> byId = repository.findById(id);
        return byId;
    }

    public AlunoEntity updateAluno(Long id, AlunoEntity alunoEtity) {
        AlunoEntity byId = repository.getById(id);
        byId.setIdade(alunoEtity.getIdade());
        byId.setNome(alunoEtity.getNome());
        AlunoEntity alunoSave = repository.save(byId);
        return alunoSave;
    }

    public void deletaAlunoId(Long id) {
        repository.deleteById(id);
    }

}
