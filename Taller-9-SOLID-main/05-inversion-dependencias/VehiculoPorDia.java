public class VehiculoPorDia extends Vehiculo {

    // Paso 2: Se agrega una nueva modalidad de cobro
    // mediante una subclase, sin modificar las existentes.
    private double tarifaDia;
    private int dias;

    public VehiculoPorDia(String placa, String propietario,
                          double tarifaDia, int dias) {

        super(placa, propietario);
        this.tarifaDia = tarifaDia;
        this.dias = dias;
    }

    @Override
    public double calcularCobro() {
        return tarifaDia * dias;
    }
}
