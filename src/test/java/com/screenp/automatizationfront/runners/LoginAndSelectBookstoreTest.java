/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.screenp.automatizationfront.runners;

/**
 *
 * @author crist
 */
import com.screenp.automatizationfront.tasks.OpenTheApplication;
import com.screenp.automatizationfront.tasks.LoginAndSelectBookstore;
import com.screenp.automatizationfront.utils.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

@RunWith(SerenityRunner.class)
public class LoginAndSelectBookstoreTest {
    @Managed(driver = "chrome")
    public WebDriver browser;
    private Actor user;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        browser = WebDriverManager.chromedriver().create();
        OnStage.setTheStage(new OnlineCast());
        user = Actor.named("TestUser");
        user.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void shouldBeAbleToLoginAndSelectBookstore() throws IOException {
        // Leer los datos de usuario desde el archivo Excel
        ExcelReader excelReader = new ExcelReader("src/test/resources/userData.xlsx");
        String[] userData = excelReader.getUserData(1);

        user.attemptsTo(
            // Abrir la aplicación en la página de login
            OpenTheApplication.on("https://demoqa.com/login"),

            // Realizar login y seleccionar la opción Book Store
            LoginAndSelectBookstore.withCredentials(userData[0], userData[1])
        );
    }
}
