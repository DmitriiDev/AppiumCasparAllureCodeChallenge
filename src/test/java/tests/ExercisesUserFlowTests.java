package tests;

import Helpers.Constants;
import Helpers.TestListener;
import PageObject.Main;
import initPoint.CoreTestCase;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Epic("My Training")
public class ExercisesUserFlowTests extends CoreTestCase  {
    public Main mainMethods;

    @BeforeTest
    public void setUp() throws Exception
    {
        super.setUp();
        mainMethods = new Main(driver);
    }

    @Test
    @Description("Test Description: Start the exercise and interrupt it")
    @Story("Possibility to open My Training Screen")
    @Severity(SeverityLevel.BLOCKER)
    public void test_checkLaunchAndFinishOneExercise() {
        // GIVEN:
        mainDashBoardScreen.clickGoTrainingBtn();
        // WHEN
        preparationTrainScreen.clickReadyButton_dashBoard();
        // THEN
        exerciseScreen.clickStartButton();
        Assert.assertTrue(waitOfStartTrain.isWaitingScreenShown());
        // GIVEN:
        Main.waitForElement(By.id(Constants.runExerccise_execution_type_label),"no progress Label here", 10);
        // THEN
        runExerciseScreen.clickCloseButton();
        runExerciseScreen.clickExitBtnPopUp();
        // WHEN
        mainDashBoardScreen.knowledgeViewGroupIsDisplayed();
    }

    @Description("Test Description: Check That Main screen contain the View My training")
    @Story("Possibility to open My Training Screen")
    @Issue("CH-2")
    @Issue("CH-6")
    @Test
    public void test_check_MyTraining() {
        Assert.assertTrue(mainDashBoardScreen.total_exercise_countIsDisplayed());
        mainDashBoardScreen.tapOnMyTrainingView();
        mainMethods.clickNavigateUpButton();
        mainDashBoardScreen.clickGoTrainingBtn();
        Assert.assertTrue(preparationTrainScreen.clickReadyButtonIsDisplayed());
    }
}
