package Cadastros;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Products {

        //Menu

        public static String menu() {
            Scanner scan = new Scanner(System.in);
            String option;

            System.out.println(" ------------------------");
            System.out.println("|| Cadastro de Produtos ||");
            System.out.println(" ------------------------");

            System.out.println("Digite um numero:");
            System.out.println("1 - Registrar produto");
            System.out.println("2 - Listar produtos(s)");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Deletar produto");
            System.out.println("5 - Mostrar dados das empresas");
            System.out.println("6 - RETORNAR AO MENU ANTERIOR");
            System.out.print("(>) ");
            option = scan.nextLine();
            return option;
        }

        public static void cod() {

            Scanner scan = new Scanner(System.in);
            int fim = 0;
            int i = 0;
            int atu;
            int del;
            int id;
            char confirm;
            String nome;
            double preco;
            String[][] produtos = new String[100][10];
            char empresa;
            String ep;
            //char ep;

            do {
                switch(menu()) {

                    //Opção 1, usuário registra o funcionário!

                    case "1":
                        System.out.println("Nome do Produto: ");
                        System.out.print("(>) ");
                        nome = scan.nextLine();
                        System.out.println("Empresa: [A] ou [B]");
                        System.out.print("(>) ");
                        ep = scan.nextLine();
                        System.out.println("Preço: ");
                        System.out.print("(>) R$");
                        preco = scan.nextDouble();




                        id = i;
                        produtos[i][0] = "ID: " + Integer.toString(id);
                        produtos[i][1] = "Nome do Produto: " + nome;
                        produtos[i][2] = "Preço: R$" + preco;
                        produtos[i][3] = "Empresa: " + ep;
                        produtos[i][4] = "------------------------";


                        i++;
                        fim = 1;

                        System.out.println(" --------------------------");
                        System.out.println("|| REGISTRADO COM SUCESSO ||");
                        System.out.println(" --------------------------");
                        break;

                    //Opção 2, usuário recebe a lista de funcionários registrados!

                    case "2":

                        System.out.println(" -------------------------");
                        System.out.println("|| LISTA DE PRODUTOS ||");
                        System.out.println(" -------------------------");
                        System.out.println(" -------------------------");

                        for (String[] produto : produtos) {
                            for (int l = 0; l < produtos[l].length; l++) {
                                if (produto[l] != null) {
                                    if (l < 5) {
                                        System.out.println("- " + produto[l]);
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                        System.out.println("\n");
                        fim = 2;
                        break;

                    //Opção 3, usuário atualiza algum funcionário, chamando pelo seu ID!

                    case "3":
                        System.out.println("Informe o ID:");
                        System.out.print("(>) ");
                        atu = scan.nextInt();
                        scan.nextLine();
                        if (atu < i) {
                            System.out.println("Nome do Produto: ");
                            System.out.print("(>) ");
                            nome = scan.nextLine();
                            System.out.println("Empresa: [A] ou [B]");
                            System.out.print("(>) ");
                            ep = scan.nextLine();
                            System.out.println("Preço: ");
                            System.out.print("(>) R$");
                            preco = scan.nextDouble();


                            produtos[atu][0] = "ID: " + Integer.toString(atu);
                            produtos[atu][1] = "Nome do Produto: " + nome;
                            produtos[atu][2] = "Preço: R$" + preco;
                            produtos[atu][3] = "Empresa: " + ep;

                            System.out.println(" ---------------------------");
                            System.out.println("|| ATUALIZADO COM SUCESSO! ||");
                            System.out.println(" ---------------------------");
                        }
                        else {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("!!! ID INEXISTENTE !!!");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                        }
                        fim = 3;
                        break;

                    //Opção 4, usuário deleta algum funcionário do "banco"!

                    case "4":
                        System.out.println("Deseja DELETAR algum produto? [S]->SIM || [N]->NÃO");
                        confirm = scan.next().charAt(0);
                        if (confirm == 's' || confirm == 'S') {
                            System.out.println("Informe o ID: ");
                            System.out.print("(>) ");
                            del = scan.nextInt();
                            scan.nextLine();
                            if (del < i && produtos[del][0] != null) {
                                produtos[del][0] = null;
                                produtos[del][1] = null;
                                produtos[del][2] = null;
                                produtos[del][3] = null;
                                produtos[del][4] = null;
                                produtos[del][5] = null;
                                produtos[del][6] = null;
                                produtos[del][7] = null;
                                produtos[del][8] = null;

                                System.out.println(" -------------------------");
                                System.out.println("|| Deletado com sucesso! ||");
                                System.out.println(" -------------------------");
                            } else {
                                System.out.println("!!!!!!!!!!!!!!!!!!!!");
                                System.out.println("!!!ID INEXISTENTE!!!");
                                System.out.println("!!!!!!!!!!!!!!!!!!!!");
                            }
                        }
                        fim = 4;
                        break;


                    //uso do polimorfismo
                    //mostrar dados das empresas

                    case "5":

                        System.out.println("Deseja ver dados de qual empresa? [A] ou [B]");
                        empresa = scan.next().charAt(0);
                        if (empresa == 'a' || empresa == 'A') {
                            Dados dados = Factory_GerenciamentoEmpresas.criarEmpresa(Empresa.empresaA);
                            System.out.println(dados.getDados());
                        } else if (empresa == 'b' || empresa == 'B') {
                            Dados dados = Factory_GerenciamentoEmpresas.criarEmpresa(Empresa.empresaB);
                            System.out.println(dados.getDados());
                        } else {
                            System.out.println("Empresa inexistente!");
                        }

                        fim = 5;
                        break;

                    //Opção 6, usuário encerra sistema --> Sistema mostra data e hora do encerramento!

                    case "6":
                        fim = 6;
                        break;

                    default:
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("!!!DIGITE UM DOS NÚMEROS A CIMA!!!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            } while (fim < 6);


        }
    }
