package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPerfil {

	public static final Target BOTON_CREAR_PRIMERA_CUENTA = Target.the("botón crear primera cuenta")
		.locatedBy("//button[text()='Crear primera cuenta']");

	private PaginaPerfil() {
	}
}
