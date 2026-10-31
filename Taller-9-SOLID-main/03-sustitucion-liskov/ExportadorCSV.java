import java.util.List;

public class ExportadorCSV {

    // Paso 1: Esta clase se encarga exclusivamente
    // de exportar la información a formato CSV.
    public String exportar(List<Vehiculo> vehiculos,
                           List<Double> cobros) {

        StringBuilder sb = new StringBuilder(
            "placa;propietario;cobro\n"
        );

        // Paso 1: Se recorren los vehículos y sus cobros.
        for (int i = 0; i < vehiculos.size(); i++) {

            Vehiculo v = vehiculos.get(i);

            sb.append(v.getPlaca()).append(";")
              .append(v.getPropietario()).append(";")
              .append(cobros.get(i)).append("\n");
        }

        return sb.toString();
    }
}
