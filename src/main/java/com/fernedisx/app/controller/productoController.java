package com.fernedisx.app.controller;

import com.fernedisx.app.model.Producto;
import com.fernedisx.app.model.ValProducto;
import com.fernedisx.app.service.productoService;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Valid;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productoController {
    @Autowired
    productoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@Valid @RequestBody ValProducto pnew){
        Producto newp = new Producto();

        newp.setId_producto(pnew.getId_producto());
        newp.setDescripcion(pnew.getDescripcion());
        newp.setCodigo(pnew.getCodigo());
        newp.setCantidad(pnew.getCantidad());
        newp.setPrecio(pnew.getPrecio());

        return new ResponseEntity<>(productoService.save(newp), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarproducto/{id_producto}")
    public void eliminar(@PathVariable("id_producto") Integer id_producto){
        productoService.delete(id_producto);
    }

    @PutMapping("/actualizarproducto/{id_producto}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto p,@PathVariable Integer id_producto){
        Producto producton = productoService.findById(id_producto);
        producton.setCodigo(p.getCodigo());
        producton.setDescripcion(p.getDescripcion());
        producton.setCantidad(p.getCantidad());
        producton.setPrecio(p.getPrecio());
        return new ResponseEntity<>(productoService.save(producton), HttpStatus.CREATED);
    }

    @GetMapping("/buscarproducto/{id_producto}")
    public ResponseEntity<Producto> buscar(@PathVariable("id_producto") Integer id_producto) {
        return new ResponseEntity<>(productoService.findById(id_producto), HttpStatus.OK);
    }

}

