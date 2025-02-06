import javax.swing.JOptionPane;

class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class FilaDinamica {
    private No inicio; 
    private No fim;   

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void adicionar(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        JOptionPane.showMessageDialog(null, dado + " Foi Adicionado Na Fila.");
    }

    public void remover() {
        if (estaVazia()) {
            JOptionPane.showMessageDialog(null, "A Fila Está Vazia. Não É Possível Remover.");
            return;
        }
        int dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        JOptionPane.showMessageDialog(null, dado + " Foi Removido Da Fila.");
    }

    public void exibir() {
        if (estaVazia()) {
            JOptionPane.showMessageDialog(null, "A Fila Está Vazia.");
            return;
        }
        No temp = inicio;
        StringBuilder elementos = new StringBuilder("Elementos Na Fila: ");
        while (temp != null) {
            elementos.append(temp.dado).append(" ");
            temp = temp.proximo;
        }
        JOptionPane.showMessageDialog(null, elementos.toString());
    }
}
