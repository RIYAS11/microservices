package com.calculation.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {


    @Override
    public String lotteryToWinner(List<Integer> lottery) {

        return "All lottery Id is append to Winner";

    }
}
