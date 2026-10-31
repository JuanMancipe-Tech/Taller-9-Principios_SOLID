 private RepositorioMySQL repositorio =
            new RepositorioMySQL();

    // Paso 1: El gestor utiliza una clase especializada
    // para exportar los datos a CSV.
    private ExportadorCSV exportador = new ExportadorCSV();

    // Paso 1: El gestor utiliza una clase especializada
    // para enviar las notificaciones SMS.
    private NotificadorSMS notificador = new NotificadorSMS();

    // Se conserva el cálculo del cobro en el gestor.
    public double calcularCobro(Vehiculo v) {

        switch (v.getTipo()) {

            case "MENSUAL":
                return v.getValorMensualidad();

            case "MINUTOS":
                return v.getMinutos() * v.getTarifaMinuto();

            default:
                throw new IllegalArgumentException(
                    "Tipo desconocido: " + v.getTipo()
                );
        }
    }

    // Se conserva la responsabilidad de guardar los cobros.
    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    // Paso 1: Se crea cerrarMes para coordinar
    // el cálculo, almacenamiento, notificación y exportación.
    public void cerrarMes(List<Vehiculo> vehiculos) {

        List<Double> cobros = new ArrayList<>();

        for (Vehiculo v : vehiculos) {

            double cobro = calcularCobro(v);

            cobros.add(cobro);

            guardar(v, cobro);

            // Paso 1: El envío del SMS se delega
            // a la clase NotificadorSMS.
            notificador.enviar(v, cobro);
        }

        // Paso 1: La generación del CSV se delega
        // a la clase ExportadorCSV.
        String csv = exportador.exportar(vehiculos, cobros);

        System.out.println(csv);
    }
}
import java.util.ArrayList;
import java.util.List;
