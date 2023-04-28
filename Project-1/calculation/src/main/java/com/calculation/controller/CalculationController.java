package com.calculation.controller;

import com.calculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

    @Autowired
    private CalculationService cService;

    @PostMapping("/register")
    public ResponseEntity<String>  registerLotteryIds(@RequestBody List<Integer> lotteries){

        System.out.println("ok");
        String message =  cService.lotteryToWinner(lotteries);

        System.out.println(lotteries);

        return new ResponseEntity<String>(message , HttpStatus.ACCEPTED);
    }

}
