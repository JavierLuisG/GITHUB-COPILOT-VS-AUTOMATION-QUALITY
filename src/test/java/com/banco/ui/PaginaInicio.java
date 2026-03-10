package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio {

	public static final Target BOTON_REGISTRO = Target.the("botón de registro")
		.locatedBy("//*[@id=\"root\"]/div/header/div/div[1]/nav/a[2]");

	private PaginaInicio() {
	}
}
