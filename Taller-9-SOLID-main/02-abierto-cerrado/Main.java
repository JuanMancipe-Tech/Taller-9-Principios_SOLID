import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        // Vehículo con mensualidad.
        vehiculos.add(
            new VehiculoMensual(
                "KLM321", "Camila Rojas", 180000
            )
        );

        // Vehículo que paga por minutos.
        vehiculos.add(
            new VehiculoPorMinuto(
                "XYZ45F", "Andrés Mora", 1500, 80
            )
        );

        // Bicicleta que paga mensualidad.
        vehiculos.add(
            new Bicicleta(
                "BIC-07", "Valentina Díaz", 40000
            )
        );

        // Paso 2: Se prueba la nueva modalidad
        // de cobro por día sin modificar el gestor.
        vehiculos.add(
            new VehiculoPorDia(
                "ABC123", "Juan Pérez", 25000, 3
            )
        );

        GestorParqueadero gestor = new GestorParqueadero();

        gestor.cerrarMes(vehiculos);
    }
}
