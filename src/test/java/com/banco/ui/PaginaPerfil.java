package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPerfil {

	public static final Target BOTON_CREAR_PRIMERA_CUENTA = Target.the("botón crear primera cuenta")
		.locatedBy("//button[contains(.,'Crear primera cuenta') or contains(.,'Crear cuenta') or contains(.,'Abrir cuenta')]");

	private PaginaPerfil() {
	}
}
