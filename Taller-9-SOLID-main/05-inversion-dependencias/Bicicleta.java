// Paso 3: La bicicleta hereda directamente de Vehiculo.
// No implementa AcumuladorPuntos porque no acumula puntos.
public class Bicicleta extends Vehiculo {

    public Bicicleta(String codigo, String propietario,
                     double valorMensualidad) {

        super(codigo, propietario);
        this.valorMensualidad = valorMensualidad;
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }
}
