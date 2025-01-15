package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.models.AssertionsTransaction;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.navigation.NavigateTo;
import starter.Util.GetInfoFromTable;
import starter.tasks.AddTransaction.AddTransaction;
import starter.tasks.AddTransaction.CheckNewTransactionWasAdded;
import starter.tasks.Login.Login;

public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
        public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin){

        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);
        actor.attemptsTo(
                NavigateTo.loginPage(),
                new Login(loginModel.getUsername(), loginModel.getPassword())

        );

    }

    @When("{actor} enters the required information for the new transaction")
        public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable transactionInfo){

        TransactionModel transactionModel = GetInfoFromTable.getTransactionData(transactionInfo);

        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getTransactionDate(), transactionModel.getTransactionAmount(), transactionModel.getTransactionDescription())
        );

    }

    @Then("{actor} should see a new transaction in the transaction list with correct details")
        public void shouldSeeANewTransactionInTheTransactionListWithCorrectDetails(Actor actor,DataTable verifyInfo){

        AssertionsTransaction assertionsTransaction = GetInfoFromTable.getAssertionsTransaction(verifyInfo);
        
        actor.attemptsTo(
            new CheckNewTransactionWasAdded(assertionsTransaction.getDescriptionVerify(), assertionsTransaction.getAmountVerify())
        );

    }

}
