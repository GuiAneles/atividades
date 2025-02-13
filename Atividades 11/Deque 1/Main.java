import javax.swing.JOptionPane;

public class Main {
    private static final int CAPACIDADE_ESTACIONAMENTO = 10;
    private static Deque estacionamento = new Deque(CAPACIDADE_ESTACIONAMENTO);
    private static Deque filaEspera = new Deque(100);

    public static void main(String[] args) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(
                "Digite A Operacao E A Placa (Ex: C ABC1234 Ou P ABC1234):\n" +
                "C - Chegada\n" +
                "P - Partida\n" +
                "S - Sair"
            );

            if (entrada == null || entrada.equalsIgnoreCase("S")) {
                break;
            }

            String[] partes = entrada.split(" ");
            if (partes.length < 2) {
                System.out.println("Entrada Invalida! Use O Formato: C ABC1234 Ou P ABC1234.");
                continue;
            }

            char operacao = partes[0].toUpperCase().charAt(0);
            String placa = partes[1].toUpperCase();

            if (operacao == 'C') {
                if (estacionamento.contem(placa) || filaEspera.contem(placa)) {
                    System.out.println("Carro " + placa + " Ja Esta No Estacionamento Ou Na Fila De Espera.");
                } else if (!estacionamento.estaCheio()) {
                    estacionamento.inserirFim(placa);
                    System.out.println("Carro " + placa + " Estacionado.");
                } else {
                    filaEspera.inserirFim(placa);
                    System.out.println("Carro " + placa + " Aguardando Vaga.");
                }
            } else if (operacao == 'P') {
                if (estacionamento.contem(placa)) {
                    int deslocamentos = estacionamento.removerValor(placa);
                    System.out.println("Carro " + placa + " Saiu. Foi Deslocado " + deslocamentos + " Vezes.");
                } else if (filaEspera.contem(placa)) {
                    filaEspera.removerValor(placa);
                    System.out.println("Carro " + placa + " Saiu Da Fila De Espera. Foi Deslocado 0 Vezes.");
                } else {
                    System.out.println("Carro " + placa + " Nao Esta No Estacionamento Ou Na Fila De Espera.");
                }
            } else {
                System.out.println("Operacao Invalida: " + operacao);
            }

            while (!filaEspera.estaVazio() && !estacionamento.estaCheio()) {
                String proximoCarro = filaEspera.removerInicio();
                estacionamento.inserirFim(proximoCarro);
                System.out.println("Carro " + proximoCarro + " Estacionado (Da Fila De Espera).");
            }
        }
    }
}
