import javax.swing.JOptionPane;

public class Expressao {

    public static void main(String[] args) {
        // Solicita a expressão ao usuário através de uma caixa de diálogo
        String expressao = JOptionPane.showInputDialog("Digite Uma Expressão Aritmética Para Verificar A Parametrização:");

        // Verifica se a expressão foi fornecida
        if (expressao == null || expressao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro: Nenhuma Expressão Fornecida.");
            return;
        }

        if (Verificacao.verificarParametrizacao(expressao)) {
            JOptionPane.showMessageDialog(null, "A Expressão Está Correta!");
        } else {
            JOptionPane.showMessageDialog(null, "A Expressão Está Incorreta!");
        }
    }
}