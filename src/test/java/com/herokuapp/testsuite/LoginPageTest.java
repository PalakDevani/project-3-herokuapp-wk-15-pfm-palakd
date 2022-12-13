package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)


public class LoginPageTest extends BaseTest {
    LoginPage loginpage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginpage = new LoginPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginpage.enterUsername("tomsmith");
        loginpage.enterpassword("SuperSecretPassword!");
        loginpage.clickOnLoginButton();
        Assert.assertEquals(loginpage.getDisplayedText(), "Secure Area", "Secure Area text not displayed");

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        loginpage.enterUsername("tomsmith1");
        loginpage.enterpassword("SuperSecretPassword!");
        loginpage.clickOnLoginButton();
        Assert.assertEquals(loginpage.getUsernameErrorMessage(), "Your username is invalid!\n" + "×", "error message not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThePasswordErrorMessage() {
        loginpage.enterUsername("tomsmith");
        loginpage.enterpassword("SuperSecretPassword");
        loginpage.clickOnLoginButton();
        Assert.assertEquals(loginpage.getPasswordErrorMessage(), "Your password is invalid!\n" + "×", "error message not dispalyed");


    }
}