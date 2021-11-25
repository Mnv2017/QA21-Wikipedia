package com.telran.wiki.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities; //как в Inspector
    ArticleHelper article;

    public ArticleHelper getArticle() {
        return article;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa21_mob");
        capabilities.setCapability("automationName", "Appium"); // добавили сами
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/nataliamorgel/Tools/org.wikipedia.apk");// путь где лежит на компе

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // из Inspector Remout host+ Port+Path
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        article = new ArticleHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
}


