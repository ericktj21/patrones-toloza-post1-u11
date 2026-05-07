package com.universidad.pedidos.service;

import com.universidad.pedidos.domain.CodigoDescuento;
import com.universidad.pedidos.domain.DatosCliente;
import com.universidad.pedidos.domain.LineaPedido;
import com.universidad.pedidos.domain.Pedido;
import com.universidad.pedidos.repository.PedidoRepository;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository repo;
    private final NotificacionService notificacion;

    public PedidoService(PedidoRepository repo, NotificacionService notificacion) {
        this.repo = repo;
        this.notificacion = notificacion;
    }

    public String procesarPedido(DatosCliente cliente,
            LineaPedido[] lineas, String metodoPago,
            boolean esUrgente, CodigoDescuento descuento) {
        double total = calcularTotal(lineas);
        double totalConDescuento = aplicarDescuento(total, descuento);
        notificarCliente(cliente, esUrgente);
        return persistirPedido(cliente, totalConDescuento);
    }

    private double calcularTotal(LineaPedido[] lineas) {
        return Arrays.stream(lineas)
                .mapToDouble(l -> l.getPrecioUnitario() * l.getCantidad())
                .sum();
    }

    private double aplicarDescuento(double total, CodigoDescuento descuento) {
        return descuento != null ? total * (1 - descuento.getPorcentaje()) : total;
    }

    private void notificarCliente(DatosCliente cliente, boolean urgente) {
        notificacion.notificarPedido(cliente, urgente);
    }

    private String persistirPedido(DatosCliente cliente, double total) {
        Pedido pedido = new Pedido(null, cliente.getNombre(), total);
        return "OK_" + repo.save(pedido).getId();
    }
}
