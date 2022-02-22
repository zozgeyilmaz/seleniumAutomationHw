package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;

    public LoginPage() {
        methods = new Methods();
    }

    public void login() {
        methods.click(By.cssSelector(".menu-top-button.login>a")); //locator aldık .cssSelevtor ile
        methods.waitBySeconds(1);
        methods.sendKey(By.id("login-email"), "zubeydeozge.yarici@testinium.com");
        methods.waitBySeconds(1);
        methods.sendKey(By.id("login-password"), "1q2w3e4r");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(22);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".section")));
    }
}