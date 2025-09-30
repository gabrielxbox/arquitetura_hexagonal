package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.application.ports.out.SandCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SandCpfForValidationAdapter implements SandCpfForValidationOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sand(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
