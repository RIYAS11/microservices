package com.calculation.service;

import com.calculation.external.Winnerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {


    @Autowired
    private Winnerservice ser;

    @Override
    public String lotteryToWinner(List<Integer> lottery) {

       ResponseEntity<String> message =  ser.registerLottery(lottery);


       return message.getBody();

    }
}
