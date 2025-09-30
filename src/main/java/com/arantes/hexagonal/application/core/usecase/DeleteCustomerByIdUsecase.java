package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.ports.in.FindCustomerByIdIutputPort;
import com.arantes.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCustomerByIdUsecase implements DeleteCustomerByIdOutPutPort {

    private final FindCustomerByIdIutputPort findCustomerByIdIutputPort;

    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;


    @Override
    public void delete(String id) {
        findCustomerByIdIutputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);
    }
}
