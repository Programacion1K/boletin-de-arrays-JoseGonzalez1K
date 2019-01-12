public class DireccionIP {

    String ipConPuntos;

    int primerByte;
    int segundoByte;
    int tercerByte;
    int cuartoByte;

    int [] arrayIP = new int [4];

    public DireccionIP (String ipConPuntos){

        this.ipConPuntos = ipConPuntos;

    }

    public DireccionIP (int primerByte, int segundoByte, int tercerByte, int cuartoByte){

        this.primerByte = primerByte;
        this.segundoByte = segundoByte;
        this.tercerByte = tercerByte;
        this.cuartoByte = cuartoByte;

    }

    public DireccionIP (int [] arrayIP){

        this.arrayIP = arrayIP;
    }
}
