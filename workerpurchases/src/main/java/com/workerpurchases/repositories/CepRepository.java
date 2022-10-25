package com.workerpurchases.repositories;

import com.workerpurchases.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${viacep}")
public interface CepRepository {

    @GetMapping("/{cep}/json/")
    Address findByCep(@PathVariable("cep") String cep);
}
