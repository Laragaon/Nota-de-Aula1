import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public void realizarVenda(int codigoProduto, int quantidade, Pagamento.MetodoPagamento metodoPagamento, double valorPago) {
        Produto produto = buscarProdutoPorCodigo(codigoProduto);
        if (produto != null && produto.getQuantidadeEstoque() >= quantidade) {
            double valorTotal = produto.getValor() * quantidade;
            valorTotal = Pagamento.calcularDesconto(valorTotal, metodoPagamento);

            System.out.printf("Valor total com desconto: R$ %.2f\n", valorTotal);

            if (metodoPagamento == Pagamento.MetodoPagamento.CREDITO) {
                Pagamento.calcularParcelamento(valorTotal);
            } else if (metodoPagamento == Pagamento.MetodoPagamento.ESPECIE && valorPago > valorTotal) {
                double troco = Pagamento.calcularTroco(valorPago, valorTotal);
                System.out.printf("Troco: R$ %.2f\n", troco);
            }

            produto.atualizarEstoque(quantidade);
            System.out.println("Venda realizada com sucesso.");
        } else {
            System.out.println("Produto indisponível ou quantidade insuficiente em estoque.");
        }
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
