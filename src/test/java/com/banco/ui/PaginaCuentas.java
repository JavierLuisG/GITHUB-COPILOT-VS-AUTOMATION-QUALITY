package com.banco.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCuentas {

	public static final Target BOTON_NUEVA_CUENTA = Target.the("botón nueva cuenta")
		.locatedBy("//button[contains(.,'Nueva cuenta') or contains(.,'Crear cuenta')]");

	public static final Target CAMPO_NUMERO_CUENTA = Target.the("campo número de cuenta")
		.locatedBy("//input[contains(@id,'cuenta') or contains(@name,'cuenta') or contains(@placeholder,'cuenta')]");

	public static final Target SELECTOR_TIPO_CUENTA = Target.the("selector tipo de cuenta")
		.locatedBy("//select[contains(@id,'tipo') or contains(@name,'tipo')] | //mat-select[contains(@id,'tipo') or contains(@name,'tipo')]");

	public static final Target CAMPO_SALDO_INICIAL = Target.the("campo saldo inicial")
		.locatedBy("//input[contains(@id,'saldo') or contains(@name,'saldo') or contains(@placeholder,'saldo')]");

	public static final Target SELECTOR_USUARIO_TITULAR = Target.the("selector usuario titular")
		.locatedBy("//select[contains(@id,'titular') or contains(@name,'titular') or contains(@id,'usuario') or contains(@name,'usuario')] | //mat-select[contains(@id,'titular') or contains(@name,'titular') or contains(@id,'usuario') or contains(@name,'usuario')]");

	public static final Target BOTON_CREAR_CUENTA = Target.the("botón crear cuenta")
		.locatedBy("//button[contains(.,'Crear cuenta') or contains(.,'Guardar cuenta') or contains(.,'Abrir cuenta')]");

	private PaginaCuentas() {
	}
}
