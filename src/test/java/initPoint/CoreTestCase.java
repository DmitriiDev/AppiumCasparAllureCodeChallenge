package initPoint;

import Helpers.TestListener;
import PageObject.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.net.URL;

/*
 *  Init class for Appium. There is initialization a driver for the ios or android platforms. As I don't have an app for ios
 *  tests always run only on the android platform. iOS just for example.
 *  Also, there are PageObject classes initialization.
 */


//@Ignore
public class CoreTestCase  {

    public static AppiumDriver driver;
    public Platform Platform;
    public IOSPageObject ios = new IOSPageObject(driver);
    public MainDashBoardScreenObject mainDashBoardScreen = new MainDashBoardScreenObject(driver);
    public PreparationForTrainingScreenObject preparationTrainScreen = new PreparationForTrainingScreenObject(driver);
    public ExerciseScreenObject exerciseScreen = new ExerciseScreenObject(driver);
    public WaitingScreenObject waitOfStartTrain = new WaitingScreenObject(driver);
    public RunExerciseScreenObject runExerciseScreen = new RunExerciseScreenObject(driver);
    @BeforeSuite
    public void setUp() throws Exception
    {
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}