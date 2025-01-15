import javax.swing.JOptionPane;

public class MenuDeOpcoes {
    public static void main(String[] args) {
        Menu menuop = new Menu();
        
        while (true) {
            // Menu de operações
            menuop.opcao = Byte.parseByte(JOptionPane.showInputDialog(
                "Digite uma opção: \n 1- Adição \n 2- Subtração \n 3- Multiplicação \n 4- Divisão \n 5- Sair"
            ));
            
            // Verifica se a opção escolhida é válida
            if (menuop.opcao < 1 || menuop.opcao > 5) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                continue;
            }

            // Se a opção for 5 (Sair), encerra o programa
            if (menuop.opcao == 5) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;  // Encerra o loop
            }

            // Menu de notações
            menuop.tipoNotacao = Byte.parseByte(JOptionPane.showInputDialog(
                "Escolha o tipo de notação: \n 1- Infixa \n 2- Pós-fixa \n 3- Pré-fixa"
            ));
            
            // Verifica se a opção de notação é válida
            if (menuop.tipoNotacao < 1 || menuop.tipoNotacao > 3) {
                JOptionPane.showMessageDialog(null, "Opção de notação inválida. Tente novamente.");
                continue;
            }

            // Solicita a expressão e processa
            String expressao = JOptionPane.showInputDialog("Digite a expressão:");
            processarExpressao(menuop.tipoNotacao, expressao);
        }
    }

    public static void processarExpressao(byte tipoNotacao, String expressao) {
        String[] expressoesConvertidas = converterExpressao(tipoNotacao, expressao);
        String infixa = expressoesConvertidas[0];
        String posfixa = expressoesConvertidas[1];
        String prefixa = expressoesConvertidas[2];

        // Exibindo as expressões convertidas
        System.out.println("Expressao Infixa: " + infixa);
        System.out.println("Expressao Pos-fixa: " + posfixa);
        System.out.println("Expressao Pre-fixa: " + prefixa);

        double resultado = calcularExpressao(posfixa);
        System.out.println("O resultado da expressao e: " + resultado);
    }

    public static String[] converterExpressao(byte tipoNotacao, String expressao) {
        String infixa = "";
        String posfixa = "";
        String prefixa = "";

        switch (tipoNotacao) {
            case 1:
                infixa = expressao;
                posfixa = Conversao.infixaParaPosfixa(infixa);
                prefixa = Conversao.infixaParaPrefixa(infixa);
                break;
            case 2:
                posfixa = expressao;
                infixa = Conversao.posfixaParaInfixa(posfixa);
                prefixa = Conversao.infixaParaPrefixa(infixa);
                break;
            case 3:
                prefixa = expressao;
                infixa = Conversao.prefixaParaInfixa(prefixa);
                posfixa = Conversao.infixaParaPosfixa(infixa);
                break;
        }
        return new String[]{infixa, posfixa, prefixa};
    }

    public static double calcularExpressao(String posfixa) {
        return Calculadora.calcularPosfixa(posfixa);
    }
}
