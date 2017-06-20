package oficina;
import java.util.ArrayList;
import java.io.Serializable;

public class Orcamento implements Serializable {
    private int codigo;
    private int codigoC;
    private int codigoM;
    private double valorS;
    private double total;
    private double valorP;
    private double porc;
    private int qtd;
    
    ArrayList<PecasEstoque> listapecas = new ArrayList<>();
    
    public Orcamento(ArrayList<PecasEstoque> lista, double valorS, double total, int codC, int codM, int qtd ) {
        
        this.codigo = codigo;
        this.valorS = valorS;
        this.total = total;
        this.listapecas=lista;
        this.valorP=valorP;
        this.codigoC=codC;
        this.codigoM=codM;
        this.qtd=qtd;
    }
    
    public Orcamento(){
        
    }
    
    
    public void mostrapeca(){
        for(int i=0;i<listapecas.size();i++){
            System.out.println("Peca: "+listapecas.get(i).getDescricao());
            System.out.println("Qtd: "+listapecas.get(i).getQtdEstoque());
        }
        System.out.println("Codigo do cliente: "+this.codigoC);
        System.out.println("Codigo do mecanico: "+this.codigoM);
        System.out.println("Valor total das pecas: "+this.valorP);
        System.out.println("Valor do Servico: "+this.valorS);
        System.out.println("Valor total: "+this.total);
    }
    public int getCodigo() {
        return codigo;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public int getCodigoM() {
        return codigoM;
    }

    public double getValorS() {
        return valorS;
    }

    public double getTotal() {
        return total;
    }

}
