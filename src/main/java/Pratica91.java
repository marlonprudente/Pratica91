
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica91 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String os = System.getProperty("os.name");
        Runtime rt = Runtime.getRuntime();
        Timer timer = new Timer();
        String cmd;
        Process editor;
        
        System.out.println("OS:" + os);
        System.out.println("Nro Process: " + rt.availableProcessors());
        System.out.println("Memoria Total: " + rt.totalMemory()/(1024*2));
        System.out.println("Memoria Livre: " + rt.freeMemory()/(1024*2));
        System.out.println("Max Memory to VM: " + rt.maxMemory()/(1024*2));
        
        if(os.toLowerCase().contains("windows")){
            cmd = "notepad teste.txt";
        }
        else{
            cmd = "";
        }
        editor = rt.exec(cmd);
        
        editor.waitFor();
        File file = new File("teste.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        if (file.exists()) {
            System.out.println("Arquivo " + file.getAbsolutePath() + " existe.");
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            reader.close();
            editor.destroy();
        } else {
            System.out.println("Arquivo não foi criado.");
        }
    }
        
    }

