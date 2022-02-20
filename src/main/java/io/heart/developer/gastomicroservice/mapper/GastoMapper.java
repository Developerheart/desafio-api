package io.heart.developer.gastomicroservice.mapper;

import io.heart.developer.gastomicroservice.dto.request.GastoRequest;
import io.heart.developer.gastomicroservice.dto.response.GastoResponse;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;

import java.io.Serializable;
import java.util.List;

public class GastoMapper implements Serializable {

    public static GastoEntity toEntity(GastoRequest gastoRequest) {
        return merge(gastoRequest, new GastoEntity());
    }

    public static GastoResponse toResponse(GastoEntity gastoEntity){
        return merge(gastoEntity, new GastoResponse());
    }

    private static GastoResponse merge(GastoEntity gastoEntity, GastoResponse gastoResponse) {
        gastoResponse.setValor(gastoEntity.getValor());
        gastoResponse.setDataHora(gastoEntity.getDataHora());
        gastoResponse.setDescricao(gastoEntity.getDescricao());
        gastoResponse.setTag(gastoEntity.getTag());
        return gastoResponse;
    }

    private static GastoEntity merge(GastoRequest gastoRequest, GastoEntity gastoEntity) {
        gastoEntity.setValor(gastoRequest.getValor());
        gastoEntity.setDescricao(gastoRequest.getDescricao());
        gastoEntity.setDataHora(gastoRequest.getDataHora());
        gastoEntity.setTag(gastoRequest.getTag());
        return gastoEntity;
    }

    public static GastoEntity toEntity(GastoRequest gastoRequest, PessoaEntity pessoaEntity) {
        GastoEntity gastoEntity = merge(gastoRequest, new GastoEntity());
        gastoEntity.setPessoaEntity(pessoaEntity);
        return gastoEntity;
    }

    public static List<GastoResponse> toResponseList(List<GastoEntity> gastoEntityList){
        return gastoEntityList.stream().map(gastoEntity -> merge(gastoEntity, new GastoResponse())).toList();
    }
}
