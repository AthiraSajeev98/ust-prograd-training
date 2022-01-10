package athira.ABCBank.Service;

import athira.ABCBank.Entity.Account;
import athira.ABCBank.Entity.Customers;
import athira.ABCBank.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

        @Autowired
        private AccountRepository accountRepository;

        public String save(Account account) {
            accountRepository.save(account);

            return "Account Details Updated...";
        }

        public List<Account> listAll() {
            return accountRepository.findAll();
        }


        public Account findById(String accountNumber){
            return accountRepository.getById(accountNumber);
        }

//        public Account findBYAccountNumber(Long accountNumber){
//            return accountRepository.findByAccountNumber(accountNumber);
//        }
//        public Account findBYAccountName(String customerName) {
//            return accountRepository.findByCustomerName(customerName);
//        }
        public boolean existById(String  accountNumber){
            return accountRepository.existsById(accountNumber);
        }
}
