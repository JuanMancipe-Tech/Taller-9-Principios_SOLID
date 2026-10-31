public class VehiculoMensual extends Vehiculo {
  
    // Paso 2: Se crea una subclase para representar
    // el modelo de cobro mensual.
    protected double valorMensualidad;

    public VehiculoMensual(String placa, String propietario,
                           double valorMensualidad) {

        super(placa, propietario);
        this.valorMensualidad = valorMensualidad;
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }

    // Se conserva el cálculo de puntos para los
    // vehículos que sí pueden acumular fidelidad.
    @Override
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }
}
