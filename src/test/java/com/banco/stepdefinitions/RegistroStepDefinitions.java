package com.banco.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistroStepDefinitions {

    private static final Map<String, Long> SALDO_MINIMO_POR_TIPO = Map.of(
        "ahorros", 0L,
        "corriente", 100000L
    );

    private final Set<String> cuentasRegistradas = new HashSet<>();

    private DatosUsuario usuario;
    private CuentaBancaria cuenta;
    private boolean usuarioRegistrado;
    private boolean cuentaActiva;
    private String mensajeConfirmacion;

    @Given("^una persona desea vincularse al banco para gestionar sus finanzas personales$")
    public void unaPersonaDeseaVincularseAlBancoParaGestionarSusFinanzasPersonales() {
        usuarioRegistrado = false;
        cuentaActiva = false;
        mensajeConfirmacion = null;
    }

    @When("^proporciona su número de identificación (\\d+), su nombre completo (.+) y su correo electrónico ([^\\s]+) para completar el registro$")
    public void proporcionaSusDatosParaCompletarElRegistro(String numeroIdentificacion,
                                                            String nombreCompleto,
                                                            String correoElectronico) {
        usuario = new DatosUsuario(numeroIdentificacion, nombreCompleto, correoElectronico);
    }

    @And("^solicita la apertura de una cuenta con el número (\\d+), el saldo inicial (\\d+) y el tipo de cuenta (.+)$")
    public void solicitaLaAperturaDeUnaCuenta(String numeroCuenta,
                                              long saldoInicial,
                                              String tipoCuenta) {
        cuenta = new CuentaBancaria(numeroCuenta, saldoInicial, tipoCuenta.trim().toLowerCase());
    }

    @And("^el sistema verifica que el número de cuenta no esté en uso y que el saldo inicial cumpla las condiciones establecidas$")
    public void elSistemaVerificaLasCondicionesDeLaCuenta() {
        assertThat(usuario).as("El usuario debe haber suministrado sus datos").isNotNull();
        assertThat(cuenta).as("La cuenta debe haber sido solicitada").isNotNull();
        assertThat(usuario.correoElectronico)
            .as("El correo electrónico debe tener un formato válido")
            .contains("@");
        assertThat(cuentasRegistradas)
            .as("El número de cuenta no debe estar previamente registrado")
            .doesNotContain(cuenta.numeroCuenta);
        assertThat(SALDO_MINIMO_POR_TIPO)
            .as("El tipo de cuenta debe estar soportado por el sistema")
            .containsKey(cuenta.tipoCuenta);
        assertThat(cuenta.saldoInicial)
            .as("El saldo inicial debe cumplir con el mínimo para el tipo de cuenta")
            .isGreaterThanOrEqualTo(SALDO_MINIMO_POR_TIPO.get(cuenta.tipoCuenta));

        cuentasRegistradas.add(cuenta.numeroCuenta);
        usuarioRegistrado = true;
        cuentaActiva = true;
        mensajeConfirmacion = "Registro y apertura de cuenta realizados correctamente";
    }

    @Then("^el usuario queda registrado con su nueva cuenta bancaria activa y recibe la confirmación para comenzar a gestionar sus productos financieros$")
    public void elUsuarioQuedaRegistradoConSuNuevaCuentaBancariaActiva() {
        assertThat(usuarioRegistrado).isTrue();
        assertThat(cuentaActiva).isTrue();
        assertThat(mensajeConfirmacion).isEqualTo("Registro y apertura de cuenta realizados correctamente");
    }

    private static class DatosUsuario {
        private final String numeroIdentificacion;
        private final String nombreCompleto;
        private final String correoElectronico;

        private DatosUsuario(String numeroIdentificacion, String nombreCompleto, String correoElectronico) {
            this.numeroIdentificacion = numeroIdentificacion;
            this.nombreCompleto = nombreCompleto;
            this.correoElectronico = correoElectronico;
        }
    }

    private static class CuentaBancaria {
        private final String numeroCuenta;
        private final long saldoInicial;
        private final String tipoCuenta;

        private CuentaBancaria(String numeroCuenta, long saldoInicial, String tipoCuenta) {
            this.numeroCuenta = numeroCuenta;
            this.saldoInicial = saldoInicial;
            this.tipoCuenta = tipoCuenta;
        }
    }
}