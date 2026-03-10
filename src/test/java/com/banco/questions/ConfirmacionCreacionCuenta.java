package com.banco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ConfirmacionCreacionCuenta implements Question<String> {

	public static ConfirmacionCreacionCuenta mostradoEnLaAlerta() {
		return new ConfirmacionCreacionCuenta();
	}

	@Override
	public String answeredBy(Actor actor) {
		return BrowseTheWeb.as(actor)
			.getDriver()
			.switchTo()
			.alert()
			.getText();
	}
}