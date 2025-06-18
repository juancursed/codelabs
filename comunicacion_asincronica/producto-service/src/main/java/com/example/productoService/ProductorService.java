package com.example.productoService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductorService {

    private final AmqpTemplate customRabbitTemplate;

    public ProductorService(AmqpTemplate customRabbitTemplate) {
        this.customRabbitTemplate = customRabbitTemplate;
    }

    public void enviarListaProductos(List<com.example.productoService.ProductoDTO> productos) {
        // Enviamos la lista de productos en formato JSON
        customRabbitTemplate.convertAndSend(
                com.example.productoService.RabbitMQConfig.EXCHANGE_NAME,
                com.example.productoService.RabbitMQConfig.ROUTING_KEY,
                productos
        );
        System.out.println("Lista de productos enviada con éxito en formato JSON.");
    }
}