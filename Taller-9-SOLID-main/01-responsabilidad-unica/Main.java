 public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(
            new Vehiculo(
                "KLM321", "Camila Rojas",
                "MENSUAL", 180000, 0, 0
            )
        );

        vehiculos.add(
            new Vehiculo(
                "XYZ45F", "Andrés Mora",
                "MINUTOS", 0, 80, 1500
            )
        );

        vehiculos.add(
            new Bicicleta(
                "BIC-07", "Valentina Díaz", 40000
            )
        );

        // Paso 1: Main delega el cierre del mes al gestor mediante un único método.
        GestorParqueadero gestor = new GestorParqueadero();

        gestor.cerrarMes(vehiculos);
    }
}
