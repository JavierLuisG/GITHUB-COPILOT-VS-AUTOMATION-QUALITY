package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCuentas {

	public static final Target BOTON_NUEVA_CUENTA = Target.the("botón nueva cuenta")
		.locatedBy("//button[text()='Nueva cuenta']");

	public static final Target CAMPO_NUMERO_CUENTA = Target.the("campo número de cuenta")
		.locatedBy("//input[@id='numero']");

	public static final Target SELECTOR_TIPO_CUENTA = Target.the("selector tipo de cuenta")
		.locatedBy("//select[name='tipoCuenta']");

	public static final Target CAMPO_SALDO_INICIAL = Target.the("campo saldo inicial")
		.locatedBy("//input[@id='saldo']");

	public static final Target SELECTOR_USUARIO_TITULAR = Target.the("selector usuario titular")
		.locatedBy("//select[@id='idUsuario']");

	public static final Target BOTON_CREAR_CUENTA = Target.the("botón crear cuenta")
		.locatedBy("//button[text()='Crear cuenta']");

	private PaginaCuentas() {
	}
}
