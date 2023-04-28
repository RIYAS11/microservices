package com.calculation.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CalculationService {

        public String lotteryToWinner(List<Integer> lottery);
}
