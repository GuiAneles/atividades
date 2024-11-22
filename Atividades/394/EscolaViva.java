import javax.swing.JOptionPane;

public class EscolaViva {
    public static void main(String[] args) {
        Menu menuop = new Menu();
        Aluno[] alunos = new Aluno[50];
        int index = 0;

        do {
            menuop.opcao = Byte.parseByte(JOptionPane.showInputDialog(
                "ESCOLA VIVA\n" +
                "1 - Entrar Nome\n" +
                "2 - Entrar 1ª Nota\n" +
                "3 - Entrar 2ª Nota\n" +
                "4 - Calcular Média\n" +
                "5 - Listar No Display\n" +
                "6 - Sair\n" +
                "OPÇÃO:"
            ));

            switch (menuop.opcao) {
                case 1:
                    if (index < 50) {
                        alunos[index] = new Aluno();
                        alunos[index].nome = JOptionPane.showInputDialog("Digite O Nome Do Aluno:");
                        index++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Limite De 50 Alunos Atingido!");
                    }
                    break;
                case 2:
                    if (index > 0) {
                        int alunoIndex = Integer.parseInt(JOptionPane.showInputDialog("Digite O Índice Do Aluno (0 A " + (index - 1) + "):"));
                        if (alunoIndex >= 0 && alunoIndex < index) {
                            alunos[alunoIndex].nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite A 1ª Nota Do Aluno " + alunos[alunoIndex].nome + ":"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice Inválido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum Aluno Registrado.");
                    }
                    break;
                case 3:
                    if (index > 0) {
                        int alunoIndex2 = Integer.parseInt(JOptionPane.showInputDialog("Digite O Índice Do Aluno (0 a " + (index - 1) + "):"));
                        if (alunoIndex2 >= 0 && alunoIndex2 < index) {
                            alunos[alunoIndex2].nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite A 2ª Nota Do Aluno " + alunos[alunoIndex2].nome + ":"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice Inválido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum Aluno Registrado.");
                    }
                    break;
                case 4:
                    for (int i = 0; i < index; i++) {
                        alunos[i].media = (alunos[i].nota1 * 3 + alunos[i].nota2 * 7) / 10;
                    }
                    JOptionPane.showMessageDialog(null, "Média Calculada Para Todos Os Alunos.");
                    break;
                case 5:
                    StringBuilder lista = new StringBuilder();
                    for (int i = 0; i < index; i++) {
                        lista.append("Aluno: ").append(alunos[i].nome).append("\n");
                        lista.append("1ª Nota: ").append(alunos[i].nota1).append("\n");
                        lista.append("2ª Nota: ").append(alunos[i].nota2).append("\n");
                        lista.append("Média: ").append(alunos[i].media).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo Do Programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        } while (menuop.opcao != 6);
    }
}
