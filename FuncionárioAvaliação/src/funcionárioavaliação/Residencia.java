package funcionárioavaliação;

public class Residencia {

    private String rua, bairro = "", cep, cidade, estado;

    private int numero;

    public Residencia(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }

    public Residencia(String rua, String bairro, String cep, String cidade, String estado, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String dados() {
        String dados = "";
        if (!bairro.equals("")) {
            dados = rua + ", " + numero + ", " + bairro + ", " + cep + ", " + cidade + ", " + estado;
        } else if (bairro.equals("")){
            dados = rua + ", " + numero;
        }
        return dados;
    }
    
    
    
}
