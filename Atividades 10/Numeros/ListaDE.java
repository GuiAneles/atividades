class No {
    int valor;
    No anterior;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDE {
    private No inicio;
    private No fim;

    public ListaDE() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirOrdenado(int valor) {
        No novoNo = new No(valor);

        if (inicio == null) {
            inicio = fim = novoNo;
        } else if (valor <= inicio.valor) {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        } else if (valor >= fim.valor) {
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
        } else {
            No atual = inicio;
            while (atual != null && atual.valor < valor) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual;
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
        }
    }

    public void imprimirCrescente() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void imprimirDecrescente() {
        No atual = fim;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }

    public void removerPrimos() {
        No atual = inicio;
        while (atual != null) {
            if (ehPrimo(atual.valor)) {
                if (atual == inicio) {
                    inicio = atual.proximo;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (atual == fim) {
                    fim = atual.anterior;
                    if (fim != null) {
                        fim.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
            }
            atual = atual.proximo;
        }
    }

    private boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
