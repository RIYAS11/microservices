package com.winner.service;

import com.winner.exception.WinnerException;

import java.util.List;

public interface WinnerService {

            public boolean checkNumber(int id) throws WinnerException;

            public String winnerId( int id) throws WinnerException;

            public int getWinnerId() throws WinnerException;

            public String registerLottery( List<Integer> lottery) throws WinnerException;
}
