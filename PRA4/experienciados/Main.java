package experienciados;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear dos cuentas con saldo inicial
            CuentaBancaria cuenta1 = new CuentaBancaria("2025001256", "Eloisa Borja", 300);
            CuentaBancaria cuenta2 = new CuentaBancaria("2025001485", "Alberto Perez", 100);

            // 1. Transferencia válida
            cuenta1.transferir(cuenta2, 200);
            System.out.println("Transferencia realizada con éxito.");
            System.out.println("Saldo cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo cuenta2: " + cuenta2.getSaldo());

            // 2. Transferencia a una cuenta inexistente
            cuenta1.transferir(null, 50); // debería lanzar CuentaNoEncontradaException

            // 3. Intento de cerrar una cuenta con saldo
            cuenta2.cerrarCuenta(); // debería lanzar SaldoNoCeroException

        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SaldoNoCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}