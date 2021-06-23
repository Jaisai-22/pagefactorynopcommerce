package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility extends BasePage {

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {

        element.click();
    }

    public String getTextFromElement(WebElement element) {
        //String text=driver.findElement(by).getText();// another way to write next line
        return element.getText();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    public void sendTextToElement(WebElement element, String text) {

        element.sendKeys(text);
    }

    public void selectByValueFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public <value> void selectByValueFromDropDown(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }


    public void selectByIndexFromDropDown(WebElement element, int value) {
        Select select = new Select(element);
        select.selectByIndex(value);
    }

    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);

    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }


    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    public void clear(WebElement element) {

        element.clear();
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);


    public WebElement waitUntilvisibilityofElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public <BY, attribute> String getAttributefromelement(By by, String value) {
        return driver.findElement(by).getAttribute("value");
    }

    public List<WebElement> getListfromWebElements(WebElement element) {
        List<WebElement> webElementList;
        webElementList = driver.findElements((By) element);
        return webElementList;
    }

    public List getListfromWebelements(By by) {

        return driver.findElements(by);
    }

    public List<WebElement> webElementList(By by) {

        return driver.findElements(by);
    }


    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
        //driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


}
