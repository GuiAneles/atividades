import javax.swing.JOptionPane;

public class MenuAlunos {
    public static void main(String[] args) {
        Menu menuop = new Menu();
        Aluno[] alunos = new Aluno[15];

        for (int i = 0; i < 15; i++) {
            alunos[i] = new Aluno();

            alunos[i].nome = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + ":");
            alunos[i].pr1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da PR1 de " + alunos[i].nome + ":"));
            alunos[i].pr2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da PR2 de " + alunos[i].nome + ":"));

            alunos[i].media = (alunos[i].pr1 + alunos[i].pr2) / 2;
            alunos[i].media = Math.round(alunos[i].media); // Arredondar a média

            if (alunos[i].media >= 6) {
                alunos[i].situacao = "AP"; // Aprovado
            } else {
                alunos[i].situacao = "RP"; // Reprovado
            }
        }

        do {
            menuop.opcao = Byte.parseByte(JOptionPane.showInputDialog(
                "MENU\n" +
                "1 - Imprimir a listagem com nome, notas, média e situação\n" +
                "2 - Terminar o algoritmo\n" +
                "OPÇÃO:"
            ));

            switch (menuop.opcao) {
                case 1:
                    StringBuilder listagem = new StringBuilder();
                    listagem.append("Nome \t\t  PR1  \t  PR2  \t  Média  \t  Situação\n");
                    listagem.append("----------------------------------------------\n");
                    for (Aluno aluno : alunos) {
                        listagem.append(String.format("%-15s%-8.2f%-8.2f%-8.2f%-8s\n",
                                aluno.nome, aluno.pr1, aluno.pr2, aluno.media, aluno.situacao));
                    }
                    JOptionPane.showMessageDialog(null, listagem.toString());
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa. Até logo!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (menuop.opcao != 2);
    }
}
