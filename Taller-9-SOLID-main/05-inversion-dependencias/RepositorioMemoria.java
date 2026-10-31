import java.util.ArrayList;
import java.util.List;

// Paso 5: Se crea una implementación en memoria
// para almacenar cobros sin utilizar una base de datos.
public class RepositorioMemoria implements RepositorioCobros {

    private List<String> cobros = new ArrayList<>();

    @Override
    public void insertar(String placa, double cobro) {

        String registro = placa + " - $" + cobro;

        cobros.add(registro);

        System.out.println(
            "[Memoria] Cobro guardado: " + registro
        );
    }

    // Paso 5: Se agrega un método para consultar
    // los cobros almacenados durante la ejecución.
    public void mostrarCobros() {

        System.out.println("\n--- COBROS ALMACENADOS ---");

        for (String cobro : cobros) {
            System.out.println(cobro);
        }
    }
}