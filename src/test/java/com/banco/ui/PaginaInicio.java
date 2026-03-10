package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio {

	public static final Target BOTON_REGISTRO = Target.the("botón de registro")
		.locatedBy("//button[contains(.,'Registro') or contains(.,'Registrarse')]");

	private PaginaInicio() {
	}
}
