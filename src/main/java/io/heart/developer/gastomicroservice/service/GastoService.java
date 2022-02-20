package io.heart.developer.gastomicroservice.service;

import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.gasto.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class GastoService implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private transient GastoRepository gastoRepository;

    public GastoEntity salvarGasto(GastoEntity gasto) {
        return gastoRepository.saveAndFlush(gasto);
    }

    public List<GastoEntity> buscarGastosPorPessoa(Integer id){
        return gastoRepository.findByPessoaEntityId(id);
    }

    public GastoEntity buscarGastoPorID(Integer id){
        Optional<GastoEntity> gasto = gastoRepository.findById(id);
        return gasto.orElseThrow();
    }
}
