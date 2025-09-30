package com.arantes.hexagonal.adapters.in.controller;

import com.arantes.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.arantes.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arantes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arantes.hexagonal.application.ports.in.DeleteCustomerByIdInputPutPort;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdIutputPort;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;

    private final FindCustomerByIdIutputPort findCustomerByIdIutputPort;

    private final UpdateCustomerInputPort updateCustomerInputPort;

    private final DeleteCustomerByIdInputPutPort deleteCustomerByIdInputPutPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        insertCustomerInputPort.insert(CustomerRequestMapper.INSTANCE.toCustomer(request), request.getZipCode());
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer  = CustomerRequestMapper.INSTANCE.toCustomerResponse(findCustomerByIdIutputPort.find(id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest request) {
       var customer = CustomerRequestMapper.INSTANCE.toCustomer(request);
       customer.setId(id);
       updateCustomerInputPort.update(customer, request.getZipCode());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdInputPutPort.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
