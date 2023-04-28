package com.winner.controller;

import com.winner.exception.WinnerException;
import com.winner.service.WinnerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winner")
public class WinnerController {


    @Autowired
    private WinnerService wServcie;



    @GetMapping("/check/{id}")
    public ResponseEntity<String> checkNumber(@PathVariable int id) {

        boolean flag = wServcie.checkNumber(id);

        if(flag) return new ResponseEntity<String>("Its exist in the database" , HttpStatus.OK);

        else return new ResponseEntity<String>("Its not exist in the database" , HttpStatus.OK);

    }

    @PostMapping("/setwinner/{id}")
    public ResponseEntity<String> winnerId( @PathVariable int id) {

           String message =  wServcie.winnerId(id);

           return new ResponseEntity<String>(message , HttpStatus.OK);
    }

    @GetMapping("/getwinner")
    public ResponseEntity<Integer> getWinnerId() {

       Integer id =   wServcie.getWinnerId();

       return new ResponseEntity<Integer>( id , HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity <String> registerLottery( @RequestBody List<Integer> lottery) {

           String message =  wServcie.registerLottery(lottery);

           return new ResponseEntity<String>( message , HttpStatus.OK);
    }
}
