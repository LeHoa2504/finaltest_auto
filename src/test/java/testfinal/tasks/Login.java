package testfinal.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import testfinal.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.BUTTON_LOGIN)
        );
    }

    public static Login With(String username, String password){
        return instrumented(Login.class, username, password);
    }

    public static LoginBuilder withUserName(String email){
        return new LoginBuilder(email);
    }
    public static class LoginBuilder{
        private String email;
        // private String password;

        public LoginBuilder(String email){
            this.email = email;
        }
        public Login andPassword(String password){
            return instrumented(Login.class, this.email, password);
        }

    }

}
