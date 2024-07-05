package app.project5.app.pojo;

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

    public BankAccount() {
    };

    public BankAccount(double money) {
        setPersonalAccount(money);
    }

    public double getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(double personalAccount) {
        this.personalAccount = personalAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
