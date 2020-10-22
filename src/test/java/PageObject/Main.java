package PageObject;

//import Helpers.Constants;
import initPoint.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Main {

    public static AppiumDriver driver;

    public Main (AppiumDriver driver)
    {
        this.driver = driver;
    }

    public static WebElement waitForElement(By by, String error_message, long timeOutInSecond)
    {
        WebElement webElement;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSecond))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        webElement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });

            return webElement;
    }

    public static WebElement waitForElement(By by, String error_message)
    {
        return waitForElement(by, error_message, 15);
    }

    public static void waitForElementAndClick(By by, String error_message, long timeOutInSecond)
    {
        WebElement element =  waitForElement(by, error_message,timeOutInSecond);
        element.click();
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond) {
        WebElement element =  waitForElement(by, error_message,timeOutInSecond);
        element.sendKeys(value);
        return element;
    }

    public static WebElement waitForElementAndSendKeys(By by, String value, String error_message)
    {
        WebElement element =  waitForElement(by, error_message,5);
        element.sendKeys(value);
        return element;
    }

    public void clickNavigateUpButton() {
        waitForElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"), "saas").click();
    }

}