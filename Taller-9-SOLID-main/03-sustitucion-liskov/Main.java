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

        GestorParqueadero gestor = new GestorParqueadero();

        gestor.cerrarMes(vehiculos);

        // Paso 3: Se demuestra que un vehículo mensual
        // puede calcular puntos de fidelidad.
        VehiculoMensual mensual = new VehiculoMensual(
            "DEF456", "Laura Gómez", 180000
        );

        System.out.println(
            "Puntos del vehículo mensual: "
            + mensual.calcularPuntos()
        );

        // Paso 3: La bicicleta calcula su cobro normalmente,
        // sin tener que implementar un método de puntos.
        Bicicleta bicicleta = new Bicicleta(
            "BIC-08", "Pedro Ruiz", 40000
        );

        System.out.println(
            "Cobro de bicicleta: $" + bicicleta.calcularCobro()
        );
    }
}
