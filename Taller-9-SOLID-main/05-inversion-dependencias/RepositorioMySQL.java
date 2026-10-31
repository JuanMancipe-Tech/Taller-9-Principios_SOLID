// Paso 5: MySQL implementa la interfaz RepositorioCobros.
public class RepositorioMySQL implements RepositorioCobros {

    public RepositorioMySQL() {
        System.out.println(
            "[MySQL] Conectando a jdbc:mysql://servidor/parqueadero ..."
        );
    }

    @Override
    public void insertar(String placa, double cobro) {
        System.out.println(
            "[MySQL] INSERT INTO cobros VALUES ('"
            + placa + "', " + cobro + ")"
        );
    }
}