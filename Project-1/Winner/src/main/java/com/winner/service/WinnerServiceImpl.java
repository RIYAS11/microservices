package com.winner.service;

import com.winner.data.InformationStored;
import com.winner.exception.WinnerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerServiceImpl implements WinnerService{




    private InformationStored  data = new InformationStored();

    @Override
    public boolean checkNumber(int id) throws WinnerException {


            Integer value =   data.getTicket().get(id); //o(1)

           if(value == null) throw new WinnerException("No id is there in the database");

           return  true;
    }

    @Override
    public String winnerId(int id) throws WinnerException {


            Integer value =   data.getTicket().get(id);

            if(value == null) throw new WinnerException("No id is there in the database");

            data.setWinnerId(id);

            return "Winner set Successfully"+" "+id;



    }

    @Override
    public int getWinnerId() throws WinnerException {

        if(data.getWinnerId() == null) throw new WinnerException("No winner  is there in the database");


        return data.getWinnerId();

    }

    @Override
    public String registerLottery(List<Integer> lottery) throws WinnerException {

        lottery.forEach(el ->{

            data.getTicket().put(el, 1);
        });

        return "Lottery Id are registered Successfully ";
    }
}
