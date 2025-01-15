package starter.tasks.AddTransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import starter.questions.GetTransactionInfo;
import starter.ui.AddTransaction.AddTransactionPage;

public class CheckNewTransactionWasAdded implements Task {

    private final String description;
    private final String amount;

    public CheckNewTransactionWasAdded(String description, String amount){
        this.description = description;
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(GetTransactionInfo.getDescription())
                        .contains(description),

                Ensure.that(AddTransactionPage.TRANSACTIONS_TABLE)
                        .text().contains(amount)
        );
    }
}
