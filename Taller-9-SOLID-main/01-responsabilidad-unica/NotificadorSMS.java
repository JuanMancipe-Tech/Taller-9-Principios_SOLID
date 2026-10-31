// Paso 1: Se crea una clase independiente
    // para asumir exclusivamente el envío de SMS.

    public void enviar(Vehiculo v, double cobro) {

        System.out.println(
            "SMS a " + v.getPropietario()
            + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $"
            + String.format("%,.0f", cobro)
        );
    }
}
import java.util.ArrayList;
import java.util.List;
