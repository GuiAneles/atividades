import javax.swing.JOptionPane;

public class ControleEstoqueVendas {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[50];
        int k = 0;
        int codi;
        double geral = 0.0;
        
        while (k < 50) {
            String s = JOptionPane.showInputDialog("Digite O Código Do Produto Ou 0 Para Finalizar:");
            codi = Integer.parseInt(s);
            
            if (codi == 0) {
                JOptionPane.showMessageDialog(null, "Cadastro De Produtos Finalizado.");
                break;
            }

            s = JOptionPane.showInputDialog("Digite A Quantidade Do Produto:");
            int quantidade = Integer.parseInt(s);
            
            s = JOptionPane.showInputDialog("Digite O Preço De Venda Do Produto:");
            double precoVenda = Double.parseDouble(s);
            
            produtos[k] = new Produto();
            produtos[k].codigo = codi;
            produtos[k].quantidadeEstoque = quantidade;
            produtos[k].precoVenda = precoVenda;
            produtos[k].totalVendido = 0;
            k++;
        }

        while (true) {
            String s = JOptionPane.showInputDialog("Digite O Código Do Produto A Ser Vendido (0 Para Terminar):");
            codi = Integer.parseInt(s);
            
            if (codi == 0) {
                break;
            }

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

            if (produtoVendido != null) {
                s = JOptionPane.showInputDialog("Digite A Quantidade A Ser Vendida:");
                int quantidade = Integer.parseInt(s);
                
                if (quantidade <= produtoVendido.quantidadeEstoque) {
                    produtoVendido.quantidadeEstoque -= quantidade;
                    produtoVendido.totalVendido += quantidade;
                    geral += quantidade * produtoVendido.precoVenda;
                    JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Estoque Insuficiente");
                }
            }
        }

        String resultado = "Relatório De Vendas e Estoque:\n";
        
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (produtos[i].quantidadeEstoque < produtos[j].quantidadeEstoque) {
                    Produto temp = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = temp;
                }
            }
        }
        
        for (int i = 0; i < k; i++) {
            resultado += "Código: " + produtos[i].codigo + "\n" +
                         "Estoque: " + produtos[i].quantidadeEstoque + "\n" +
                         "Preço: R$ " + produtos[i].precoVenda + "\n" +
                         "Total Vendido: " + produtos[i].totalVendido + " Unidades\n\n";
        }

        resultado += "Total De Vendas No Dia: R$ " + geral;
        
        JOptionPane.showMessageDialog(null, resultado);
    }
}
