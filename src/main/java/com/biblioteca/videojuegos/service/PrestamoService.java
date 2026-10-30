package com.biblioteca.videojuegos.service;

import com.biblioteca.videojuegos.model.AlquilerRequest;
import com.biblioteca.videojuegos.model.Cliente;
import com.biblioteca.videojuegos.model.ContenidoDigital;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class PrestamoService {
    private final JuegoService juegoService;
    private final ClienteService clienteService;

    public PrestamoService(JuegoService juegoService, ClienteService clienteService) {
        this.juegoService = juegoService;
        this.clienteService = clienteService;
    }

    public Map<String, Object> alquilar(AlquilerRequest request) {
        if (request.dias() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Los días deben ser mayores a 0");
        }

        Cliente cliente = clienteService.buscarPorId(request.clienteId());
        ContenidoDigital juego = juegoService.buscarPorId(request.juegoId());

        // Validación 1: el juego está disponible
        if (!juego.isDisponible()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El juego no está disponible");
        }

        // Validación 2: el cliente no supera 3 juegos
        if (!cliente.puedeAlquilar()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El cliente ya tiene 3 juegos alquilados");
        }

        cliente.agregarJuego(juego);
        juego.setDisponible(false);

        double costoTotal = juego.calcularPrecioRenta(request.dias()); // polimorfismo

        return Map.of(
                "mensaje", "Préstamo confirmado",
                "cliente", cliente.getNombre(),
                "juego", juego.getTitulo(),
                "dias", request.dias(),
                "costoTotal", costoTotal
        );
    }
}