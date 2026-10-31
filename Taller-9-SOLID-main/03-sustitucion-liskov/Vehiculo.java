// Paso 3: Se elimina calcularPuntos() de Vehiculo,
// porque no todos los vehículos acumulan puntos.
public abstract class Vehiculo implements ServicioParqueadero {

    protected String placa;
    protected String propietario;
    protected double valorMensualidad;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario) {
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public abstract double calcularCobro();

    @Override
    public void registrarMinutos(int minutos) {
        this.minutos += minutos;
    }

    @Override
    public double calcularSeguro() {
        return valorMensualidad * 0.02;
    }

    @Override
    public void solicitarLavados(int cantidad) {
        this.lavados += cantidad;
    }
}
