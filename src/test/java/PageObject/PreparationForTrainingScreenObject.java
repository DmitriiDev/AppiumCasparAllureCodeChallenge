package PageObject;

import Helpers.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PreparationForTrainingScreenObject extends Main {

    public PreparationForTrainingScreenObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickReadyButton_dashBoard() {
        this.waitForElementAndClick(By.id(Constants.planOfExercises_ready_button), "no I'm ready button here", 10);
    }

    public boolean clickReadyButtonIsDisplayed() {
        WebElement readyButton = this.waitForElement(By.id(Constants.planOfExercises_ready_button), "no counter of exercises");
        return readyButton.isDisplayed();
    }
}
