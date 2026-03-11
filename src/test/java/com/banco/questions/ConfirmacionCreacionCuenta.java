package com.banco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class ConfirmacionCreacionCuenta implements Question<String> {

	public static ConfirmacionCreacionCuenta mostradoEnLaAlerta() {
		return new ConfirmacionCreacionCuenta();
	}

	@Override
	public String answeredBy(Actor actor) {
		return TheWebPage.alertText().answeredBy(actor);
	}
}