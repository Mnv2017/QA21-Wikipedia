package com.telran.wiki.tests;

import org.testng.annotations.Test;

public class SmokyWikipediaTest extends TestBase{

    @Test
    public void addArticleAndRemoveTest(){
        System.out.println("****  App launch  ****");

        app.getArticle().search();
        app.getArticle().addToFavorites();
        app.getArticle().createReadingList();
        app.getArticle().goToFavorites();
        app.getArticle().removeFromFavorites();
    }
}
