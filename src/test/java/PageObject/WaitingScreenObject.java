package PageObject;

import Helpers.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WaitingScreenObject extends Main {

    public WaitingScreenObject(AppiumDriver driver)
    {
        super(driver);
    }

    public boolean isWaitingScreenShown() {
        WebElement waiting_for_exeecises_screen = this.waitForElement(By.id(Constants.waitingScreen_get_ready_text), "no waiting_For_Exeecises screen", 10);
       return waiting_for_exeecises_screen.isDisplayed();
    }

}
