package io.heart.developer.gastomicroservice.service;

import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.gasto.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class GastoService implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private GastoRepository gastoRepository;

    public GastoEntity salvarGasto(GastoEntity gasto) {
        return gastoRepository.saveAndFlush(gasto);
    }

    public List<GastoEntity> buscarPorID(Integer id){
        return gastoRepository.findByPessoaEntityId(id);
    }
}
