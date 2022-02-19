package io.heart.developer.gastomicroservice.repository.gasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<GastoEntity, Integer> {

}
