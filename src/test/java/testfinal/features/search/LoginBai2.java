package testfinal.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testfinal.abilities.Authenticate;
import testfinal.action.ChooseDate;
import testfinal.action.ChooseVisit;
import testfinal.question.BookingResultQuestion;
import testfinal.tasks.Login;
import testfinal.tasks.ReadOTP;
import testfinal.tasks.SearchDestination;

import java.io.IOException;
import java.time.LocalDate;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class LoginBai2 {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() throws IOException {

        anna.can(BrowseTheWeb.with(herBrowser))
                .can(Authenticate.LoadTestData(anna.getName()));
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(Open.url("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin"));

        when(anna).attemptsTo(
                //Login.With("lehoa543@gmail.com", "123qweA#")
                Login.withUserName(Authenticate.as(anna).getEmail()).andPassword(Authenticate.as(anna).getPassword()),
                ReadOTP.withOTP()
        );


        //then(anna).should());

    }
}
