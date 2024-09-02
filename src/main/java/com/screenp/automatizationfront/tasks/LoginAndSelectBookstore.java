/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.screenp.automatizationfront.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


/**
 *
 * @author crist
 */
public class LoginAndSelectBookstore implements Task {

    private final String userName;
    private final String password;

    public LoginAndSelectBookstore(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    @Step("{0} logs in and selects Book Store")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(By.id("userName")),
                Enter.theValue(userName).into(By.id("userName")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.id("login"))
        );
    }

    public static LoginAndSelectBookstore withCredentials(String userName, String password) {
        return new LoginAndSelectBookstore(userName, password);
    }
}
