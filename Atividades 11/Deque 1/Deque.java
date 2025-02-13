class Deque {
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
    private int tamanho;
    private int capacidade;

    public Deque(int capacidade) {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        this.capacidade = capacidade;
    }

    public void inserirFim(String valor) {
        if (tamanho >= capacidade) return;
        No novo = new No(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }
        tamanho++;
    }

    public String removerInicio() {
        if (inicio == null) return null;
        String valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }
        tamanho--;
        return valor;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public boolean estaCheio() {
        return tamanho >= capacidade;
    }

    public boolean contem(String valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) return true;
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
            tamanho--;
        }

        return deslocamentos;
    }
}
