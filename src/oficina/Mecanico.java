package oficina;
import java.io.Serializable;

public class Mecanico implements Serializable {
    private int codigo;
    private String nome;
    private int tipo; //0-carro, 1-caminhao, 2-moto; 
    private double maodeObra = 75;

    public Mecanico(int codigo, String nome, int tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }

    public double getMaodeObra() {
        return maodeObra;
    }
    
    
    

}
