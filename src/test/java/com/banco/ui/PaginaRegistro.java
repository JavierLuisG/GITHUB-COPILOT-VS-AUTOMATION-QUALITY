package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaRegistro {

	public static final Target CAMPO_IDENTIFICACION = Target.the("campo número de identificación")
		.locatedBy("//*[@id=\"numeroIdentificacion\"]");

	public static final Target CAMPO_NOMBRE_COMPLETO = Target.the("campo nombre completo")
		.locatedBy("//*[@id=\"nombre\"]");

	public static final Target CAMPO_CORREO_ELECTRONICO = Target.the("campo correo electrónico")
		.locatedBy("//*[@id=\"correo\"]");

	public static final Target BOTON_REGISTRAR_USUARIO = Target.the("botón registrar usuario")
		.locatedBy("//*[@id=\"root\"]/div/main/div/div/div[2]/div/form/div[4]/button[1]");

	private PaginaRegistro() {
	}
}
