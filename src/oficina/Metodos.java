package oficina;

import java.io.*;
import java.util.*;

public class Metodos {

    String enderecoMec = "/home/marcos/Documentos/pratica3/Trabalhos/Mecanicos.bin";
    String enderecoCli = "/home/marcos/Documentos/pratica3/Trabalhos/Clientes.bin";
    String enderecoEst = "/home/marcos/Documentos/pratica3/Trabalhos/Estoque.bin";
    String enderecoOrc = "/home/marcos/Documentos/pratica3/Trabalhos/Orcamento.bin";
    String enderecoPec = "/home/marcos/Documentos/pratica3/Trabalhos/Peca.bin";

    Scanner input = new Scanner(System.in);
    int codP = 0, codC = 0, codM = 0, codO = 0;
    // variaveis que se auto incrementam para passar como
    //parametro para cada novo objeto criado

    public void menuPrincipal() {

        System.out.println("Informe uma opção de acordo com o Menu: ");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para peças");
        System.out.println("Digite 2 para Clientes");
        System.out.println("Digite 3 para Mecanicos");
        System.out.println("Digite 4 para Orcamentos");
        System.out.println("");

    }

    public void cadastroPecas(ArrayList<PecasEstoque> listapecas) {
        listapecas = Principal.entradaArquivo(listapecas, enderecoPec);

        String descricao;
        double precoUnit;
        int qtdEstoque;
        // decrementar quanddo for usado e nao permitir o uso se estiver zerado;
        int tipoPeca;
        //0-carro, 1-caminhao, 2-moto;
        System.out.println("Digite as informações sobre a peça");

        System.out.println("Informe a descrição");
        descricao = input.next();
        System.out.println("Informe o preco unitario");
        precoUnit = input.nextDouble();
        System.out.println("Informe a quantidade a inserir no estoque");
        qtdEstoque = input.nextInt();
        System.out.println("Informe o tipo da peca, 1-carro, 2-moto");
        tipoPeca = input.nextInt();

        PecasEstoque pecas1 = new PecasEstoque(codP, descricao, precoUnit, qtdEstoque, tipoPeca);

        if (listapecas.size() > 0) {
            int ultimapeca = listapecas.get(listapecas.size()-1).getCodigo();
            
            pecas1.setCodigo(ultimapeca+1);//parte do codigo que seta 
            listapecas.add(pecas1);
            Principal.entradaArquivo(listapecas, enderecoPec);
            pecas1 = listapecas.get(codP);
            codP++;
            Principal.saidaArquivo(listapecas, enderecoPec);
        } else {
            listapecas.add(pecas1);
        Principal.entradaArquivo(listapecas, enderecoPec);
        pecas1 = listapecas.get(codP);
        codP++;
        }
        Principal.saidaArquivo(listapecas, enderecoPec);

        System.out.println("Dados informados com sucesso");
        Metodos.limparTela();
    }

    public void imprimePecas(ArrayList<PecasEstoque> listapecas) {
        System.out.println("                  Informações do estoque de peças           ");
        Principal.entradaArquivo(listapecas, enderecoPec);
        //System.out.println(Principal.entradaArquivo(listapecas, enderecoCli).get(0));
        if (Principal.entradaArquivo(listapecas, enderecoPec).isEmpty()) {
            System.out.println("Ta vazio");
        }
        listapecas = Principal.entradaArquivo(listapecas, enderecoPec);

        for (PecasEstoque listapeca : listapecas) {
            System.out.println("*=**=**=**=**=**=**=**=**=**=**=**=*");

            System.out.println("Codigo: " + listapeca.getCodigo());
            System.out.println("Descrição: " + listapeca.getDescricao());
            System.out.println("Preço Unitário: " + listapeca.getPrecoUnit());
            System.out.println("Estoque: " + listapeca.getQtdEstoque());
            System.out.print("Tipo de veículo: ");

            if (listapeca.getTipoPeca() == 1) {
                System.out.println("carro");
            }
            if (listapeca.getTipoPeca() == 2) {
                System.out.println("moto");
            }

            System.out.println("");

        }
        System.out.println("");
        System.out.println("                      Fim das Informações");
        System.out.println("");
    }

    public void excluirPecas(ArrayList<PecasEstoque> listapecas, int codigo) {
        listapecas = Principal.entradaArquivo(listapecas, enderecoPec);

        for (int i = 0; i < listapecas.size(); i++) {
            if (listapecas.get(i).getCodigo() == codigo) {
                listapecas.remove(i);
                System.out.println("Removida com sucesso");
            } else {
                System.out.println("Peca inexistente");
            }
        }
        System.out.println("");
    }

    public void menuPecas() {

        System.out.println("Setor de peças");

        System.out.println("");
        System.out.println("Digite 1 para cadastrar peças");
        System.out.println("Digite 2 para mostrar as peças existentes");
        System.out.println("Digite 3 para excluir uma peca");
        System.out.println("Digite 0 para voltar ao menu principal");
        System.out.println("");

    }

    public void cadastroCientes(ArrayList<Clientes> listaclientes) {
        listaclientes = Principal.entradaArquivo(listaclientes, enderecoCli);
        String nome;
        String email;
        String telefone;
        String modelo;

        System.out.println("Digite as informações sobre o cliente");

        System.out.println("Informe o nome");
        nome = input.next();
        System.out.println("Informe o email ");
        email = input.next();
        System.out.println("Informe o telefone");
        telefone = input.next();
        System.out.println("Informe o modelo do veiculo");
        modelo = input.next();

        Clientes cliente1 = new Clientes(codC, nome, email, telefone, modelo);
        if (listaclientes.size() > 0) {
            int ultimapeca = listaclientes.get(listaclientes.size()-1).getCodigo();
            
            cliente1.setCodigo(ultimapeca+1);//parte do codigo que seta 
            listaclientes.add(cliente1);
            Principal.entradaArquivo(listaclientes, enderecoCli);
            cliente1 = listaclientes.get(codC);
            codC++;
            Principal.saidaArquivo(listaclientes, enderecoCli);
        } else {
            listaclientes.add(cliente1);
        Principal.entradaArquivo(listaclientes, enderecoCli);
        cliente1 = listaclientes.get(codC);
        codC++;
        }
        

        listaclientes.add(cliente1);
        System.out.println("Dados inseridos com sucesso");
        Principal.saidaArquivo(listaclientes, enderecoCli);
    }

    public void imprimeClientes(ArrayList<Clientes> listaclientes) {
        listaclientes = Principal.entradaArquivo(listaclientes, enderecoCli);

        System.out.println("Informações dos CLientes");

        for (Clientes listacli : listaclientes) {
            System.out.println("*=**=**=**=**=**=**=**=**=**=**=**=*");

            System.out.println("Codigo: " + listacli.getCodigo());
            System.out.println("Nome: " + listacli.getNome());
            System.out.println("E-mail: " + listacli.getEmail());
            System.out.println("Telefone: " + listacli.getTelefone());
            System.out.println("Modelo do veículo: " + listacli.getModelo());

            System.out.println("");

        }
        System.out.println("");
        System.out.println("Fim das Informações");
        System.out.println("");
    }

    public void excluirClientes(ArrayList<Clientes> listaclientes, int codigo) {
        listaclientes = Principal.entradaArquivo(listaclientes, enderecoCli);
        for (int i = 0; i < listaclientes.size(); i++) {
            if (listaclientes.get(i).getCodigo() == codigo) {
                listaclientes.remove(i);
                System.out.println("Removido com sucesso");
            } else {
                System.out.println("Cliente inexistente");
            }
        }
    }

    public void menuClientes() {
        System.out.println("Área de Clientes");

        System.out.println("");
        System.out.println("Digite 1 para cadastrar cliente");
        System.out.println("Digite 2 para mostrar os clientes cadastrados");
        System.out.println("Digite 3 para exluir algum cliente");
        System.out.println("Digite 0 para voltar ao menu principal");
        System.out.println("");
    }

    public void cadastroMecanico(ArrayList<Mecanico> listamecanico) {
        listamecanico = Principal.saidaArquivo(listamecanico, enderecoMec);
        String nome;
        int tipo; //0-carro, 1-caminhao, 2-moto; 
        System.out.println("");
        System.out.println("                   Digite as informações do mecanico");

        System.out.println("Informe o nome");
        nome = input.next();
        System.out.println("Informe o tipo: 1-carro, 2-moto");
        tipo = input.nextInt();

        Mecanico meca1 = new Mecanico(codM, nome, tipo);
        codM++;

        listamecanico.add(meca1);
        Principal.saidaArquivo(listamecanico, enderecoMec);

        System.out.println("Dados informados com sucesso");
        System.out.println("");
    }

    public void imprimeMecanicos(ArrayList<Mecanico> listamecanico) {
        listamecanico = Principal.saidaArquivo(listamecanico, enderecoMec);

        System.out.println("                  Informações do Mecanico");

        for (Mecanico meca : listamecanico) {
            System.out.println("*=**=**=**=**=**=**=**=**=**=**=**=*");
            System.out.println("Codigo: " + meca.getCodigo());
            System.out.println("Tipo: " + meca.getTipo());
            System.out.println("Nome: " + meca.getNome());

            System.out.println(" ");

        }
    }

    public void excluirMecanico(ArrayList<Mecanico> listamecanico, int codigo) {
        listamecanico = Principal.saidaArquivo(listamecanico, enderecoMec);

        for (int i = 0; i < listamecanico.size(); i++) {
            if (listamecanico.get(i).getCodigo() == codigo) {
                listamecanico.remove(i);
                System.out.println("Renovido com sucesso");
            } else {
                System.out.println("Mecanico inexistente");
            }
        }
    }

    public void menuMecanico() {

        System.out.println("Area dos mecanicos");

        System.out.println("");
        System.out.println("Digite 1 para cadastrar mecanico");
        System.out.println("Digite 2 para mostrar os mecanicos cadastrados");
        System.out.println("Digite 3 para excluir um mecanico");
        System.out.println("Digite 0 para voltar ao menu principal");
        System.out.println("");
    }

    //Ideia é criar um menu para confirmação de saida. 
    public void menuSair() {
        System.out.println("Confirmação de saida");

        System.out.println("");
        System.out.println("Digite 1 para sair");
        System.out.println("Digite 2 para voltar");

    }

    public void orcamento(ArrayList<Orcamento> listaorcamentos, ArrayList<PecasEstoque> listapecas,
            ArrayList<Mecanico> listamecanico, ArrayList<Clientes> listacliente) {
        //listaorcamento = Principal.saidaArquivo(listaorcamento, enderecoOrc);
        int codigoP;
        int codigoC = 3;
        int codigoM = 4;
        double valor10;
        ArrayList<PecasEstoque> listp = new ArrayList<PecasEstoque>();

        PecasEstoque aux = null;
        PecasEstoque aux2 = null;
        int resp, qtd, codC, codM;
        double valorP = 0, valorS = 0, totalM = 0;
        boolean cliente = false, mecanico = false;

        resp = 1;

        while (resp != 0) {

            System.out.println("Informe o codigo da peca para adicionar");
            codigoP = input.nextInt();
            System.out.println("Quantas pecas deseja adicioanr?");
            qtd = input.nextInt();
            System.out.println("Informe o codigo do ciente");
            codC = input.nextInt();
            System.out.println("Informe o codigo do mecanico");
            codM = input.nextInt();

            for (int i = 0; i < listacliente.size(); i++) {
                if (codC == listacliente.get(i).getCodigo()) {
                    cliente = true;
                }
            }

            for (int i = 0; i < listamecanico.size(); i++) {
                if (codM == listamecanico.get(i).getCodigo()) {
                    mecanico = true;
                }
            }

            if ((cliente == true) && (mecanico == true)) {
                for (int i = 0; i < listapecas.size(); i++) {
                    if (codigoP == listapecas.get(i).getCodigo()) {
                        if (listapecas.get(i).getQtdEstoque() > 0) {
                            if (listapecas.get(i).getQtdEstoque() >= qtd) {
                                listapecas.get(i).diminui(qtd);
                                aux = listapecas.get(i);
                                aux.setQtd(qtd);
                                listp.add(aux);
                                valorP = (valorP + listapecas.get(i).getPrecoUnit());
                                valor10 = (valorP * 10) / 100;
                                valorS = (+listamecanico.get(i).getMaodeObra() + valor10);
                            } else {
                                System.out.println("Quantidade alta demais");
                            }
                        } else {
                            System.out.println("Nao temos a peca");
                        }
                    }
                }
                totalM = (valorS + valorP);
                System.out.println("Digite Qualquer numero para adicionar peca ou 0 para sair");
                resp = input.nextInt();
            } else {
                System.out.println("Mecanico ou cliente inexistente");
            }

            Orcamento orca = new Orcamento(listp, valorS, totalM, codC, codM, qtd);
            listaorcamentos.add(orca);
            Principal.saidaArquivo(listp, enderecoOrc);
            System.out.println("Orcamento criado com sucesso");

            orca.mostrapeca();
            System.out.println("Deseja fazer outro orçamento? ");
            menuOrcamento();
            resp = 1;
        }
    }

    public void menuOrcamento() {
        System.out.println("Digite 1 para fazer orcamento");
        System.out.println("Digite 2 para imprimir os orcamentos");
        System.out.println("Digite 0 para voltar ao menu principal");
        System.out.println("");
    }

    public static void limparTela() {
        for (int i = 0; i != 100; ++i) {
            System.out.println("");
        }
    }
}
