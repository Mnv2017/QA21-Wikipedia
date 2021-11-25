package com.telran.wiki.tests;

import com.telran.wiki.fw.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected static AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }
}
