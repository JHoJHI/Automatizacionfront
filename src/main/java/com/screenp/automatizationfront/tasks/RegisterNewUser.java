/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.screenp.automatizationfront.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterNewUser implements Task {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    public RegisterNewUser(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

    }

    @Override
    @Step("{0} registers a new user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.id("newUser")),
                Enter.theValue(firstName).into(By.id("firstname")),
                Enter.theValue(lastName).into(By.id("lastname")),
                Enter.theValue(username).into(By.id("userName")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.id("register"))
        );

    }

    public static RegisterNewUser withData(String firstName, String lastName, String username, String password) {
        return instrumented(RegisterNewUser.class, firstName, lastName, username, password);

    }

}

