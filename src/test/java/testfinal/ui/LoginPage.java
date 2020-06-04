package testfinal.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target USERNAME_FIELD = Target.the("email field")
            .located(By.cssSelector("input[type=\"email\"]"));
    public static Target PASSWORD_FIELD = Target.the("password field")
            .located(By.cssSelector("input[type=\"password\"]"));
    public static Target BUTTON_LOGIN = Target.the("button login")
            .located(By.xpath("//button[contains(text(),'ng nh')]"));
    public static Target OTP_FIELD = Target.the("otp field")
            .located(By.cssSelector("input[type=\"text\"]"));
    public static Target BUTTON_CONFIRM = Target.the("button confirm")
            .located(By.cssSelector("button.btn-confirm"));
}
