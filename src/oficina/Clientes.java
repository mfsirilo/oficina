package oficina;
import java.io.Serializable;

public class Clientes implements Serializable{
    private int codigo;
    private String nome;
    private String email;
    private String telefone;
    private String modelo;

    public Clientes(int codigo, String nome, String email, String telefone, String modelo) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.modelo = modelo;
    }
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getModelo() {
        return modelo;
    }
}
