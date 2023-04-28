package com.calculation.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "WINNER-SERVICE")
public interface Winnerservice {

    @PostMapping("/winner/register")
     public ResponseEntity<String> registerLottery(@RequestBody List<Integer> lottery) ;
}
