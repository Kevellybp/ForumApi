package com.api.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.forum.DTO.TopicoForm;
import com.api.forum.model.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	Object save(Optional<Topico> topico);

}
