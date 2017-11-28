/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Run {
    
    public static void main(String args[])
    {
        System.out.println("Programa decorador de Tickets");
        System.out.println("-----------------------------\n");
        Controlador c= new Controlador();
        
        int opcao=0;// Valor digitado pelo usuário
        
        boolean continuar=true;
        do{
            c.ExibirMenu();//Mostra opções disponíveis pro usuário
            System.out.print("Digite o opção desejada: ");//Pede pro usuário digitar o que deseja
            opcao=PedirDigitacaoUsuario();
            
            switch(opcao)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    continuar=false;
                    break;
            }
        }while(continuar);
        
        
    }
    
    /***
     * Pede para que o usuário digite algum número entre os valores permitidos
     * @return 
     */
    public static int PedirDigitacaoUsuario()
    {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        int opcao=-1;
        boolean opcaoInvalida=true;
        
        
        
        while(opcaoInvalida)
        {
            entrada=scanner.next();
            try
            {
                opcao=Integer.parseInt(entrada);
            }
            catch(NumberFormatException ex)
            {
                opcao=-1;
            }
            
            if(opcao>=0 && opcao<=2)// Verifica se o que foi digitado é válido
            {
                opcaoInvalida=false;
                
            }else
            {
                opcaoInvalida=true;
                System.out.print("Opção inválida,por favor digite novamente: ");
            }
                
        }
        
        return opcao;
    }
    
}
    
    
 
