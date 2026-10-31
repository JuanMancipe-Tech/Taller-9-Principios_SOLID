import java.util.ArrayList;
import java.util.List;

public class GestorParqueadero {

    private RepositorioMySQL repositorio =
            new RepositorioMySQL();

    private ExportadorCSV exportador = new ExportadorCSV();

    private NotificadorSMS notificador = new NotificadorSMS();

    // Paso 2: Se elimina el switch sobre el tipo de vehículo.
    // El cálculo se delega al método polimórfico.
    public double calcularCobro(Vehiculo v) {
        return v.calcularCobro();
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    // Se conserva el método cerrarMes del principio SRP.
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
