import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginCheckTest {

    private SelenideElement signInButton = $("#w3loginbtn");
    private SelenideElement emailInput = $("#modalusername");
    private SelenideElement passwordInput = $("#current-password");
    private SelenideElement loginButton = $(By.xpath("//button[@class='Button_button__URNp+ Button_primary__d2Jt3 Button_fullwidth__0HLEu']"));
    private SelenideElement title = $("title");

    private String username = "serikov.abzal10@gmail.com";
    private String userPassword = "Qweasd@2";
    private String siteURL = "https://www.w3schools.com/";

    @Test
    public void userAuthorization() {

        open(siteURL);
        signInButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);
        emailInput.shouldBe(visible, Duration.ofSeconds(1)).setValue(username);
        sleep(2000);
        passwordInput.shouldBe(visible, Duration.ofSeconds(1)).setValue(userPassword);
        sleep(2000);
        loginButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(5000);
        title.shouldHave(attribute("text", "My learning | W3Schools"));
        sleep(5000);
    }
}
