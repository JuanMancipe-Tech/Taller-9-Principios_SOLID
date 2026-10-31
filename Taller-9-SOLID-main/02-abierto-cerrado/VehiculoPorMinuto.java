public class VehiculoPorMinuto extends Vehiculo {

    // Paso 2: Se crea una subclase para representar
    // el modelo de cobro por minutos.
    private double tarifaMinuto;

    public VehiculoPorMinuto(String placa, String propietario,
                             double tarifaMinuto, int minutos) {

        super(placa, propietario);
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    @Override
    public double calcularCobro() {
        return minutos * tarifaMinuto;
    }

    @Override
    public void registrarMinutos(int minutos) {
        this.minutos += minutos;
    }
}
