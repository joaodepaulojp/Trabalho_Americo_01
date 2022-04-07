package Cadastros;
import java.util.Scanner;

public class CadFunctionary {

    //Menu

    public static String menu() {
        Scanner scan = new Scanner(System.in);
        String option;

        System.out.println(" ----------------------------");
        System.out.println("|| Cadastro de Funcionarios ||");
        System.out.println(" ----------------------------");

        System.out.println("Digite um numero:");
        System.out.println("1 - Registrar funcionário");
        System.out.println("2 - Listar funcionário(s)");
        System.out.println("3 - Atualizar cadastro");
        System.out.println("4 - Deletar funcionário");
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
        String cargo;
        String[][] funcionarios = new String[100][10];
        char empresa;
        String ep;
        //char ep;

        do {
            switch(menu()) {

                //Opção 1, usuário registra o funcionário!

                case "1":
                    System.out.println("Nome: ");
                    System.out.print("(>) ");
                    nome = scan.nextLine();
                    System.out.println("Cargo: ");
                    System.out.print("(>) ");
                    cargo = scan.nextLine();
                    System.out.println("Empresa: [A] ou [B]");
                    System.out.print("(>) ");
                    ep = scan.nextLine();


                    id = i;
                    funcionarios[i][0] = "ID: " + Integer.toString(id);
                    funcionarios[i][1] = "Nome: " + nome;
                    funcionarios[i][2] = "Cargo: " + cargo;
                    funcionarios[i][3] = "Empresa: " + ep;
                    funcionarios[i][4] = "------------------------";


                    i++;
                    fim = 1;

                    System.out.println(" --------------------------");
                    System.out.println("|| REGISTRADO COM SUCESSO ||");
                    System.out.println(" --------------------------");
                    break;

                //Opção 2, usuário recebe a lista de funcionários registrados!

                case "2":

                    System.out.println(" -------------------------");
                    System.out.println("|| LISTA DE FUNCIONÁRIOS ||");
                    System.out.println(" -------------------------");
                    System.out.println(" -------------------------");

                    for (String[] funcionario : funcionarios) {
                        for (int l = 0; l < funcionarios[l].length; l++) {
                            if (funcionario[l] != null) {
                                if (l < 5) {
                                    System.out.println("- " + funcionario[l]);
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
                        System.out.println("Nome: ");
                        System.out.print("(>) ");
                        nome = scan.nextLine();
                        System.out.println("Cargo: ");
                        System.out.print("(>) ");
                        cargo = scan.nextLine();
                        System.out.println("Empresa: [A] ou [B]");
                        System.out.print("(>) ");
                        ep = scan.nextLine();

                        funcionarios[atu][0] = "ID: " + Integer.toString(atu);
                        funcionarios[atu][1] = "Nome: " + nome;
                        funcionarios[atu][2] = "Cargo: " + cargo;
                        funcionarios[atu][3] = "Empresa: " + ep;

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
                    System.out.println("Deseja DELETAR algum funcionário? [S]->SIM || [N]->NÃO");
                    confirm = scan.next().charAt(0);
                    if (confirm == 's' || confirm == 'S') {
                        System.out.println("Informe o ID: ");
                        System.out.print("(>) ");
                        del = scan.nextInt();
                        scan.nextLine();
                        if (del < i && funcionarios[del][0] != null) {
                            funcionarios[del][0] = null;
                            funcionarios[del][1] = null;
                            funcionarios[del][2] = null;
                            funcionarios[del][3] = null;
                            funcionarios[del][4] = null;
                            funcionarios[del][5] = null;
                            funcionarios[del][6] = null;
                            funcionarios[del][7] = null;
                            funcionarios[del][8] = null;

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
