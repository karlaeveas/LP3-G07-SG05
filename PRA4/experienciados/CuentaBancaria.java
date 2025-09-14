package experienciados;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo; // protected para que pueda heredarse en Experiencia 3

    // Constructor con validación
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar (Experiencia 1B)
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        saldo += monto;
    }

    // Método para retirar (Experiencia 1B)
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
    }

    // Método para transferir (Experiencia 2B)
    public void transferir(CuentaBancaria destino, double monto)
            throws SaldoInsuficienteException, CuentaNoEncontradaException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }
        this.retirar(monto); // Puede lanzar SaldoInsuficienteException
        destino.depositar(monto);
    }

    // Método para cerrar cuenta (Experiencia 2B)
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) {
            throw new SaldoNoCeroException("La cuenta no puede cerrarse porque aún tiene saldo.");
        }
        System.out.println("Cuenta cerrada exitosamente.");
    }

    // Método para consultar saldo
    public double getSaldo() {
        return saldo;
    }

    // Método opcional para mostrar información de la cuenta
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
