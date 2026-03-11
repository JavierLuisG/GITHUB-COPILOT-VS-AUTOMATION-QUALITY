package com.banco.stepdefinitions;

import com.banco.hooks.AbrirNavegador;
import com.banco.questions.ConfirmacionCreacionCuenta;
import com.banco.tasks.CrearCuenta;
import com.banco.tasks.RegistrarUsuario;
import com.banco.util.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.containsString;

public class RegistroStepDefinitions {

	private String nombreCompleto;

	@Given("una persona desea vincularse al banco para gestionar sus finanzas personales")
	public void unaPersonaDeseaVincularseAlBancoParaGestionarSusFinanzasPersonales() {
		theActorCalled(Constantes.ACTOR).wasAbleTo(AbrirNavegador.abrirUrl(Constantes.URL));
	}

	@When("proporciona su numero de identificacion {string}, su nombre completo {string} y su correo electronico {string} para completar el registro")
	public void proporcionaSuNumeroDeIdentificacionSuNombreCompletoYSuCorreoElectronicoParaCompletarElRegistro(
			String numeroIdentificacion, String nombreCompleto, String correoElectronico) {
		this.nombreCompleto = nombreCompleto;

		theActorInTheSpotlight().attemptsTo(RegistrarUsuario.crearUsuario(numeroIdentificacion, nombreCompleto, correoElectronico));
	}

	@And("solicita la apertura de una cuenta con el numero {string}, el saldo inicial {string} y el tipo de cuenta {string}")
	public void solicitaLaAperturaDeUnaCuentaConElNumeroElSaldoInicialYElTipoDeCuenta(
			String numeroCuenta, String saldoInicial, String tipoCuenta) {
		theActorInTheSpotlight().attemptsTo(CrearCuenta.registrarCuenta(numeroCuenta, tipoCuenta, saldoInicial, nombreCompleto));
	}

	@And("el sistema verifica que el numero de cuenta no este en uso y que el saldo inicial cumpla las condiciones establecidas")
	public void elSistemaVerificaQueElNumeroDeCuentaNoEsteEnUsoYQueElSaldoInicialCumplaLasCondicionesEstablecidas() {
	}

	@Then("el usuario queda registrado con su nueva cuenta bancaria activa y recibe la confirmacion para comenzar a gestionar sus productos financieros")
	public void elUsuarioQuedaRegistradoConSuNuevaCuentaBancariaActivaYRecibeLaConfirmacionParaComenzarAGestionarSusProductosFinancieros() {
		theActorInTheSpotlight().should(
				seeThat(ConfirmacionCreacionCuenta.mostradoEnLaAlerta(),
						containsString(Constantes.MENSAJE_CONFIRMACION_CREACION_CUENTA)));
	}
}