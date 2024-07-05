package app.project5.app.Bank.pojo.serviceBank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.project5.app.Bank.pojo.BankAccount;
import app.project5.app.Bank.pojo.repoBank.RepoBank;

@Service
public class ServiceBank {

    @Autowired
    RepoBank repoBank;

    // CREATE new acccount on the database
    public void saveBankAccount(BankAccount bankAccount) {
        repoBank.save(bankAccount);
    }

    // READ all accounts bank
    public List<BankAccount> getAllBankAccounts() {
        return repoBank.findAll();
    }

    // READ a specific account
    public Optional<BankAccount> getIndivdualAccountBank(Integer id) {
        return repoBank.findById(id);
    }

    // UPDATE a specific account
    public void updateBankAccount(BankAccount bankAccount) {
        repoBank.save(bankAccount);
    }

    // DELETE an account
    public void deleteBankAccount(Integer id) {
        repoBank.deleteById(id);
    }
}
