package io.heart.developer.gastomicroservice.service;

import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class PessoaService implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity salvar(PessoaEntity entidade) {
        return pessoaRepository.saveAndFlush(entidade);
    }

    public PessoaEntity buscarPorId(Integer id){
        Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow();
    }

}
