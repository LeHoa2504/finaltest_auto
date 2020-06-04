package testfinal.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testfinal.question.Verification;
import testfinal.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ReadOTP implements Task {


    @Override
    public <T extends Actor> void performAs(T t) {
        String otp = Verification.OTPFromEmail().answeredBy(t);
        int dem = 0;
        while(otp == "" && dem <=10){
            otp = Verification.OTPFromEmail().answeredBy(t);
            dem ++;
        }
        t.attemptsTo(
                Enter.theValue(otp).into(LoginPage.OTP_FIELD),
                Click.on(LoginPage.BUTTON_CONFIRM)

        );

    }
    public static ReadOTP withOTP() {
        return instrumented(ReadOTP.class);
    }
}
