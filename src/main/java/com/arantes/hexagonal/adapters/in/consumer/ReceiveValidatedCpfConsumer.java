package com.arantes.hexagonal.adapters.in.consumer;

import com.arantes.hexagonal.adapters.in.consumer.mapper.CustomerMenssageMapper;
import com.arantes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public  void receive(CustomerMessage customerMessage) {
        updateCustomerInputPort.update(CustomerMenssageMapper.INSTANCE.toCustomer(customerMessage), customerMessage.getZipCode());
    }
}
