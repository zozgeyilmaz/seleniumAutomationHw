package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Methods {
    WebDriver driver;
    FluentWait <WebDriver> wait;
    JavascriptExecutor jsdriver;

    Logger logger= LogManager.getLogger(Methods.class);

    public Methods(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMillis(30)).
                pollingEvery(Duration.ofMillis(300)).
                ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }
    public WebElement findElement(By by){ // import için alt+ enter
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findAllElements(By by){
        return driver.findElements(by);
    }

    public void click(By by){
        findElement(by).click();
    }

    public void sendKey(By by, String text){
        findElement(by).sendKeys(text);
    }
    public void waitBySeconds(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        }catch (Exception e){
            logger.info("False" + e.getMessage());
            return false;
        }
    }
    public  void scrollWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public Select getSelect(By by){
        return  new Select(findElement(by));
    }
    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }
    public String getAttribute(By by,String attributeName){
        return  findElement(by).getAttribute(attributeName);
    }
    public  String getText(By by){
        return findElement(by).getText();
    }
    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value;",findElement(by)).toString();
    }
    public void scrollWithJavaScript(By by){
        jsdriver.executeScript("arguments[0].scrollIntoView;",findElement(by));
    }
    public void clickWithJavaScript(By by) {
        jsdriver.executeScript("arguments[0].click();", findElement(by));
    }
}