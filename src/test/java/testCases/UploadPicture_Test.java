package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class UploadPicture_Test extends BaseTest {

    @Test
    public void uploadPicture() {

        System.out.println("Driver value: " + driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div//h5[contains(text(),'Alerts, Frame')]")
                )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(text(),'Forms')]")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Practice Form')]")
                )
        ).click();

        WebElement upload = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("uploadPicture")
                )
        );

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/testdata/Rishabh Soni CV.pdf";

        System.out.println("Uploading file: " + filePath);

        upload.sendKeys(filePath);

        System.out.println("File uploaded successfully.");
    }
}
