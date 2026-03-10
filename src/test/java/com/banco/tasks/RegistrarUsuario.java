package com.banco.tasks;

import com.banco.ui.PaginaInicio;
import com.banco.ui.PaginaRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;

public class RegistrarUsuario implements Task {

	private final String identificacion;
	private final String nombre;
	private final String correoElectronico;

	public RegistrarUsuario(String identificacion, String nombre, String correoElectronico) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
	}

	public static RegistrarUsuario crearUsuario(String identificacion, String nombre, String correoElectronico) {
		return Tasks.instrumented(RegistrarUsuario.class, identificacion, nombre, correoElectronico);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
			Click.on(PaginaInicio.BOTON_REGISTRO),
			Enter.theValue(identificacion).into(PaginaRegistro.CAMPO_IDENTIFICACION),
			Enter.theValue(nombre).into(PaginaRegistro.CAMPO_NOMBRE_COMPLETO),
			Enter.theValue(correoElectronico).into(PaginaRegistro.CAMPO_CORREO_ELECTRONICO),
			Click.on(PaginaRegistro.BOTON_REGISTRAR_USUARIO),
			Switch.toAlert().andAccept()
		);
	}
}
