package PageObject;

import Helpers.Constants;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainDashBoardScreenObject extends Main {

    public MainDashBoardScreenObject(AppiumDriver driver)
    {
        super(driver);
    }

//    @Step("Main DashBoard: Click on go -> button")
    public void clickGoTrainingBtn() {
        this.waitForElementAndClick(By.id(Constants.mainDashBoard_my_training_arrow), "no GO button here", 10);
    }

//    @Step("Main DashBoard: KnowledgeView is displayed")
    public boolean knowledgeViewGroupIsDisplayed() {
        WebElement knowledge_groupView = this.waitForElement(By.id(Constants.mainDashBoard_knowledge), "no progress");
     return knowledge_groupView.isDisplayed();
    }

//    @Step("Main DashBoard: Counter of exercises is displayed")
    public boolean total_exercise_countIsDisplayed() {
        WebElement exercise_counter = this.waitForElement(By.id(Constants.mainDashBoard_total_exercise_count_text), "no counter of exercises");
        return exercise_counter.isDisplayed();
    }

//    @Step("Main DashBoard: Tap on My Training View")
    public void tapOnMyTrainingView() {
        WebElement exercise_counter = this.waitForElement(By.id("title_my_training_text"), "no title myTraining");
        exercise_counter.click();
    }
}
