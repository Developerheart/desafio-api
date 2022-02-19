package io.heart.developer.gastomicroservice.mapper;

import io.heart.developer.gastomicroservice.dto.request.GastoRequest;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;

import java.io.Serializable;

public class GastoMapper implements Serializable {

    public static GastoEntity toEntity(GastoRequest gastoRequest) {
        return merge(gastoRequest, new GastoEntity());
    }

    private static GastoEntity merge(GastoRequest gastoRequest, GastoEntity gastoEntity) {
        gastoEntity.setValor(gastoRequest.getValor());
        gastoEntity.setDescricao(gastoRequest.getDescricao());
        gastoEntity.setDataHora(gastoRequest.getDataHora());
        gastoEntity.setTag(gastoRequest.getTag());
        return gastoEntity;
    }
}
