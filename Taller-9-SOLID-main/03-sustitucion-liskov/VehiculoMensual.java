// Paso 3: Los vehículos mensuales implementan
// la capacidad de acumular puntos.
public class VehiculoMensual extends Vehiculo
        implements AcumuladorPuntos {

    public VehiculoMensual(String placa, String propietario,
                           double valorMensualidad) {

        super(placa, propietario);
        this.valorMensualidad = valorMensualidad;
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }

    @Override
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }
}
