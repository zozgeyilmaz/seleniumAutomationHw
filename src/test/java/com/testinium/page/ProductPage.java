package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);
    Random rand = new Random();

    public ProductPage() {
        methods = new Methods();
    }

    public void scrollAndSelectProduct() {
        methods.sendKey(By.id("search-input"), "oyuncak");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(3);

        //methods.click(By.cssSelector(".pr-img-link"));
        methods.scrollWithAction(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        // methods.clickWithJavaScript(By.xpath(""));

        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//img[@title='kitapla buluşmanın en kolay yolu!']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[@href=\"puan-katalogu\"]"));
        methods.waitBySeconds(1);
        methods.scrollWithAction(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(1);
        methods.selectByText(By.cssSelector("div[class='sort']>select[onchange='location = this.value;']"),"Yüksek Oylama");
        methods.waitBySeconds(1);
        methods.click(By.xpath("//span[text()='Tüm Kitaplar']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[text()='Hobi']"));
        methods.waitBySeconds(1);
        selectRandomProduct();
        methods.waitBySeconds(1);
        methods.click(By.xpath("//span[text()='Sepete Ekle']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[text()='Listelerim']"));
        methods.click(By.xpath("//a[text()='Favorilerim']"));
        methods.click(By.xpath("//div[@class='product-cr'][3]//i[@class='fa fa-heart-o']"));
        methods.waitBySeconds(1);

    }
    public void selectRandomProduct() {
        List<WebElement> productList = methods.findAllElements(By.cssSelector(".pr-img-link"));
        int randNum = rand.nextInt(productList.size()-1); //0 - productList.size()
        productList.get(randNum).click();
    }

}
















