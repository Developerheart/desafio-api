package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.constantes.Tag;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;
import io.heart.developer.gastomicroservice.service.GastoService;
import io.heart.developer.gastomicroservice.service.PessoaService;
import org.apache.coyote.Response;
import org.hibernate.type.SpecialOneToOneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/gasto")
public class GastoController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private GastoService gastoService;

    @PostMapping("/{id}")
    public ResponseEntity<Integer> criarGasto(@PathVariable Integer id) {
        PessoaEntity pessoaEntity = pessoaService.buscarPorId(id);
        GastoEntity gasto = new GastoEntity();
        gasto.setPessoaEntity(pessoaEntity);
        gasto.setDataHora(LocalDateTime.now());
        gasto.setTag(Tag.COMIDA);
        gasto.setValor(new BigDecimal("300.00"));
        gastoService.salvarGasto(gasto);
        return ResponseEntity.ok(gastoService.salvarGasto(gasto).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GastoEntity>> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(gastoService.buscarPorID(id));
    }


}
