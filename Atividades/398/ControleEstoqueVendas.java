import javax.swing.JOptionPane;

public class ControleEstoqueVendas {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[50]; // Vetor para armazenar até 50 produtos
        int k = 0; // Contador de produtos cadastrados
        int codi;
        double geral = 0.0;
        
        // Fase 1: Cadastro de produtos
        while (k < 50) {
            String s = JOptionPane.showInputDialog("Digite O Código Do Produto Ou 0 Para Finalizar:");
            codi = Integer.parseInt(s);
            
            if (codi == 0) {
                JOptionPane.showMessageDialog(null, "Cadastro De Produtos Finalizado.");
                break; // Finaliza o cadastro se o código for 0
            }

            s = JOptionPane.showInputDialog("Digite A Quantidade Do Produto:");
            int quantidade = Integer.parseInt(s);
            
            s = JOptionPane.showInputDialog("Digite O Preço De Venda Do Produto:");
            double precoVenda = Double.parseDouble(s);
            
            // Cria um novo objeto Produto e armazena no vetor
            produtos[k] = new Produto();
            produtos[k].codigo = codi;
            produtos[k].quantidadeEstoque = quantidade;
            produtos[k].precoVenda = precoVenda;
            produtos[k].totalVendido = 0;
            k++;
        }

        // Fase 2: Vendas
        while (true) {
            String s = JOptionPane.showInputDialog("Digite O Código Do Produto A Ser Vendido (0 Para Terminar):");
            codi = Integer.parseInt(s);
            
            if (codi == 0) {
                break; // Finaliza as vendas se o código for 0
            }

            // Procura o produto cadastrado pelo código
            boolean produtoEncontrado = false;
            Produto produtoVendido = null;
            for (int i = 0; i < k; i++) {
                if (produtos[i].codigo == codi) {
                    produtoVendido = produtos[i];
                    produtoEncontrado = true;
                    break;
                }
            }

            if (!produtoEncontrado) {
                JOptionPane.showMessageDialog(null, "Produto Não-Cadastrado");
                continue;
            }

            // Verificação se o produtoVendido não é null antes de acessar seus atributos
            if (produtoVendido != null) {
                // Leitura da quantidade de produto a ser vendida
                s = JOptionPane.showInputDialog("Digite A Quantidade A Ser Vendida:");
                int quantidade = Integer.parseInt(s);
                
                // Verifica se há estoque suficiente
                if (quantidade <= produtoVendido.quantidadeEstoque) {
                    produtoVendido.quantidadeEstoque -= quantidade; // Atualiza o estoque
                    produtoVendido.totalVendido += quantidade; // Atualiza o total vendido
                    geral += quantidade * produtoVendido.precoVenda; // Calcula o total de vendas
                    JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Estoque Insuficiente");
                }
            }
        }

        // Fase 3: Exibição do total vendido e do estoque
        String resultado = "Relatório De Vendas e Estoque:\n";
        
        // Ordenando os produtos por quantidade em estoque (ordem decrescente)
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (produtos[i].quantidadeEstoque < produtos[j].quantidadeEstoque) {
                    Produto temp = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = temp;
                }
            }
        }
        
        // Exibindo os produtos e suas quantidades
        for (int i = 0; i < k; i++) {
            resultado += "Código: " + produtos[i].codigo + "\n" +
                         "Estoque: " + produtos[i].quantidadeEstoque + "\n" +
                         "Preço: R$ " + produtos[i].precoVenda + "\n" +
                         "Total Vendido: " + produtos[i].totalVendido + " Unidades\n\n";
        }

        resultado += "Total De Vendas No Dia: R$ " + geral;
        
        JOptionPane.showMessageDialog(null, resultado); // Exibe o relatório
    }
}