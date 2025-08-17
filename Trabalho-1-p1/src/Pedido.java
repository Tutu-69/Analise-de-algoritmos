import java.util.ArrayList;

public class Pedido {

    private ArrayList<Produto> listaDeProdutos;
    private TipoDeEntrega tipoDeEntrega;

    public Pedido(TipoDeEntrega tipoDeEntrega) {
        this.listaDeProdutos = new ArrayList<>();
        this.tipoDeEntrega = tipoDeEntrega;
    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
    }

    public String calculaPesoPedido() throws Exception {
        double pesoTotal = 0;
        for (Produto produto : listaDeProdutos) {
            pesoTotal += produto.getPeso();
        }
        return String.valueOf(valorFretePedido(pesoTotal));
    }

    private double valorFretePedido(double pesoTotal) throws Exception {
        if (this.tipoDeEntrega == null) {
            throw new Exception("Tipo de entrega inválido");
        }
        switch (this.tipoDeEntrega) {
            case PAC:
                return fretePac(pesoTotal);
            case SEDEX:
                return freteSedex(pesoTotal);
            case RETIRADA:
                return freteRetirada();
            default:
                throw new Exception("Tipo de entrega inválido");
        }
    }

    private double fretePac(double pesoTotal) throws Exception {
        if (pesoTotal <= 1) {
            return 10.0;
        } else if (pesoTotal <= 2) {
            return 15.0;
        } else {
            throw new Exception("não aceita este tipo de entrega");
        }
    }

    private double freteSedex(double pesoTotal) throws Exception {
        if (pesoTotal <= 0.5) {
            return 12.5;
        } else if (pesoTotal <= 1) {
            return 20.0;
        } else {
            double valorFrete = 46.5;
            double excessoKg = pesoTotal - 1.0;
            int blocos100g = (int) Math.floor(excessoKg * 10);
            return valorFrete += blocos100g * 1.5;
        }
    }

    private double freteRetirada() throws Exception {
        return 0.0;
    }
}
