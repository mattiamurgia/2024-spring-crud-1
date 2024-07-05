package app.project5.app.Bank.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double personalAccount;
    private String name;
    private String surname;

    public BankAccount() {
    };

    public BankAccount(String name, String surname) {
        setPersonalAccount(0.0);
        setName(name);
        setSurname(surname);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(double personalAccount) {
        this.personalAccount = personalAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Method for adding money
    public void addMoney(double amount) throws Exception {
        if (amount > 0) {
            this.personalAccount += amount;
            System.out.println("Deposito di " + amount + " effettuato");
        } else {
            throw new Exception("L'importo del deposito non valido");
        }
    }

    // Method for making a withdrawal
    public void removeMoney(double amount) throws Exception {
        if (amount > 0) {
            if (amount <= getPersonalAccount()) {
                this.personalAccount -= amount;
                System.out.println("Prelievo di " + amount + " effettuato");
            } else {
                throw new Exception("Saldo insufficiente");
            }
        } else {
            System.out.println("L'importo del prelievo non valido");
        }
    }

    public String getDetails() {
        return "Saldo attuale di: " + getName() + " - " + getSurname() + " Saldo: " + getPersonalAccount() + " ID: " + getId();
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
