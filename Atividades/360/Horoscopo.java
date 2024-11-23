import javax.swing.JOptionPane;

public class Horoscopo {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[100];
        int contador = 0;

        while (true) {
            String data = JOptionPane.showInputDialog("Digite A Data de Nascimento No Formato ddmm (9999 Para Terminar): ");

            if (data.equals("9999")) {
                break;
            }

            pessoas[contador] = new Pessoa();
            pessoas[contador].dataNascimento = data;

            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(2, 4));

            if ((dia >= 21 && mes == 3) || (dia <= 19 && mes == 4)) {
                pessoas[contador].signo = "Áries";
            } else if ((dia >= 20 && mes == 4) || (dia <= 20 && mes == 5)) {
                pessoas[contador].signo = "Touro";
            } else if ((dia >= 21 && mes == 5) || (dia <= 20 && mes == 6)) {
                pessoas[contador].signo = "Gêmeos";
            } else if ((dia >= 21 && mes == 6) || (dia <= 22 && mes == 7)) {
                pessoas[contador].signo = "Câncer";
            } else if ((dia >= 23 && mes == 7) || (dia <= 22 && mes == 8)) {
                pessoas[contador].signo = "Leão";
            } else if ((dia >= 23 && mes == 8) || (dia <= 22 && mes == 9)) {
                pessoas[contador].signo = "Virgem";
            } else if ((dia >= 23 && mes == 9) || (dia <= 22 && mes == 10)) {
                pessoas[contador].signo = "Libra";
            } else if ((dia >= 23 && mes == 10) || (dia <= 21 && mes == 11)) {
                pessoas[contador].signo = "Escorpião";
            } else if ((dia >= 22 && mes == 11) || (dia <= 21 && mes == 12)) {
                pessoas[contador].signo = "Sagitário";
            } else if ((dia >= 22 && mes == 12) || (dia <= 19 && mes == 1)) {
                pessoas[contador].signo = "Capricórnio";
            } else if ((dia >= 20 && mes == 1) || (dia <= 18 && mes == 2)) {
                pessoas[contador].signo = "Aquário";
            } else if ((dia >= 19 && mes == 2) || (dia <= 20 && mes == 3)) {
                pessoas[contador].signo = "Peixes";
            } else {
                pessoas[contador].signo = "Data Inválida";
            }

            contador++;
        }

        // Exibe o horóscopo de todas as pessoas cadastradas
        String resultado = "Horóscopo Das Pessoas Cadastradas:\n";
        for (int i = 0; i < contador; i++) {
            resultado += "Data de Nascimento: " + pessoas[i].dataNascimento + "\n";
            resultado += "Signo: " + pessoas[i].signo + "\n\n";
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe a listagem
    }
}
