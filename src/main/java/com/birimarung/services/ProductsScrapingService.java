package com.birimarung.services;


import com.birimarung.dto.ProductDTO;
import com.birimarung.page_objects.PageObjects;
import com.birimarung.stores_products_scrapers_utils.CheckersProductsScraper;
import com.birimarung.stores_products_scrapers_utils.LiquorCityProductsScraper;
import com.birimarung.stores_products_scrapers_utils.PickNPayProductsScraper;
import com.birimarung.utils.WebDriverUtils;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductsScrapingService {

    private final PageObjects pageObjects;
    private static final Logger logger = LoggerFactory.getLogger(ProductsScrapingService.class);
    private final CheckersProductsScraper checkersProductsScraper;
    private final PickNPayProductsScraper pickNPayProductsScraper;
    private final LiquorCityProductsScraper liquorCityProductsScraper;
    private WebDriverUtils webDriverUtils;


    public List<ProductDTO> getProducts(String storeName, WebDriver driver, String drinkName) throws InterruptedException {
        List<ProductDTO> productDTOList = new ArrayList<>();
        switch (storeName) {
            case "checkers", "shoprite":
                productDTOList = checkersProductsScraper.checkersProducts(driver, pageObjects, webDriverUtils, productDTOList, drinkName);
                break;
            case "picknpay":
                productDTOList = pickNPayProductsScraper.pickNPayProducts(driver, pageObjects, productDTOList);
                break;
            case "liquorcity":
                productDTOList = liquorCityProductsScraper.liquorCityProducts(productDTOList, drinkName);
                break;
            default:
                break;
        }

        return productDTOList;
    }

}

