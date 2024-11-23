import javax.swing.JOptionPane;

public class AlunosNotas {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[5];

        for (int i = 0; i < 5; i++) {
            alunos[i] = new Aluno();

            String s = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + ":");
            alunos[i].nome = s;

            s = JOptionPane.showInputDialog("Digite a 1ª nota do aluno " + alunos[i].nome + ":");
            alunos[i].nota1 = Double.parseDouble(s);

            s = JOptionPane.showInputDialog("Digite a 2ª nota do aluno " + alunos[i].nome + ":");
            alunos[i].nota2 = Double.parseDouble(s);

            alunos[i].media = (alunos[i].nota1 + alunos[i].nota2) / 2;
        }
        
        String resultado = "Listagem de Alunos e Notas:\n";
        for (int i = 0; i < 5; i++) {
            resultado += "Aluno: " + alunos[i].nome + "\n" +
                         "Nota 1: " + alunos[i].nota1 + "\n" +
                         "Nota 2: " + alunos[i].nota2 + "\n" +
                         "Média: " + alunos[i].media + "\n\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
