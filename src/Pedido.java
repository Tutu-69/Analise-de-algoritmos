import java.util.ArrayList;

public class Pedido {

    private ArrayList<Produto> listaDePedidos;
    private TipoDeEntrega tipoDeEntrega;

    public Pedido(TipoDeEntrega tipoDeEntrega, Produto produto) {
        listaDePedidos = new ArrayList<>();
    }

    private double valorDoProduto(Produto produto) throws Exception {
        double pesoProduto = produto.getPeso();
        double valorDoFrete = 0;
        switch (this.tipoDeEntrega) {
            case PAC:
                if (produto.getPeso() <= 1) {
                    valorDoFrete = 10.0;
                }
                if (produto.getPeso() > 1 && produto.getPeso() <= 2) {
                    valorDoFrete = 15.0;
                }
                if (produto.getPeso() > 2) {
                    throw new Exception("não aceita este tipo de entrega");
                }
                break;
            case SEDEX:
                if (produto.getPeso() <= 0.5) {
                    valorDoFrete = 12.5;
                }
                if (produto.getPeso() > 0.5 && produto.getPeso() <= 1) {
                    valorDoFrete = 20.0;
                }
                if (produto.getPeso() > 1) {
                    valorDoFrete = 46.5;
                }
                break;

        }
        return 0;

    }

    public double valorTotalDeTodosOsProdutos() {
        return 0;
    }

}
