/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.File;

/**
 *
 * @author diego
 */
public class Run {
    
    
    public static void main(String args[])
    {

        Controlador c= new Controlador();
        c.CarregarCartoes();
        //c.Test();
        c.ExibirCartoes();
    }
    
}
