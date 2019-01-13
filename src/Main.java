import javax.swing.*;
import java.util.Arrays;

/**
 * Clase Main se encarga de ejecutar el programa principal
 */
public class Main {
    /**
     * Método main
     *
     * @param args
     */
    public static void main(String[] args) {

        int salir;

        do {        //Aquí empieza el bucle que ejecuta las distintas opciones del programa

            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
                    "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Comparar IPs", "Comprobar Red", "Generar IPs", "Salir"}, "");


            if (seleccion == 0) {       //Esta selección, se encarga de mostrar informacion de dos IPs generadas por el usuario

                String ipConPuntos = JOptionPane.showInputDialog(null, "Introducir IP");

                DireccionIP ip = new DireccionIP(ipConPuntos);

                ip.partirIP();
                ip.asignarClase();
                ip.asignarID();
                ip.asignarMascara();
                ip.asignarPrivacidad();
                ip.esID();

                System.out.println(ip.infoIP() + "\n" + "-------------------");


                JOptionPane.showMessageDialog(null, ip.infoIP());

                String ipConPuntos2 = JOptionPane.showInputDialog(null, "Introducir otra IP");

                DireccionIP ip2 = new DireccionIP(ipConPuntos2);

                ip2.partirIP();
                ip2.asignarClase();
                ip2.asignarID();
                ip2.asignarMascara();
                ip2.asignarPrivacidad();
                ip2.esID();

                System.out.println(ip2.infoIP() + "\n" + "-------------------");

                JOptionPane.showMessageDialog(null, ip2.infoIP());

                System.out.println(dosIPEnRed(ip, ip2));        //Muestra si las dos IPs se encuentran en la misma red

            }

            if (seleccion == 1) {       //Con esta selección, se introducen IPs en un array para ser comprobadas luego

                int acumuladorArray = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Nº de IP a introducir?"));

                String[] variasIP = new String[acumuladorArray];

                for (int i = 0; i < acumuladorArray; i++) {

                    String ipDeArray = JOptionPane.showInputDialog(null, "Introducir IP en el array");

                    variasIP[i] = new String(ipDeArray);

                }

                System.out.println("\n" + variasIPEnRed(variasIP));     //Muestra si las IPs están en la misma red

                JOptionPane.showMessageDialog(null, variasIPEnRed(variasIP));

            }


            if (seleccion == 2) {       //Con esta selección, se introduce una ID de red para después generar IPs

                String red = JOptionPane.showInputDialog(null, "Introducir una ID de red");

                JOptionPane.showMessageDialog(null, generarIPs(red));       //Muestra las IPs generadas

            }

            if (seleccion == 3) {       //La última selección, se usa para salir

                salir = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro que deseas salir?",
                        "Salir", JOptionPane.YES_NO_OPTION);
                if (salir == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }

        } while (true);


    }

    /**
     * Método que se encarga de comprobar si dos IPs se encuentran en la misma red
     *
     * @param ip
     * @param ip2
     * @return String si pertenece o no pertenece
     */
    public static String dosIPEnRed(DireccionIP ip, DireccionIP ip2) {

        String pertenece;

        if (ip.getIdDeRed().equals(ip2.getIdDeRed())) {
            pertenece = "Pertenecen a la misma red";
        } else {
            pertenece = "No pertenecen a la misma red";
        }

        return pertenece;
    }

    /**
     * Método que se encarga de comprobar que las IPs del array pertenecen a la misma red
     *
     * @param variasIP
     * @return String si pertenece o no
     */
    public static String variasIPEnRed(String variasIP[]) {

        String ipConPuntos;
        String ipConPuntos2;
        String pertenece = "Pertenecen a la misma red";
        String nopertenece = "No pertenecen a la misma red";

        for (int i = 0; i < variasIP.length; i++) {

            ipConPuntos = variasIP[i];

            DireccionIP ip = new DireccionIP(ipConPuntos);

            ip.partirIP();
            ip.asignarID();


            if (i >= 1) {

                ipConPuntos2 = variasIP[i - 1];

                DireccionIP ip2 = new DireccionIP(ipConPuntos2);

                ip2.partirIP();
                ip2.asignarID();

                if (ip.getIdDeRed().equals(ip2.getIdDeRed())) {
                    pertenece = "Pertenecen a la misma red";
                } else {
                    return nopertenece;
                }

            }


        }

        return pertenece;
    }

    /**
     * Método que se encarga de generar tantas IPs como el usuario desee a partir de una ID generada también por el usuario
     *
     * @param red
     * @return Array con las IPs
     */
    public static String[] generarIPs(String red) {

        int numeroIPsAGenerar = Integer.parseInt(JOptionPane.showInputDialog("Nº de IPs a generar"));

        String[] arrayDeIPs = new String[numeroIPsAGenerar];

        String redAIntroducir = red;


        for (int i = 0; i < numeroIPsAGenerar; i++) {

            redAIntroducir = redAIntroducir.replaceAll(redAIntroducir.substring(redAIntroducir.lastIndexOf('.') + 1), Integer.toString(i + 1));

            arrayDeIPs[i] = new String(redAIntroducir);

            redAIntroducir = red;
        }


        return arrayDeIPs;
    }

}
