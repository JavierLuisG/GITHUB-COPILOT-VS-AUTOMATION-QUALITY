Feature: Vinculación del usuario y apertura de cuenta para gestionar sus finanzas personales

  Scenario Outline: Usuario se registra y habilita una cuenta bancaria para comenzar a administrar su dinero
    Given una persona desea vincularse al banco para gestionar sus finanzas personales
    When proporciona su número de identificación <numero_identificacion>, su nombre completo <nombre_completo> y su correo electrónico <correo_electronico> para completar el registro
    And solicita la apertura de una cuenta con el número <numero_cuenta>, el saldo inicial <saldo_inicial> y el tipo de cuenta <tipo_cuenta>
    And el sistema verifica que el número de cuenta no esté en uso y que el saldo inicial cumpla las condiciones establecidas
    Then el usuario queda registrado con su nueva cuenta bancaria activa y recibe la confirmación para comenzar a gestionar sus productos financieros

    Examples:
      | numero_identificacion | nombre_completo    | correo_electronico      | numero_cuenta | saldo_inicial | tipo_cuenta |
      | 987654321             | Andrés Torres Ruiz | andres.torres@email.com | 200300400     | 1000000       | corriente   |
