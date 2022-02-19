package io.heart.developer.gastomicroservice.mapper;

import io.heart.developer.gastomicroservice.dto.request.PessoaRequest;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;

public class PessoaMapper {

    public static PessoaEntity toEntity(PessoaRequest request) {
        return merge(request, new PessoaEntity());
    }

    private static PessoaEntity merge(PessoaRequest request, PessoaEntity entity) {
        entity.setSaldo(request.getSaldo());
        entity.setNome(request.getNome());
        return entity;
    }
}
