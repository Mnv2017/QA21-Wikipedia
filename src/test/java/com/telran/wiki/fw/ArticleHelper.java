package com.telran.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends HelperBase {
    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void search() {
        tap(By.id("search_container"));
        // search_container
        type(By.id("search_src_text"), "TCP/IP");
        // search_src_text
        tap(By.id("page_list_item_container"));
        // page_list_item_container
        String title = driver.findElement(By.id("view_page_title_text")).getText();
        System.out.println("***** " + title);
    }

    public void addToFavorites() {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"Add this article to a reading list\"]"));
    }

    public void createReadingList() {
        tap(By.id("onboarding_button"));
        type(By.id("text_input"), "IT reading list");
        tap(By.id("android:id/button1"));
        //  .//*[@resource-id='android:id/button1']
    }

    public void goToFavorites() {
        tap(By.id("snackbar_action"));

    }

    public void close() {
        tap(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    }

    public void removeFromFavorites() {
//        tap(By.id("page_list_item_container"));
        moveElementToLeft(By.id("page_list_item_container"));
        //org.wikipedia:id/page_list_item_container
    }
}
