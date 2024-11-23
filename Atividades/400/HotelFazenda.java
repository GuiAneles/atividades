import javax.swing.JOptionPane;

public class HotelFazenda {
    public static void main(String[] args) {
        int numQuartos = 50;
        Quarto[] quartos = new Quarto[numQuartos];
        for (int i = 0; i < numQuartos; i++) {
            quartos[i] = new Quarto();
        }

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Hotel-Fazenda Sucesso\n" +
                "1. Cadastra quartos\n" +
                "2. Lista todos os quartos\n" +
                "3. Lista quartos ocupados\n" +
                "4. Aluguel/reserva quarto\n" +
                "5. Entra despesas extras\n" +
                "6. Calcula despesa do quarto\n" +
                "7. Sai\n" +
                "OPÇÃO:"
            ));

            switch(opcao) {
                case 1:
                    cadastraQuartos(quartos);
                    break;
                case 2:
                    listaTodosOsQuartos(quartos);
                    break;
                case 3:
                    listaQuartosOcupados(quartos);
                    break;
                case 4:
                    aluguelReservaQuarto(quartos);
                    break;
                case 5:
                    entraDespesasExtras(quartos);
                    break;
                case 6:
                    calculaDespesaDoQuarto(quartos);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while(opcao != 7);
    }

    private static void cadastraQuartos(Quarto[] quartos) {
        for (int i = 0; i < quartos.length; i++) {
            quartos[i].numero = i + 1;
            quartos[i].leitos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de leitos para o quarto " + (i + 1) + ":"));
            quartos[i].situacao = "livre";
            quartos[i].preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do quarto " + (i + 1) + ":"));
        }
        JOptionPane.showMessageDialog(null, "Quartos cadastrados com sucesso.");
    }

    private static void listaTodosOsQuartos(Quarto[] quartos) {
        StringBuilder lista = new StringBuilder();
        for (Quarto q : quartos) {
            lista.append("Quarto ").append(q.numero)
                 .append(": ").append("Leitos: ").append(q.leitos)
                 .append(", Preço: R$").append(q.preco)
                 .append(", Situação: ").append(q.situacao)
                 .append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void listaQuartosOcupados(Quarto[] quartos) {
        StringBuilder ocupados = new StringBuilder();
        for (Quarto q : quartos) {
            if (q.situacao.equals("alugado")) {
                ocupados.append("Quarto ").append(q.numero)
                        .append(": Leitos: ").append(q.leitos)
                        .append(", Preço: R$").append(q.preco)
                        .append(", Situação: ").append(q.situacao)
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, ocupados.length() > 0 ? ocupados.toString() : "Nenhum quarto ocupado.");
    }

    private static void aluguelReservaQuarto(Quarto[] quartos) {
        int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto que deseja alugar ou reservar:"));
        if (numeroQuarto <= 0 || numeroQuarto > quartos.length) {
            JOptionPane.showMessageDialog(null, "Número de quarto inválido.");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        if (quarto.situacao.equals("alugado")) {
            JOptionPane.showMessageDialog(null, "Quarto já está alugado.");
            return;
        }

        quarto.situacao = "alugado";
        quarto.dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada (formato: dd/MM/yyyy):");
        quarto.dataSaida = JOptionPane.showInputDialog("Digite a data de saída (formato: dd/MM/yyyy):");
        quarto.numeroDiarias = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de diárias:"));
        quarto.valorTotal = quarto.preco * quarto.numeroDiarias;
        JOptionPane.showMessageDialog(null, "Quarto alugado com sucesso. Valor total: R$" + quarto.valorTotal);
    }

    private static void entraDespesasExtras(Quarto[] quartos) {
        int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto ao qual deseja adicionar despesas extras:"));
        if (numeroQuarto <= 0 || numeroQuarto > quartos.length) {
            JOptionPane.showMessageDialog(null, "Número de quarto inválido.");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        double despesaExtra = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa extra:"));
        quarto.despesasExtras += despesaExtra;
        JOptionPane.showMessageDialog(null, "Despesa extra adicionada. Valor total de despesas extras agora: R$" + quarto.despesasExtras);
    }

    private static void calculaDespesaDoQuarto(Quarto[] quartos) {
        int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto para calcular a despesa:"));
        if (numeroQuarto <= 0 || numeroQuarto > quartos.length) {
            JOptionPane.showMessageDialog(null, "Número de quarto inválido.");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        double valorTotalPagar = quarto.valorTotal + quarto.despesasExtras;
        JOptionPane.showMessageDialog(null, "O valor total a ser pago pelo quarto " + quarto.numero + " é: R$" + valorTotalPagar);
    }
}
