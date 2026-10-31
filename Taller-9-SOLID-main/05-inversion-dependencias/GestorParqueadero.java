import java.util.ArrayList;
import java.util.List;

public class GestorParqueadero {

    // Paso 5: El gestor depende de una interfaz
    // y no directamente de RepositorioMySQL.
    private RepositorioCobros repositorio;

    private ExportadorCSV exportador = new ExportadorCSV();
    private NotificadorSMS notificador = new NotificadorSMS();

    // Paso 5: El repositorio se recibe mediante
    // el constructor (inyección de dependencias).
    public GestorParqueadero(RepositorioCobros repositorio) {
        this.repositorio = repositorio;
    }

    public double calcularCobro(Vehiculo v) {
        return v.calcularCobro();
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    public void cerrarMes(List<Vehiculo> vehiculos) {

        List<Double> cobros = new ArrayList<>();

        for (Vehiculo v : vehiculos) {

            double cobro = calcularCobro(v);

            cobros.add(cobro);

            guardar(v, cobro);

            notificador.enviar(v, cobro);
        }

        String csv = exportador.exportar(vehiculos, cobros);

        System.out.println(csv);
    }
}
