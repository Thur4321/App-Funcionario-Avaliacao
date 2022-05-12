package funcionárioavaliação;

import java.text.DecimalFormat;

public class InfoFuncionario extends Pessoa {

    private String matricula, funçao;

    private double salario;

    private boolean ativo;

    public InfoFuncionario(String matricula, String funçao, boolean ativo, String nome, String sobrenome, Residencia residencia) {
        super(nome, sobrenome, residencia);
        this.matricula = matricula;
        this.funçao = funçao;
        this.ativo = ativo;
    }

    public InfoFuncionario(String matricula, String funçao, boolean ativo, String nome, String sobrenome) {
        super(nome, sobrenome);
        this.matricula = matricula;
        this.funçao = funçao;
        this.ativo = ativo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFunçao() {
        return funçao;
    }

    public void setFunçao(String funçao) {
        this.funçao = funçao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void defineSalarioBase() {
        if (funçao.equalsIgnoreCase("Servente")) {
            salario = 240;
        } else if (funçao.equalsIgnoreCase("Auxiliar")) {
            salario = 600;
        } else if (funçao.equalsIgnoreCase("Técnico")) {
            salario = 1200;
        } else if (funçao.equalsIgnoreCase("Especialista")) {
            salario = 2400;
        }
    }

    public void bonificaFuncionario(float percentualBonificaçao) {
        salario += salario * (percentualBonificaçao / 100);
    }

    public void encerraContrato() {
        ativo = false;
    }

    public float calculaINSS() {
        float inss = (float) (salario * 8.5 / 100);
        return inss;
    }

    public float calculaIR() {
        float ir = 0;
        if (salario <= 1500 && salario > 0) {
            ir = 0;
        } else if (salario > 1500 && salario <= 2400) {
            ir = (float) (salario * 15 / 100);
        } else if (salario > 2400) {
            ir = (float) (salario * 27 / 100);
        }
        return ir;
    }

    public float calculaSalarioLiquido() {
        float salarioLiquido = (float) (salario - calculaINSS() - calculaIR());
        return salarioLiquido;
    }

    @Override
    public String dados() {
        DecimalFormat mascara = new DecimalFormat("#,##0.00");
        if (ativo) {
            return "As informações como pessoa são:"
                    + "\n\n" + super.dados()
                    + "\n\n"
                    + "As informações como funcionário são:"
                    + "\n\nMatrícula: " + matricula
                    + "\nFunção: " + funçao
                    + "\nAtivo"
                    + "\nSalário Base: R$" + mascara.format(salario)
                    + "\nDesconto INSS: R$" + mascara.format(calculaINSS())
                    + "\nDesconto IR: R$" + mascara.format(calculaIR())
                    + "\nSalário Líquido: R$" + mascara.format(calculaSalarioLiquido());
        } else {
            return "As informações como pessoa são:"
                    + "\n\n" + super.dados()
                    + "\n\n"
                    + "Funcionário Inativo";
        }

    }
}
