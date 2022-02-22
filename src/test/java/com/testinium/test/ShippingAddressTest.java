package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import com.testinium.page.ShippingAddressPage;
import org.junit.Test;

public class ShippingAddressTest extends BaseTest {
    @Test
    public void addressInfoTest(){
        LoginPage loginPage = new LoginPage();
        ShippingAddressPage shippingAddressPage=new ShippingAddressPage();
        ProductPage productPage = new ProductPage();
        loginPage.login();
        productPage.scrollAndSelectProduct();
        shippingAddressPage.addressInfo();
    }
}
