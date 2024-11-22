import javax.swing.JOptionPane;

public class ReservasPassagem {
    public static void main(String[] args) {
        // Leitura do número de vôos e a quantidade de lugares disponíveis
        int numVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite O Número De Bôos Disponíveis:"));
        Voo[] voos = new Voo[numVoo];

        for (int i = 0; i < numVoo; i++) {
            int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite O Número Do Vôo " + (i + 1) + ":"));
            int lugares = Integer.parseInt(JOptionPane.showInputDialog("Digite O Número De Lugares Disponíveis Para O Bôo " + numeroVoo + ":"));
            voos[i] = new Voo(numeroVoo, lugares); // Cria o objeto Voo e armazena no vetor
        }

        // Reservas de passagem
        while (true) {
            // Leitura do número da identidade e do número do vôo desejado
            String identidade = JOptionPane.showInputDialog("Digite O Número Da Identidade Do Cliente ('sair' Para Encerrar):");

            if ("sair".equalsIgnoreCase(identidade)) {
                break; // Encerra o loop se o usuário digitar "sair"
            }

            int numeroVooDesejado = Integer.parseInt(JOptionPane.showInputDialog("Digite O Número Do Vôo Desejado:"));

            // Verificação se o vôo existe e se há lugares disponíveis
            boolean reservaRealizada = false;

            for (int i = 0; i < numVoo; i++) {
                if (voos[i].numeroVoo == numeroVooDesejado) {
                    if (voos[i].lugaresDisponiveis > 0) {
                        // Realiza a reserva e atualiza o número de lugares disponíveis
                        voos[i].lugaresDisponiveis--;
                        JOptionPane.showMessageDialog(null, "Reserva Realizada Com Sucesso! \n Identidade: " + identidade + "\n Vôo: " + numeroVooDesejado);
                        reservaRealizada = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não Há Lugares Disponíveis Para O Bôo " + numeroVooDesejado);
                        reservaRealizada = true;
                        break;
                    }
                }
            }

            if (!reservaRealizada) {
                JOptionPane.showMessageDialog(null, "Vôo Não Encontrado. Tente Novamente.");
            }
        }
    }
}