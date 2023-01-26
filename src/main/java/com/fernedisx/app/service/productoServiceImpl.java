package com.fernedisx.app.service;

import com.fernedisx.app.model.Producto;
import com.fernedisx.app.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class productoServiceImpl extends GenericServiceImpl<Producto, Integer> implements productoService{

        @Autowired
        private productoRepository productoRepository;

        @Override
        public CrudRepository<Producto, Integer> getDao() {
            return productoRepository;
        }
}
