package funcionárioavaliação;

import javax.swing.JOptionPane;

public class FuncionárioAvaliação {

    public static void main(String[] args) {

        String tipoFunçao[] = {"Servente", "Auxiliar", "Técnico", "Especialista"};

        String operaçoes[] = {"Informações do funcionário", "Reajustar salário do funcionário", "Demitir funcionário", "Sair"};

        InfoFuncionario infoFunc = null;

        String nome = JOptionPane.showInputDialog(null, "Informe o nome do funcionário:", "Funcionário", 3);

        String sobrenome = JOptionPane.showInputDialog(null, "Informe o sobrenome do funcionário:", "Funcionário", 3);

        if (JOptionPane.showConfirmDialog(null, "Gostaria de informar o endereço?", "Casa", JOptionPane.YES_NO_OPTION, 3) == 0) {

            String rua = JOptionPane.showInputDialog(null, "Informe a rua do endereço do funcionário:", "Funcionário", 3);

            int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do endereço do funcionário:", "Funcionário", 3));

            if (JOptionPane.showConfirmDialog(null, "O endereço inteiro?", "Casa", JOptionPane.YES_NO_OPTION, 3) == 0) {

                String bairro = JOptionPane.showInputDialog(null, "Informe o bairro do endereço do funcionário:", "Funcionário", 3);

                String cep = JOptionPane.showInputDialog(null, "Informe o cep do endereço do funcionário:", "Funcionário", 3);

                String cidade = JOptionPane.showInputDialog(null, "Informe a cidade do endereço do funcionário:", "Funcionário", 3);

                String estado = JOptionPane.showInputDialog(null, "Informe o estado do endereço do funcionário:", "Funcionário", 3);

                String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula do funcionário:", "Funcionário", 3);

                String funçao = (String) JOptionPane.showInputDialog(null, "Escolha a função do funcionário:", "Funcionário", 3, null, tipoFunçao, tipoFunçao[0]);

                boolean ativo = true;
                infoFunc = new InfoFuncionario(matricula, funçao, ativo, nome, sobrenome, new Residencia(rua, bairro, cep, cidade, estado, numero));

            } else {
                String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula do funcionário:", "Funcionário", 3);

                String funçao = (String) JOptionPane.showInputDialog(null, "Escolha a função do funcionário:", "Funcionário", 3, null, tipoFunçao, tipoFunçao[0]);
                boolean ativo = true;
                infoFunc = new InfoFuncionario(matricula, funçao, ativo, nome, sobrenome, new Residencia(rua, numero));

            }
        } else {
            String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula do funcionário:", "Funcionário", 3);

            String funçao = (String) JOptionPane.showInputDialog(null, "Escolha a função do funcionário:", "Funcionário", 3, null, tipoFunçao, tipoFunçao[0]);

            boolean ativo = true;
            infoFunc = new InfoFuncionario(matricula, funçao, ativo, nome, sobrenome);

        }
        String opUser = "";

        while (!opUser.equals(operaçoes[3])) {
            opUser = (String) JOptionPane.showInputDialog(null, "Selecione a operação desejada:", "Operações", 3, null, operaçoes, operaçoes[0]);
            switch (opUser) {
                case "Informações do funcionário":
                    JOptionPane.showMessageDialog(null, infoFunc.dados(), "Informações", 1);
                    break;
                case "Reajustar salário do funcionário":
                    if (infoFunc.isAtivo()) {
                        float percentualBonificaçao = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a bonifição do funcionário:", "Funcionário", 3));
                        infoFunc.bonificaFuncionario(percentualBonificaçao);
                        JOptionPane.showMessageDialog(null, "Bonificação feita com sucesso.", "Funcionário", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação impossível, funcionário não ativo.", "Funcionário", 1);
                    }
                    break;
                case "Demitir funcionário":
                    if (infoFunc.isAtivo()) {

                        if (JOptionPane.showConfirmDialog(null, "Quer demitir mesmo o funcionário?", "Funcionário", JOptionPane.YES_NO_OPTION, 3) == 0) {
                            infoFunc.encerraContrato();
                            JOptionPane.showMessageDialog(null, "Funcionário demitido com sucesso", "Funcionário", 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação impossível, funcionário não ativo.", "Funcionário", 1);
                    }

            }
        }
        System.exit(0);
    }
}
