package testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import baseTest.BaseTest;

public class UploadPicture_Test extends BaseTest {

    @Test
    public void uploadPicture() throws InterruptedException, AWTException {
    	

        System.out.println("Driver value: " + driver); // 🔥 debug

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//div//h5[ contains(text() ,'Alerts, Frame')]"));
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
      
        element.click();       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[ contains(text() ,\"Forms\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text() , 'Practice Form')]"))).click();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadPicture"))).sendKeys("C:\\Users\\mohin\\Downloads\\Rishabh Soni CV.pdf");
      
        WebElement upload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadPicture")));

        Thread.sleep(2000);
        // Click to open file dialog
        js.executeScript("arguments[0].click();", upload);
        
    	// Wait for dialog to open
    	Thread.sleep(2000);

    	// Copy file path to clipboard
    	StringSelection ss = new StringSelection("C:\\Users\\mohin\\Downloads\\Rishabh Soni CV.pdf");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    	
    	// Use Robot
    	Robot rb = new Robot();

    	// Paste (CTRL + V)
    	rb.keyPress(KeyEvent.VK_CONTROL);
    	rb.keyPress(KeyEvent.VK_V);
    	Thread.sleep(2000);
    	
    	rb.keyRelease(KeyEvent.VK_V);
    	rb.keyRelease(KeyEvent.VK_CONTROL);
    	Thread.sleep(2000);
    	
    	// Press ENTER
    	rb.keyPress(KeyEvent.VK_ENTER);	
    	
        
        
        
    }
}
