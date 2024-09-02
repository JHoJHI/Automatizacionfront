/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.screenp.automatizationfront.tasks;

/**
 *
 * @author crist
 */
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {

    private final String url;

    public OpenTheApplication(String url) {

        this.url = url;

    }

    @Override

    @Step("{0} opens the application")

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.url(url));

    }

    public static OpenTheApplication on(String url) {

        return new OpenTheApplication(url);

    }

}
