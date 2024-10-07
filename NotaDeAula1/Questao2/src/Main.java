import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        // Exemplo de cadastro de produtos
        estoque.cadastrarProduto(new Produto(1, "Camiseta", "M", "Azul", 50.0, 10));
        estoque.cadastrarProduto(new Produto(2, "Tênis", "42", "Branco", 150.0, 5));

        System.out.println("Produtos cadastrados:");
        estoque.listarProdutos();

        // Simulação de venda
        System.out.println("\nRealizar venda:");
        System.out.print("Digite o código do produto: ");
        int codigoProduto = scanner.nextInt();
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        System.out.print("Escolha o método de pagamento (1-PIX, 2-Espécie, 3-Transferência, 4-Débito, 5-Crédito): ");
        int metodo = scanner.nextInt();

        Pagamento.MetodoPagamento metodoPagamento = Pagamento.MetodoPagamento.values()[metodo - 1];

        double valorPago = 0;
        if (metodoPagamento == Pagamento.MetodoPagamento.ESPECIE) {
            System.out.print("Digite o valor pago: ");
            valorPago = scanner.nextDouble();
        }

        estoque.realizarVenda(codigoProduto, quantidade, metodoPagamento, valorPago);

        System.out.println("\nEstoque atualizado:");
        estoque.listarProdutos();
    }

        }
