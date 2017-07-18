package br.com.gumgademo.exemplo.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.gumgademo.exemplo.domain.model.Pessoa;

public interface PessoaRepository extends GumgaCrudRepository<Pessoa, Long> {}