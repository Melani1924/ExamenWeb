package com.nttdata.page;

import org.openqa.selenium.By;

public class LinioLoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("login_form_email");
    public static By passInput = By.id("login_form_password");
    public static By loginButton = By.id("login-google");

    public static By botonButton = By.cssSelector("#catalogue-product-container > div:nth-child(1) > a.rating-container.pill-enabled.col-12.pl-0");


    public static By buyButton=By.id("buy-now");

}
