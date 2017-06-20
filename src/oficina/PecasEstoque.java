package oficina;

import java.io.Serializable;
import java.util.ArrayList;

public class PecasEstoque implements Serializable{
    private int codigo;
    private String descricao;
    private double precoUnit;
    private int qtdEstoque;
    // decrementar quanddo for usado e nao permitir o uso se estiver zerado;
    private int tipoPeca;
    //0-carro, 1-caminhao, 2-moto; 
    
    public PecasEstoque(int codigo,String desc, double prec, int qtdEs, int tipo){
        this.codigo=codigo;
        this.descricao=desc;
        this.precoUnit=prec;
        this.qtdEstoque=qtdEs;
        this.tipoPeca=tipo;
    }
    
    public void diminui(int qtd){
        this.qtdEstoque=(this.qtdEstoque-qtd);
    }
    
    public void setQtd(int qtd){
        this.qtdEstoque=qtd;
    }
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public int getTipoPeca() {
        return tipoPeca;
    }
   
    public void setQtdEstoque(int qtd){
        this.qtdEstoque=qtd;
    }
    
}
