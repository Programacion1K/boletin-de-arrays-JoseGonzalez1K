public class DireccionIP {

    private String ipConPuntos;
    private String idDeRed;
    private String mascara;

    private int primerByteManual;
    private int segundoByteManual;
    private int tercerByteManual;
    private int cuartoByteManual;

    private int primerByte;
    private int segundoByte;
    private int tercerByte;
    private int cuartoByte;

    int [] arrayIP = new int [4];

    private char clase;

    private String privacidad;
    private String esID;

    public DireccionIP (String ipConPuntos){
        this.ipConPuntos = ipConPuntos;
    }

    public DireccionIP (int primerByteManual, int segundoByteManual, int tercerByteManual, int cuartoByteManual){

        this.primerByteManual = primerByteManual;
        this.segundoByteManual = segundoByteManual;
        this.tercerByteManual = tercerByteManual;
        this.cuartoByteManual = cuartoByteManual;

    }

    public DireccionIP (int [] arrayIP){
        this.arrayIP = arrayIP;
    }

    public  String getIpConPuntos() {
        return ipConPuntos;
    }

    public String getIdDeRed() {
        return idDeRed;
    }

    public void setIdDeRed(String idDeRed) {
        this.idDeRed = idDeRed;
    }

    public char getClase() {
        return clase;
    }

    public void setClase(char clase) {
        this.clase = clase;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public String getEsID() {
        return esID;
    }

    public void setEsID(String esID) {
        this.esID = esID;
    }

    public int getPrimerByte() {
        return primerByte;
    }

    public void setPrimerByte(int primerByte) {
        this.primerByte = primerByte;
    }

    public int getSegundoByte() {
        return segundoByte;
    }

    public void setSegundoByte(int segundoByte) {
        this.segundoByte = segundoByte;
    }

    public int getTercerByte() {
        return tercerByte;
    }

    public void setTercerByte(int tercerByte) {
        this.tercerByte = tercerByte;
    }

    public int getCuartoByte() {
        return cuartoByte;
    }

    public void setCuartoByte(int cuartoByte) {
        this.cuartoByte = cuartoByte;
    }

    public String infoIP (){

        String informacionIP = "Dirección IP: "+getIpConPuntos()+"\n"+
                                "ID de red: "+getIdDeRed()+"\n"+
                                "Máscara de red: "+getMascara()+"\n"+
                                "Clase: "+getClase()+"\n"+
                                "Privacidad: "+getPrivacidad()+"\n"+
                                "¿Es ID de la red?: "+getEsID();

        return informacionIP;
    }

    public void partirIP (){

        String ip=ipConPuntos;

        int primero = Integer.parseInt(ip.substring(0,ip.indexOf('.')));
        setPrimerByte(primero);

        String sinElPrimero = ip.substring(ip.indexOf('.')+1,ip.length());

        int segundo = Integer.parseInt(sinElPrimero.substring(0,sinElPrimero.indexOf('.')));
        setSegundoByte(segundo);

        String sinElSegundo = sinElPrimero.substring(sinElPrimero.indexOf('.')+1,sinElPrimero.length());

        int tercero = Integer.parseInt(sinElSegundo.substring(0,sinElSegundo.indexOf('.')));
        setTercerByte(tercero);

        int cuarto = Integer.parseInt(sinElSegundo.substring(sinElSegundo.indexOf('.')+1));
        setCuartoByte(cuarto);

    }

    public void asignarClase (){

        if (getPrimerByte()>=0 && getPrimerByte()<=127){
            setClase('A');
        }

        if (getPrimerByte()>=128 && getPrimerByte()<=191){
            setClase('B');
        }

        if (getPrimerByte()>=192 && getPrimerByte()<=223){
            setClase('C');
        }

        if (getSegundoByte()>=255){
            setClase(' ');
        }

        if (getTercerByte()>=255){
            setClase(' ');
        }

        if (getCuartoByte()>=255){
            setClase(' ');
        }

    }

    public void asignarID (){

        String id = getIpConPuntos();

        String ipSinUltimo=id.substring(0,id.lastIndexOf('.')+1);

        String ultimo=id.substring(id.lastIndexOf('.')+1);

        ultimo="0";

        String idDefinitiva = ipSinUltimo+ultimo;

        setIdDeRed(idDefinitiva);

    }

    public void asignarMascara (){

        if (getClase()=='A'){
            setMascara("255.0.0.0");
        }

        if (getClase()=='B'){
            setMascara("255.255.0.0");
        }

        if (getClase()=='C'){
            setMascara("255.255.255.0");
        }

    }

    public void asignarPrivacidad (){

        if (getPrimerByte()>=0 && getPrimerByte()<=10){

            if (getSegundoByte() >=0 && getSegundoByte()<=255){

                if (getTercerByte() >=0 && getTercerByte()<=255){

                    if (getCuartoByte() >=0 && getCuartoByte()<=255){
                        setPrivacidad("Pública");
                    }

                }
            }
        }

        if (getPrimerByte()>=16 && getPrimerByte()<=172){

            if (getSegundoByte() >=0 && getSegundoByte()<=31){

                if (getTercerByte() >=0 && getTercerByte()<=255){

                    if (getCuartoByte() >=0 && getCuartoByte()<=255){
                        setPrivacidad("Pública");
                    }

                }
            }
        }

        if (getPrimerByte()>=168 && getPrimerByte()<=192){

            if (getSegundoByte() >=0 && getSegundoByte()<=168){

                if (getTercerByte() >=0 && getTercerByte()<=255){

                    if (getCuartoByte() >=0 && getCuartoByte()<=255){
                        setPrivacidad("Pública");
                    }

                }
            }
        }

        if (getPrimerByte()>=11 && getPrimerByte()<16){

            if (getSegundoByte() >=0 && getSegundoByte()<=255){

                if (getTercerByte() >=0 && getTercerByte()<=255){

                    if (getCuartoByte() >=0 && getCuartoByte()<=255){
                        setPrivacidad("Privada");
                    }

                }
            }
        }

        if (getPrimerByte()>=168 && getPrimerByte()<172){

            if (getSegundoByte() >=0 && getSegundoByte()<=255){

                if (getTercerByte() >=0 && getTercerByte()<=255){

                    if (getCuartoByte() >=0 && getCuartoByte()<=255){
                        setPrivacidad("Privada");
                    }

                }
            }
        }

    }

    public void esID (){

        if (ipConPuntos.equals(idDeRed)){

            setEsID("Sí");

        }else {
            setEsID("No");
        }

    }


}
