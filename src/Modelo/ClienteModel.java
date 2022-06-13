package Modelo;
import java.util.Date;
public class ClienteModel {
    private int idcliente;
    private String nome; 
    private String endereco; 
    private Date  dataCadastro;
    public int getIdCliente() {
        return idcliente;
    }
    public void setIdCliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
