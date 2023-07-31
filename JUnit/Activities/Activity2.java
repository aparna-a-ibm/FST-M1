import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {
    @Test
    public void notEnoughFunds(){
        BankAccount accountObj=new BankAccount(9);
        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> accountObj.withdraw(10));
    }

    @Test
    public void enoughFunds(){
        BankAccount accountObj=new BankAccount(100);
        // Assertion for no exceptions
        assertDoesNotThrow(() -> accountObj.withdraw(100));
    }
}
