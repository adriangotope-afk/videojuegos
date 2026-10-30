package com.biblioteca.videojuegos.service;

import com.biblioteca.videojuegos.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Cliente registrar(Cliente cliente) {
        cliente.setId(contador.getAndIncrement());
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente no encontrado: " + id));
    }
}