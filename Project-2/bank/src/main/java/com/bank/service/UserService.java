package com.bank.service;

import com.bank.exception.AccountException;
import com.bank.exception.UserException;
import com.bank.model.User;

public interface UserService {

    public User registerUser(User user);

    public User credit(int userid , long amount) throws UserException , AccountException;

    public User debit(int userid , long amount) throws UserException , AccountException;
}
