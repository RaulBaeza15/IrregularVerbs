import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IrregularVerbs {
    ArrayList<Verbo> lista;

    public IrregularVerbs(){
        lista=new ArrayList<>(124);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;


        List<String> lista2 = Arrays.asList(
                "arise arose arisen" ,
                        "be was/were been" ,
                        "beat beat beaten" ,
                        "become became become" ,
                        "begin began begun" ,
                        "bend bent bent" ,
                        "bite bit bitten" ,
                        "bleed bled bled" ,
                        "blow blew blown" ,
                        "break broke broken" ,
                        "bring brought brought" ,
                        "broadcast broadcast broadcast" ,
                        "build built built" ,
                        "burn burnt burnt" ,
                        "burst burst burst" ,
                        "buy bought bought" ,
                        "catch caught caught" ,
                        "choose chose chosen" ,
                        "come came come" ,
                        "cost cost cost" ,
                        "creep crept crept" ,
                        "cut cut cut" ,
                        "deal dealt dealt" ,
                        "dig dug dug" ,
                        "do did done" ,
                        "draw drew drawn" ,
                        "dream dreamt dreamt" ,
                        "drink drank drunk" ,
                        "drive drove driven" ,
                        "eat ate eaten" ,
                        "fall fell fallen" ,
                        "feed fed fed" ,
                        "feel felt felt" ,
                        "fight fought fought" ,
                        "find found found" ,
                        "fly flew flown" ,
                        "forbid forbade forbidden" ,
                        "forget forgot forgotten" ,
                        "forgive forgave forgiven" ,
                        "freeze froze frozen" ,
                        "get got got" ,
                        "give gave given" ,
                        "go went gone" ,
                        "grow grew grown" ,
                        "hang hung hung" ,
                        "have had had" ,
                        "hear heard heard" ,
                        "hide hid hidden" ,
                        "hit hit hit" ,
                        "hold held held" ,
                        "hurt hurt hurt" ,
                        "keep kept kept" ,
                        "kneel knelt knelt" ,
                        "know knew known" ,
                        "lay laid laid" ,
                        "lead led led" ,
                        "lean leant leant" ,
                        "learn learnt learnt" ,
                        "leave left left" ,
                        "lend lent lent" ,
                        "let let let" ,
                        "lie lay lain" ,
                        "light lit lit" ,
                        "lose lost lost" ,
                        "make made made" ,
                        "mean meant meant" ,
                        "meet met met" ,
                        "pay paid paid" ,
                        "put put put" ,
                        "read read read" ,
                        "ride rode ridden" ,
                        "ring rang rung" ,
                        "rise rose risen" ,
                        "run ran run" ,
                        "say said said" ,
                        "see saw seen" ,
                        "sell sold sold" ,
                        "send sent sent" ,
                        "set set set" ,
                        "sew sewed sewn" ,
                        "shake shook shaken" ,
                        "shine shone shone" ,
                        "shoot shot shot" ,
                        "show showed shown" ,
                        "shrink shrank shrunk" ,
                        "shut shut shut" ,
                        "sing sang sung" ,
                        "sink sank sunk" ,
                        "sit sat sat" ,
                        "sleep slept slept" ,
                        "slide slid slid" ,
                        "smell smelt smelt" ,
                        "sow sowed sown" ,
                        "speak spoke spoken" ,
                        "spell spelt/spelled spelt/spelled" ,
                        "spend spent spent" ,
                        "spill spilt spilt" ,
                        "spit spat spat" ,
                        "split split split" ,
                        "spoil spoilt spoilt" ,
                        "spread spread spread" ,
                        "spring sprang sprung" ,
                        "stand stood stood" ,
                        "steal stole stolen" ,
                        "stick stuck stuck" ,
                        "sting stung stung" ,
                        "strike struck struck" ,
                        "swear swore sworn" ,
                        "sweep swept swept" ,
                        "swell swelled swollen" ,
                        "swim swam swum" ,
                        "swing swung swung" ,
                        "take took taken" ,
                        "teach taught taught" ,
                        "tear tore torn" ,
                        "tell told told" ,
                        "think thought thought" ,
                        "throw threw thrown" ,
                        "understand understood understood" ,
                        "wake woke woken" ,
                        "wear wore worn" ,
                        "weep wept wept" ,
                        "win won won" ,
                        "write wrote written"
                
                
                
                
        );



        for (String linea:lista2) {
            lista.add(Verbo.trocear(linea));
        }






    }

    @Override
    public String toString() {
        return "IrregularVerbs{" +
                "lista=" + desenrrollarArray() +
                '}';
    }
    public String desenrrollarArray(){

        String resultado="";
        for (Verbo verbo:lista) {
            resultado=resultado+"\n"+verbo;
        }
        return resultado;
    }
    public Verbo randomVerb(int num){
        Verbo verbo = lista.get(num);
        return verbo;
    }
    public void juego(){
        boolean exito = false;
        Verbo verbo;
        int posicion;

        while (!exito){
            posicion=(int) (Math.random() * lista.size());
           //posicion=0;
            verbo=lista.get(posicion);
            verbo.preguntar();

            lista.remove(posicion);
            if (!verbo.estaResuelto()){

                lista.add(posicion,verbo);
            }else{
                System.out.println("Muy Bien, te has quitado uno :)");
                new Sonido().ReproducirSonido("D:\\Portal\\Universidad\\Segundo\\POO\\untitled6\\src\\musica\\merry.wav");
            }
            System.out.println();
            if(lista.size()==0){
                exito   =true;
            }
        }
    }


}
