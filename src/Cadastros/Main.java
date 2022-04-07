package Cadastros;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //boolean
    public static void horario(boolean d) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date data = new Date();

        //inicio e término do programa

        //Se d == false || caso d seja falso, mostra o inicio do programa
        if (!d) {
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("Início do programa: " + format.format(data));
            System.out.println("------------------------------------");
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Encerramento do programa: " + format.format(data));
            System.out.println("------------------------------------------");
        }
    }

    //Menu principal

    public static String menuMother(){
        Scanner scan = new Scanner(System.in);
        String option;

        System.out.println(" ------------------");
        System.out.println("|| MENU PRINCIPAL ||");
        System.out.println(" ------------------");

        System.out.println("Digite um numero:");
        System.out.println("1 - Cadastro de Funcionarios");
        System.out.println("2 - Cadastro de Produtos");
        System.out.println("3 - Cadastro de Empresas");
        System.out.println("4 - Cadastro de Clientes");
        System.out.println("5 - ENCERRAR");
        System.out.print("(>) ");
        option = scan.nextLine();
        return option;
    }

    public static void body(){

        int enc = 0;

        do{
            switch (menuMother()){

                case "1":
                    CadFunctionary.cod();
                enc = 1;
                break;

                case "2":
                    Products.cod();
                enc = 2;
                break;

                case "3":
                    CadEmpresa.cod();
                enc = 3;
                break;

                case "4":
                    Cliente.cod();
                enc = 4;
                break;

                case "5":

                enc = 5;
                break;

                default:
                    System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!! DIGITE UM DOS NÚMEROS DO MENU !!");
                    System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }while(enc<5);

    }

    public static void main(String[] args){

        horario(false);
        body();
        horario(true);

    }
}