package funcionárioavaliação;

public class Pessoa {

    protected String nome, sobrenome;

    protected Residencia residencia;

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Pessoa(String nome, String sobrenome, Residencia residencia) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.residencia = residencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public String nomeCompleto() {
        return nome + " " + sobrenome;
    }
    
    public String dados() {
        String dados = "";
        if (residencia != null) {
            dados = "Nome completo: " + nomeCompleto()
                    + "\nResidência: " + residencia.dados();
        } else {
            dados = "Nome completo: " + nomeCompleto()
                    + "\nResidência não cadastráda";
        }
        return dados;
    }

}
