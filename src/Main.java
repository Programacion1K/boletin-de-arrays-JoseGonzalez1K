import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String ipConPuntos = JOptionPane.showInputDialog(null,"Introducir IP");

        DireccionIP ip = new DireccionIP(ipConPuntos);

        ip.partirIP();
        ip.asignarClase();
        ip.asignarID();
        ip.asignarMascara();
        ip.asignarPrivacidad();
        ip.esID();

        System.out.println(ip.infoIP());

    }
}
