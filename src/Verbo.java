import java.util.Scanner;

public class Verbo {
    String [] verbo= new String[3];
    boolean [] acierto= new boolean[3];

    public Verbo (){

    }
    public Verbo (String verb, String pastSimple, String pastParticiple){

        this.verbo[1] = pastSimple;
        this.verbo[2] = pastParticiple;
        this.verbo[0] = verb;
    }

    public void setAcierto(int num,boolean acierto) {
        this.acierto[num] = acierto;
    }
    public boolean getAcierto(int num) {
        return this.acierto[num];
    }
    public void setVerbo(int num,String verbo) {
        this.verbo[num] = verbo;
    }
    public String getVerbo(int num) {
        return this.verbo[num];
    }


    static public Verbo trocear(String linea){

        String[] split = linea.split(" ", -1);

        Verbo verbo=new Verbo(split[0],split[1],split[2]);
    return verbo;
    }




    @Override
    public String toString() {
        return "Verbo{" +
                "verb='" + verbo[0] + '\'' +
                ", '" + verbo[1] + '\'' +
                ", '" + verbo[2] + '\'' +
                '}';
    }
    public void preguntar(){


        int numEleccion;
        //numEleccion= (int) (Math.random()*3);
        numEleccion=0;
        int cambiador=(int) (1+(Math.random()*2));
        int numParaPregunta=( numEleccion+cambiador)%3;

        if (getAcierto(numParaPregunta)){

            cambiador=(cambiador*2)%3;
            numParaPregunta=( numEleccion+cambiador)%3;

            if (getAcierto(numParaPregunta)){
                int aux=numParaPregunta;
                numParaPregunta=numEleccion;
                numEleccion=aux;

            }
        }

        String dado,pregunta;
        if (numEleccion==0){
            dado="verb";

        }else if (numEleccion==1){
            dado="past simple";
        }else {
            dado="past participle";
        }

        if (numParaPregunta==0){
            pregunta="verb";

        }else if (numParaPregunta==1){
            pregunta="past simple";
        }else {
            pregunta="past participle";
        }
        System.out.println("Dandote el "+dado+" \'"+getVerbo(numEleccion)+"\'");
        System.out.println("Pon el "+pregunta);


        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();
        if (respuesta.equals(getVerbo(numParaPregunta))){
            setAcierto(numParaPregunta,true);
            System.out.println("muy bien :)");
            new Sonido().ReproducirSonido("D:\\Portal\\Universidad\\Segundo\\POO\\untitled6\\src\\musica\\win.wav");
        }else {
            System.out.println("Muy Mal :(");
            System.out.println("La respuesta correcta era: "+getVerbo(numParaPregunta));
            new Sonido().ReproducirSonido("D:\\Portal\\Universidad\\Segundo\\POO\\untitled6\\src\\musica\\wrong.wav");

            System.out.println(toString());

        }


    }
    public boolean estaResuelto(){
        return acierto[1]&&acierto[2];
    }

}
