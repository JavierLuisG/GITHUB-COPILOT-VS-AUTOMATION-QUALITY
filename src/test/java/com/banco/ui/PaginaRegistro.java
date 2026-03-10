package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaRegistro {

	public static final Target CAMPO_IDENTIFICACION = Target.the("campo número de identificación")
		.locatedBy("//input[contains(@id,'identificacion') or contains(@name,'identificacion') or @type='number']");

	public static final Target CAMPO_NOMBRE_COMPLETO = Target.the("campo nombre completo")
		.locatedBy("//input[contains(@id,'nombre') or contains(@name,'nombre') or contains(@placeholder,'Nombre')]");

	public static final Target CAMPO_CORREO_ELECTRONICO = Target.the("campo correo electrónico")
		.locatedBy("//input[contains(@id,'correo') or contains(@name,'correo') or @type='email']");

	public static final Target BOTON_REGISTRAR_USUARIO = Target.the("botón registrar usuario")
		.locatedBy("//button[contains(.,'Registrar') or contains(.,'Registrarse') or contains(.,'Crear usuario')]");

	private PaginaRegistro() {
	}
}
