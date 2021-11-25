package com.telran.wiki.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) { // клик
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) { // заполнить поля
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void moveElementRightToLeft() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int y = size.height / 5;
        int startX = (int) (size.width * 0.8);
        int stopX = (int) (size.width * 0.2);
        action.longPress(PointOption.point(startX,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(stopX,y))
                .release()
                .perform();

    }

    public void moveElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.1);
        int rightPoint = (int) (size.width * 0.9);

        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(rightPoint, middleY))
                .moveTo(PointOption.point(leftPoint, middleY))
                .release()
                .perform();
    }
}
