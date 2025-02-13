public class Deque {
    private class No {
        String valor;
        No anterior;
        No proximo;

        public No(String valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;
    private int capacidadeMaxima;
    private int tamanhoAtual;

    public Deque(int capacidadeMaxima) {
        this.inicio = null;
        this.fim = null;
        this.capacidadeMaxima = capacidadeMaxima;
        this.tamanhoAtual = 0;
    }

    public void inserirInicio(String valor) {
        if (tamanhoAtual >= capacidadeMaxima) {
            System.out.println("Estacionamento Cheio!");
            return;
        }
        No novo = new No(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanhoAtual++;
    }

    public void inserirFim(String valor) {
        if (tamanhoAtual >= capacidadeMaxima) {
            System.out.println("Estacionamento Cheio!");
            return;
        }
        No novo = new No(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }
        tamanhoAtual++;
    }

    public String removerInicio() {
        if (inicio == null) {
            return null;
        }
        String valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }
        tamanhoAtual--;
        return valor;
    }

    public String removerFim() {
        if (fim == null) {
            return null;
        }
        String valor = fim.valor;
        fim = fim.anterior;
        if (fim != null) {
            fim.proximo = null;
        } else {
            inicio = null;
        }
        tamanhoAtual--;
        return valor;
    }

    public boolean estaVazio() {
        return inicio == null;
    }

    public boolean estaCheio() {
        return tamanhoAtual >= capacidadeMaxima;
    }

    public boolean contem(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int removerValor(String valor) {
        No atual = inicio;
        int deslocamentos = 0;

        while (atual != null && !atual.valor.equals(valor)) {
            atual = atual.proximo;
            deslocamentos++;
        }

        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                inicio = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            } else {
                fim = atual.anterior;
            }
            deslocamentos++;
        }

        return deslocamentos;
    }

    public boolean contemValor(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
}
