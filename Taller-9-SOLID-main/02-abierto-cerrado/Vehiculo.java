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

    // Paso 2: El cálculo del cobro se vuelve abstracto.
    // Cada subclase define su propia modalidad.
    public abstract double calcularCobro();

    // Se conserva temporalmente para corregir LSP después.
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }

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
