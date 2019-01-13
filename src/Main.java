import javax.swing.*;
import java.util.Arrays;

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

        String ipConPuntos2 = JOptionPane.showInputDialog(null,"Introducir otra IP");

        DireccionIP ip2 = new DireccionIP(ipConPuntos2);

        ip2.partirIP();
        ip2.asignarID();

        System.out.println(dosIPEnRed(ip,ip2));

        int acumuladorArray=Integer.parseInt(JOptionPane.showInputDialog(null,"¿Nº de IP a introducir?"));

        String [] variasIP = new String[acumuladorArray];

        for (int i = 0; i < acumuladorArray; i++) {

            String ipDeArray = JOptionPane.showInputDialog(null,"Introducir IP en el array");

            variasIP[i] = new String (ipDeArray);

        }

        System.out.println("-------------------"+"\n"+variasIPEnRed(variasIP));



        String red = JOptionPane.showInputDialog(null,"Introducir una ID de red");

        System.out.println(Arrays.toString(generarIPs(red)));




    }

    public static String dosIPEnRed(DireccionIP ip, DireccionIP ip2){

        String pertenece;

        if (ip.getIdDeRed().equals(ip2.getIdDeRed())){
            pertenece="Pertenecen a la misma red";
        }else{
            pertenece="No pertenecen a la misma red";
        }

        return pertenece;
    }

    public static String variasIPEnRed (String variasIP[]){

        String ipConPuntos;
        String ipConPuntos2;
        String pertenece="Pertenecen a la misma red";
        String nopertenece="No pertenecen a la misma red";

        for (int i = 0; i < variasIP.length; i++) {

            ipConPuntos=variasIP[i];

            DireccionIP ip = new DireccionIP(ipConPuntos);


            ip.partirIP();
            ip.asignarID();


            if (i >= 1){

                ipConPuntos2 = variasIP[i-1];

                DireccionIP ip2 = new DireccionIP(ipConPuntos2);

                ip2.partirIP();
                ip2.asignarID();

                if (ip.getIdDeRed().equals(ip2.getIdDeRed())){
                    pertenece="Pertenecen a la misma red";
                }else{
                    return nopertenece;
                }

            }


        }

        return pertenece;
    }

    public static String [] generarIPs (String red){

        int numeroIPsAGenerar = Integer.parseInt(JOptionPane.showInputDialog("Nº de IPs a generar"));

        String [] arrayDeIPs = new String[numeroIPsAGenerar];

        String redAIntroducir=red;


        for (int i = 0; i < numeroIPsAGenerar; i++) {

            redAIntroducir=redAIntroducir.replaceAll(redAIntroducir.substring(redAIntroducir.lastIndexOf('.')+1),Integer.toString(i+1));

            arrayDeIPs[i] = new String(redAIntroducir);

            redAIntroducir=red;
        }


        return arrayDeIPs;
    }



}
