package app.project5.app.Bank.pojo.repoBank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.project5.app.Bank.pojo.BankAccount;

@Repository
public interface RepoBank extends JpaRepository<BankAccount, Integer> {

}
