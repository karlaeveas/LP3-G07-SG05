package experienciauno;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear cuenta con saldo inicial válido
            CuentaBancaria cuenta = new CuentaBancaria("2025001234", "Mateo Veas", 250);

            cuenta.depositar(100);
            System.out.println("Saldo después del depósito: " + cuenta.getSaldo());

            cuenta.retirar(50);
            System.out.println("Saldo después del retiro: " + cuenta.getSaldo());

            // Intentar retirar más del saldo disponible
            cuenta.retirar(500);

        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error de saldo insuficiente: " + e.getMessage());
        }
    }
}

