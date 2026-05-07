package com.universidad.pedidos.repository;

import com.universidad.pedidos.domain.Pedido;
import com.universidad.pedidos.domain.Producto;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository {
    private final Map<Long, Pedido> pedidos = new ConcurrentHashMap<>();
    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Producto findProductoById(Long id) {
        return productos.get(id);
    }

    public Pedido save(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido.setId(seq.getAndIncrement());
        }
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }
}
