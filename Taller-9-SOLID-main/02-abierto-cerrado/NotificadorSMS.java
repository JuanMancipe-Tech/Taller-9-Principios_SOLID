public class NotificadorSMS {

    // Paso 1: Esta clase se encarga exclusivamente
    // de enviar las notificaciones SMS.
    public void enviar(Vehiculo v, double cobro) {
        System.out.println(
            "SMS a " + v.getPropietario()
            + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $"
            + String.format("%,.0f", cobro)
        );
    }
}
