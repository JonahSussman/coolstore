package com.redhat.coolstore.service;

import java.util.logging.Logger;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Emitter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.coolstore.model.ShoppingCart;
import com.redhat.coolstore.utils.Transformers;

@ApplicationScoped
public class ShoppingCartOrderProcessor  {

    @Inject
    Logger log;

    @Inject
    @ConfigProperty(name = "quarkus.jms.topic.orders")
    private Emitter<String> ordersEmitter;

    @Resource(name = "quarkus.jms.topic.orders")
    private String ordersTopic;

    public void  process(ShoppingCart cart) {
        log.info("Sending order from processor: ");
        ordersEmitter.emit(Transformers.shoppingCartToJson(cart));
    }

}
