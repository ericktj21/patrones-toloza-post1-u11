package com.universidad.pedidos.service;

import com.universidad.pedidos.domain.DatosCliente;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    public void notificarPedido(DatosCliente cliente, boolean urgente) {
        System.out.println("Notificando a: " + cliente.getEmail());
        System.out.println("Pedido urgente: " + urgente);
    }
}
