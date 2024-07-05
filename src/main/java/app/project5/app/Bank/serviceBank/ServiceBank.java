package app.project5.app.Bank.serviceBank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.project5.app.Bank.pojo.BankAccount;
import app.project5.app.Bank.repoBank.RepoBank;

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
    public BankAccount updateBankAccount(Integer id, BankAccount bankAccount) throws Exception {
        Optional<BankAccount> idFound = repoBank.findById(id);
        if (idFound.isPresent()) {
            BankAccount accountUpdate = idFound.get();
            accountUpdate.setName(bankAccount.getName());
            accountUpdate.setSurname(bankAccount.getSurname());
            accountUpdate.setPersonalAccount(bankAccount.getPersonalAccount());
            return repoBank.save(accountUpdate);
        } else {
            throw new Exception("ID non presente " + id);
        }
    }

    // DELETE an account
    public void deleteBankAccount(Integer id) {
        repoBank.deleteById(id);
    }
}
