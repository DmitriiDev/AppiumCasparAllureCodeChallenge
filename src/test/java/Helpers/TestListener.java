package Helpers;

import initPoint.CoreTestCase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestListener extends CoreTestCase implements ITestListener {


    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    @Attachment(type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

        if (driver != null) {
            Allure.addAttachment("screenShot on onTestSuccess", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else {
            System.out.println("onTestSuccess takeScreenshot can't processed. Driver is null");
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        if (driver != null) {
            Allure.addAttachment("screenShot on onTestFailure", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else {
            System.out.println("onTestFailure takeScreenshot can't processed. Driver is null");
        }
    }

    @Attachment(value = "request")
    public String logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment(value = "response")
    public String logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public String attach(ByteArrayOutputStream log) {
        String array = log.toString();
        log.reset();
        return array;
    }


    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onFinish(ITestContext iTestContext) {
        try {
            if (driver != null) {
                Allure.addAttachment("screenShot on finish", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}