package starter.ui.AddTransaction;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddTransactionPage {

    public static Target BUTTON_ADD_TRANSACTION = Target.the("addTransaction button").located(By.xpath("//button[@data-target='#transactionModal']"));
    public static Target INPUT_DATE = Target.the("addTransaction input").located(By.xpath("//input[@type='date']"));
    public static Target INPUT_AMOUNT = Target.the("amount input").located(By.id("amount"));
    public static Target INPUT_DESCRIPTION = Target.the("description input").located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("save button").located(By.xpath("//button[contains(., 'Guardar')]"));
    public static Target TRANSACTIONS_TABLE = Target.the("Transactions table")
            .located(By.xpath("//tbody[@id='transactions-list']"));

    public static String TRANSACTIONS_TABLE_XPATH = "//tbody[@id='transactions-list']";


}
