package app.project5.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.project5.app.Bank.pojo.BankAccount;
import app.project5.app.Bank.serviceBank.ServiceBank;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	ServiceBank serviceBank;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			/** Class BankAccount Methods */
			// Creation of six bank accounts
			BankAccount c1 = new BankAccount("Marco", "Shtuously");
			BankAccount c2 = new BankAccount("Mattia", "Murgia");
			BankAccount c3 = new BankAccount("Giuseppe", "Ajddkd");
			BankAccount c4 = new BankAccount("Gaetano", "MBdjskls");
			BankAccount c5 = new BankAccount("Alessio", "Mandkdoe");
			BankAccount c6 = new BankAccount("Filippo", "Ajjdkdkdk");

			// Stamping in the terminal
			System.out.println("");

			List<BankAccount> bankAccounts = Arrays.asList(c1, c2, c3, c4, c5, c6);
			System.out.println("Tutti gli account creati:");
			bankAccounts.forEach(System.out::println);
			System.out.println();

			// Adding money to an account
			c1.addMoney(100.00);
			c2.addMoney(900.00);

			// Launch exception negative deposit
			// c1.addMoney(-200);
			System.out.println("Account con saldo aggiunto: ");
			System.out.println(c1);
			System.out.println();

			// Corrected withdrawal
			c1.removeMoney(50.00);

			// Launch exception withdraw more than you have
			// c1.removeMoney(200);
			System.out.println("Account con saldo aggiornato: ");
			System.out.println(c1);
			System.out.println();

			/** Service Methods */
			// Saving bank accounts to database
			serviceBank.saveBankAccount(c1);
			serviceBank.saveBankAccount(c2);
			serviceBank.saveBankAccount(c3);
			serviceBank.saveBankAccount(c4);
			serviceBank.saveBankAccount(c5);
			serviceBank.saveBankAccount(c6);

			// Get accounts from the database with their own data
			System.out.println("");
			System.out.println("Risultati dal database");

			// All Accounts
			System.out.println("Tutti gli account sul database: ");
			serviceBank.getAllBankAccounts().forEach(System.out::println);

			// Get only one account per id
			System.out.println();
			System.out.println("Account con ID 1: ");
			// Successful Get
			System.out.println(serviceBank.getIndivdualAccountBank(1).get());

			// Launch exception
			// System.out.println(serviceBank.getIndivdualAccountBank(0).get());

			// Updating an account database
			BankAccount c7 = new BankAccount("TEST", "TEST");
			c7.addMoney(100000.00);
			serviceBank.updateBankAccount(3, c7);
			System.out.println();

			// Launch exception
			// serviceBank.updateBankAccount(10, c7);

			// Account with updated amount
			System.out.println("Account con un account aggiornato sul database:");
			System.out.println(serviceBank.getIndivdualAccountBank(2).get());
			System.out.println();

			// Delete Account
			serviceBank.deleteBankAccount(5);
			System.out.println("Lista dal database aggiornata senza ID 5: ");
			serviceBank.getAllBankAccounts().forEach(System.out::println);

		} catch (Exception e) {
			System.out.println("Errore nell'operazione: " + e.getMessage());
		}
	}
}
