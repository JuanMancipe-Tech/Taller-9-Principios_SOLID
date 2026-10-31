// Paso 4: Vehiculo implementa únicamente las interfaces
// correspondientes a sus capacidades.
public abstract class Vehiculo implements Asegurable, Lavable {

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
    public double calcularSeguro() {
        return valorMensualidad * 0.02;
    }

    @Override
    public void solicitarLavados(int cantidad) {
        this.lavados += cantidad;
    }
}