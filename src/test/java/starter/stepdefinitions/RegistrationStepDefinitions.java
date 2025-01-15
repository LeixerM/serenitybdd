package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.mockito.exceptions.verification.NeverWantedButInvoked;
import starter.tasks.Registration.CheckNewAccountCreated;
import starter.tasks.Registration.DoNotSendAllRequiredInformation;
import starter.tasks.Registration.RegisterUser;
import starter.tasks.Registration.ShouldSeeAllFieldsAreRequired;
import starter.ui.Registration.RegisterPage;

import java.net.URISyntaxException;
import java.util.List;

public class RegistrationStepDefinitions {


    String expectedName = "";
    String expectedLastName = "";
    String expectedAge = "";
    String expectedEmail = "";
    String expectedCountry = "";


    @Given("{actor} wants to sign up in the application")
    public void wantsToSignUpInTheApplication(Actor actor) {

        actor.attemptsTo(
                Open.browserOn(new RegisterPage()));
    }

    @When("{actor} sends the required information to sign up")
    public void sendsRequiredInformationToSignUp(Actor actor, DataTable userInfo) {
        List<List<String>> rows = userInfo.asLists(String.class);

        for (List<String> columns: rows){
            expectedName = columns.get(0);
            expectedLastName = columns.get(1);
            expectedAge = columns.get(2);
            expectedEmail = columns.get(3);
            expectedCountry = columns.get(4);

        }

        actor.attemptsTo(
                new RegisterUser(expectedName,expectedLastName,expectedAge,expectedEmail,expectedCountry)
        );
    }

    @Then("{actor} should have a new account created")
    public void shouldHaveANewAccountCreated(Actor actor){
        actor.attemptsTo(
                new CheckNewAccountCreated(expectedName,expectedLastName)
        );
    }

    @When("{actor} does not send the required information")
    public void doesNotSendTheRequiredInformation(Actor actor){
        actor.attemptsTo(
                new DoNotSendAllRequiredInformation(expectedName,expectedLastName)
        );
    }

    @Then("{actor} should be told all fields are required")
    public void shouldBeToldAllFieldsAreRequired(Actor actor){
        actor.attemptsTo(
                new ShouldSeeAllFieldsAreRequired()
        );
    }
}
