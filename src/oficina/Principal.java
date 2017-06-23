package oficina;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;
import java.util.*;
import java.io.*;

public class Principal {

    public static ArrayList saidaArquivo(ArrayList arraylist, String enderecoArquivo) {

        try {
            FileOutputStream saida = new FileOutputStream(enderecoArquivo);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(saida);
            escritorObjetos.writeObject(arraylist);
            saida.close();
            System.out.println("Arquivo Gravado!!");
            return arraylist;
        } catch (Exception e) {
            System.out.println("ERRO!");
            return arraylist;
        }
    }

    public static ArrayList entradaArquivo(ArrayList arraylist, String enderecoArquivo) {

        try {
            InputStream entrada = new FileInputStream(enderecoArquivo);
            ObjectInputStream leitorObjetos = new ObjectInputStream(entrada);
            arraylist = (ArrayList) leitorObjetos.readObject();
            entrada.close();
            return arraylist;
        } catch (Exception e) {
            System.out.println("Erro");
            return arraylist;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<PecasEstoque> listapecas = new ArrayList();
        ArrayList<PecasEstoque> listapecasteste = new ArrayList();
        ArrayList<Clientes> listaclientes = new ArrayList();
        ArrayList<Mecanico> listaMecanico = new ArrayList();
        ArrayList<Orcamento> listaorcamento = new ArrayList();

        Orcamento orca = new Orcamento();

        //função chamadora de metodos
        
        Metodos metodos = new Metodos();
        int opcao1, opcao2;

        //função chamada do menu principal       
        metodos.menuPrincipal();
        opcao1 = input.nextInt();
        while (opcao1 != 0) {

            // while (opcao1 != 0) {
            switch (opcao1) {
                case 1:
                    //Exibição do menu de peças
                    metodos.menuPecas();
                    System.out.println("Você esta no menu peças, escolha uma opção");
                    System.out.println("Faça uma escolha no menu:");
                    opcao2 = input.nextInt();
                    while (opcao2 != 0) {
                        switch (opcao2) {
                            case 1:
                                metodos.cadastroPecas(listapecas);
                                metodos.limparTela();
                                break;
                            case 2:
                                metodos.limparTela();
                                metodos.imprimePecas(listapecas);
                                break;
                            case 3:
                                metodos.limparTela();
                                int codigoPeca;
                                System.out.println("Informe o codigo da peca para excluir");
                                codigoPeca = input.nextInt();
                                metodos.excluirPecas(listapecas, codigoPeca);
                                break;
                        }
                        //exibição do menu de peças
                        metodos.menuPecas();
                        System.out.println("Você esta no menu peças, escolha uma opção");
                        opcao2 = input.nextInt();
                    }
                    Metodos.limparTela();
                    metodos.menuPrincipal();
                    System.out.println("Você voltou ao menu principal, escolha uma oṕção");
                    opcao1 = input.nextInt();
                    break;
                case 2:
                    //exibição do menu de clientes
                    metodos.menuClientes();
                    System.out.println("Você esta no menu clientes, escolha uma opção");
                    opcao2 = input.nextInt();
                    while (opcao2 != 0) {
                        switch (opcao2) {
                            case 1:
                                metodos.cadastroCientes(listaclientes);
                                break;
                            case 2:
                                metodos.imprimeClientes(listaclientes);
                                break;
                            case 3:
                                int codigoCliente;
                                System.out.println("Informe o codigo do cliente para excluir");
                                codigoCliente = input.nextInt();
                                metodos.excluirClientes(listaclientes, opcao2);
                                break;
                        }
                        //exibição do menu de clientes
                        metodos.menuClientes();
                        System.out.println("Você esta no menu clientes, escolha uma opção");
                        opcao2 = input.nextInt();
                    }
                    Metodos.limparTela();
                    metodos.menuPrincipal();
                    System.out.println("Você voltou ao menu principal, escolha uma oṕção");
                    opcao1 = input.nextInt();
                    break;
                case 3:
                    //exibição do menu mecanico
                    metodos.menuMecanico();
                    System.out.println("Você esta no menu mecanico, escolha uma opção");
                    opcao2 = input.nextInt();
                    while (opcao2 != 0) {
                        switch (opcao2) {
                            case 1:
                                metodos.cadastroMecanico(listaMecanico);
                                break;
                            case 2:
                                metodos.imprimeMecanicos(listaMecanico);
                                break;
                            case 3:
                                int codigoMecanico;
                                System.out.println("Informe o codigo do mecanico para excluir");
                                codigoMecanico = input.nextInt();
                                metodos.excluirMecanico(listaMecanico, opcao2);
                                break;
                        }
                        System.out.println("");
                        //exibe o menu mecanico
                        metodos.menuMecanico();
                        System.out.println("Você esta no menu mecanico, escolha uma opção");
                        opcao2 = input.nextInt();
                    }
                    Metodos.limparTela();
                    metodos.menuPrincipal();
                    System.out.println("Você voltou ao menu principal, escolha uma oṕção");
                    opcao1 = input.nextInt();
                    break;
                case 4:
                    metodos.menuOrcamento();
                    System.out.println("Você esta no menu orcamento, escolha uma opção");
                    opcao2 = input.nextInt();
                    while (opcao2 != 0) {
                        switch (opcao2) {
                            case 1:
                                metodos.orcamento(listaorcamento, listapecas, listaMecanico, listaclientes);
                                System.out.println("");
                                break;
                            case 2:
                                orca.mostrapeca();
                                break;
                        }
                        metodos.menuOrcamento();
                        System.out.println("Você esta no menu orcamento, escolha uma opção");
                        opcao2 = input.nextInt();
                    }
                    Metodos.limparTela();
                    metodos.menuPrincipal();
                    System.out.println("Você voltou ao menu principal, escolha uma oṕção");
                    opcao1 = input.nextInt();
                    break;

                //Opção criada para submenu
                /*default:
                
                boolean opcao3 = false;
                if (opcao1 == 0) {
                    opcao3 = true;
                }

                while (opcao3 == true) {
                    metodos.menuSair();
                    opcao2 = input.nextInt();
                    if (opcao2 == 1) {
                        System.exit(0);

                    } else {
                        metodos.menuPrincipal();
                        opcao1 = input.nextInt();
                    }

                }

                break;*/
            }
        }

        //exibição do menu principal
        //}
        /*       listaContas.clear();
        System.out.println("Lista depois de limpa");
        mostraLista(listaContas);
        System.out.println("");
         */
 /*
        =======================================
        
        try {
            InputStream entrada = new FileInputStream(endereco);
            ObjectInputStream leitorObjetos = new ObjectInputStream(entrada);
            listaorcamento = (ArrayList<Orcamento>) leitorObjetos.readObject();
            entrada.close();
        } catch (Exception e) {
            System.out.println("Erro");
            metodos.menuPrincipal();
            opcao1 = input.nextInt();
        }
        
        =======================================
        
        try {
            OutputStream saida = new FileOutputStream(endereco);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(saida);
            escritorObjetos.writeObject(listaorcamento);
            saida.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problema com o caminho do arquivo");
            metodos.menuPrincipal();
            opcao1 = input.nextInt();
        } catch (SerializationException e) {
            System.out.println("Erro na serialização da lista");
            metodos.menuPrincipal();
            opcao1 = input.nextInt();
        } catch (IOException ex) {
            System.out.println("ERRO");
            metodos.menuPrincipal();
            opcao1 = input.nextInt();
        }
        
        =======================================
         */
    }

}
