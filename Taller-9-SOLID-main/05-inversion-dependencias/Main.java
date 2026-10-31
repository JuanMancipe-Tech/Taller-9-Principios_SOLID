import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(
            new VehiculoMensual("KLM321", "Camila Rojas", 180000)
        );

        vehiculos.add(
            new VehiculoPorMinuto("XYZ45F", "Andrés Mora", 1500, 80)
        );

        vehiculos.add(
            new Bicicleta("BIC-07", "Valentina Díaz", 40000)
        );

        vehiculos.add(
            new VehiculoPorDia("ABC123", "Juan Pérez", 25000, 3)
        );

        // Paso 5: Se selecciona el repositorio en memoria.
        RepositorioMemoria repositorio = new RepositorioMemoria();

        // Paso 5: Se inyecta el repositorio al gestor.
        GestorParqueadero gestor = new GestorParqueadero(repositorio);

        gestor.cerrarMes(vehiculos);

        // Paso 5: Se muestran los cobros almacenados.
        repositorio.mostrarCobros();
    }
}
