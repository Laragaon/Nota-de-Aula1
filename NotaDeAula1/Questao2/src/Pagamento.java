public class Pagamento {
    public enum MetodoPagamento {
        PIX, ESPECIE, TRANSFERENCIA, DEBITO, CREDITO
    }

    public static double calcularDesconto(double valor, MetodoPagamento metodo) {
        if (metodo == MetodoPagamento.PIX || metodo == MetodoPagamento.ESPECIE
                || metodo == MetodoPagamento.TRANSFERENCIA || metodo == MetodoPagamento.DEBITO) {
            return valor * 0.95; // 5% de desconto
        }
        return valor;
    }

    public static void calcularParcelamento(double valor) {
        double parcela = valor / 3;
        System.out.printf("Valor parcelado em 3x sem juros: R$ %.2f cada parcela\n", parcela);
    }

    public static double calcularTroco(double valorPago, double valorProduto) {
        return valorPago - valorProduto;
    }
}
