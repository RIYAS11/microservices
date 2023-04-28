package com.bank.exception;

public class AccountException  extends RuntimeException{

    public AccountException(){

    }


    public AccountException(String msg){

        super(msg);
    }

}
