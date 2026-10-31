public class Bicicleta extends VehiculoMensual {

    // Paso 2: La bicicleta utiliza la modalidad
    // de cobro mensual mediante herencia.

    public Bicicleta(String codigo, String propietario,
                     double valorMensualidad) {

        super(codigo, propietario, valorMensualidad);
    }

    // Se conserva temporalmente esta excepción.
    // La corregiremos en el principio LSP.
    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException(
            "Las bicicletas no acumulan puntos de fidelidad"
        );
    }
}
