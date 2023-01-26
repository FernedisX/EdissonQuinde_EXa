package com.fernedisx.app.repository;

import com.fernedisx.app.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<Producto, Integer> {

}
