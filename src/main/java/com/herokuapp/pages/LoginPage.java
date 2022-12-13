package com.herokuapp.pages;


import com.aventstack.extentreports.Status;
import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@class='radius']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id=\"content\"]/div/h2")
    WebElement secureAreaText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']/div[1]")
    WebElement usernameErrorMessage;
    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']//div[1]")
    WebElement passwordErrorMessage;

    public void enterUsername(String username) {
        Reporter.log("Enter Username" + usernameField.toString());
        sendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS, "Enter Username");
    }

    public void enterpassword(String password) {
        Reporter.log("Enter Password" + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password");
    }

    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click On Login Button");
    }

    public String getDisplayedText() {
        Reporter.log("Verify Display Text" + secureAreaText.toString());
        CustomListeners.test.log(Status.PASS, "Verify Display Text");
        return getTextFromElement(secureAreaText);

    }

    public String getUsernameErrorMessage() {
        Reporter.log("Verify Username Error Message" + usernameErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Verify Username Error Message");
        return getTextFromElement(usernameErrorMessage);
    }

    public String getPasswordErrorMessage() {
        Reporter.log("Verify Password Error Message" + passwordErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Verify Password Error Message");
        return getTextFromElement(passwordErrorMessage);
    }
}
