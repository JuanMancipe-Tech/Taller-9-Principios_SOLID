// Paso 4: VehiculoPorMinuto implementa la capacidad
// de registrar minutos de utilización.
public class VehiculoPorMinuto extends Vehiculo
        implements RegistrablePorTiempo {

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