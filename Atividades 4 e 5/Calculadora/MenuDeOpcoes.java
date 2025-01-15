import javax.swing.JOptionPane;

public class MenuDeOpcoes {
    public static void main(String[] args) {
        Menu menuop = new Menu();
        
        boolean continuar = true;
        while (continuar) {
            menuop.opcao = Byte.parseByte(JOptionPane.showInputDialog("Digite uma opção: \n 1- Adição \n 2- Subtração \n 3- Multiplicação \n 4- Divisão \n 5- Sair"));
            
            if (menuop.opcao >= 1 && menuop.opcao <= 4) {
                menuop.tipoNotacao = Byte.parseByte(JOptionPane.showInputDialog("Digite o Tipo De Notação: \n 1- Infixa \n 2- Pós-Fixa \n 3- Pré-Fixa"));
            }

            switch (menuop.opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                    operacaoBasica(menuop.tipoNotacao);
                    break;
                case 5:  
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida. Tente Novamente.");
            }
        }
    }

    public static void operacaoBasica(byte tipoNotacao) {
        String expressao = JOptionPane.showInputDialog("Digite a Expressão:");

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

        System.out.println("Expressão Infixa: " + infixa);
        System.out.println("Expressão Pós-fixa: " + posfixa);
        System.out.println("Expressão Pré-fixa: " + prefixa);

        double resultado = Calculadora.calcularPosfixa(posfixa);
        System.out.println("O resultado da expressão é: " + resultado);
    }
}
