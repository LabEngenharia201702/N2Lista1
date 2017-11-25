/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Leitor {
    /***
     * Retorna um lista de Strings. Cada String corresponde a uma linha.
     * @param nome
     * @return 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    static public List<String> listar(String nome) 
    {
        List<String> lista= new ArrayList();
        try
        {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            String texto= lerArq.readLine();
            while(texto!=null)
        {
            lista.add(texto);
            texto= lerArq.readLine();
        }
            arq.close();
        }catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
         return lista;
    }
    private Leitor(){}

    
}
