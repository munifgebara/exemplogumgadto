package br.com.gumgademo.exemplo.domain.model;

import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {})
public interface PessoaMapper extends EntityMapper <PessoaDTO, Pessoa> {

    @Mapping(source = "pai.id", target = "pai")
    PessoaDTO toDto(Pessoa pessoa); 

    @Mapping(source = "pai", target = "pai")
    Pessoa toEntity(PessoaDTO pessoaDTO); 
    default Pessoa fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pessoa pessoa = new Pessoa(id);
        return pessoa;
    }
}
