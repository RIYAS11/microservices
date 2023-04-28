package com.bank.service;

import com.bank.exception.AccountException;
import com.bank.exception.UserException;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.repository.AccountDao;
import com.bank.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
    private AccountDao aDao;

    @Autowired
    private UserDao uDao;

    @Override
    public User registerUser(User user) {

          return uDao.save(user);

          // when we get user I am taking account also from there so cascade means if user data change child also change so we can insert account like that
    }

    @Override
    public User credit(int userid, long amount) throws UserException, AccountException {

            Optional<User> user =  uDao.findById(userid);

            if(user.isPresent()){

              User exist =   user.get();

               Account accnt =  exist.getAccount();

               long balance = accnt.getBalance() + amount;

               if(balance > 10000000)  throw new AccountException("Account balance cannot go beyond 10 million");

               else {

                   accnt.setBalance(balance);

                   exist.setAccount(accnt);

                   return uDao.save(exist);

               }

            }

            else throw new UserException("no user found");
    }

    @Override
    public User debit(int userid, long amount) throws UserException, AccountException {

        Optional<User> user =  uDao.findById(userid);

        if(user.isPresent()){

            User exist =   user.get();

            Account accnt =  exist.getAccount();

            long balance = accnt.getBalance() - amount;

            if(balance < 0  )  throw new AccountException("Account balance cannot go below 0 ");

            else {

                accnt.setBalance(balance);

                 exist.setAccount(accnt);

                 return uDao.save(exist);

            }

        }

        else throw new UserException("no user found");
    }
}
