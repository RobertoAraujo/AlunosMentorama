package com.mentoram.api.dominio.repository;

import com.mentoram.api.dominio.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    Optional<AlunoEntity> findById(Long id);
    List<AlunoEntity> findAlunoEntitiesByIdade(int idade);

    List<AlunoEntity> findAlunoEntitiesByNome(String nome);

}
