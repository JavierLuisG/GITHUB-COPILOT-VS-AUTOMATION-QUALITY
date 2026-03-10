package com.banco.tasks;

import com.banco.ui.PaginaCuentas;
import com.banco.ui.PaginaPerfil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCuenta implements Task {

	private final String numeroCuenta;
	private final String tipoCuenta;
	private final String saldoInicial;
	private final String usuarioTitular;

	public CrearCuenta(String numeroCuenta, String tipoCuenta, String saldoInicial, String usuarioTitular) {
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.usuarioTitular = usuarioTitular;
	}

	public static CrearCuenta registrarCuenta(String numeroCuenta, String tipoCuenta, String saldoInicial,
			String usuarioTitular) {
		return Tasks.instrumented(CrearCuenta.class, numeroCuenta, tipoCuenta, saldoInicial, usuarioTitular);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			WaitUntil.the(PaginaPerfil.BOTON_CREAR_PRIMERA_CUENTA, isVisible()),
			Scroll.to(PaginaPerfil.BOTON_CREAR_PRIMERA_CUENTA),
			Click.on(PaginaPerfil.BOTON_CREAR_PRIMERA_CUENTA),
			Click.on(PaginaCuentas.BOTON_NUEVA_CUENTA),
			Enter.theValue(numeroCuenta).into(PaginaCuentas.CAMPO_NUMERO_CUENTA),
			SelectFromOptions.byVisibleText(tipoCuenta).from(PaginaCuentas.SELECTOR_TIPO_CUENTA),
			Enter.theValue(saldoInicial).into(PaginaCuentas.CAMPO_SALDO_INICIAL),
			SelectFromOptions.byVisibleText(usuarioTitular).from(PaginaCuentas.SELECTOR_USUARIO_TITULAR),
			Click.on(PaginaCuentas.BOTON_CREAR_CUENTA)
		);
	}
}
