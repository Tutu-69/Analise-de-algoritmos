/*
Imagine que uma livraria vai iniciar suas vendas pela internet, porém o dono precisa de um sistema que o ajude a
calcular o valor da entrega dos seus pedidos. Um pedido pode ter diversos produtos. Um produto possui nome, valor e
peso. A livraria pretende trabalhar com três modalidades de entrega, sendo elas:
 */

public class App {
    public static void main(String[] args) throws Exception {
        Produto livro = new Produto("Livro de Java", 59.90, 1.2);
        Produto revista = new Produto("Revista de Tecnologia", 19.90, 0.5);
        Produto caderno = new Produto("Caderno", 29.90, 0.8);

        Pedido pedido1 = new Pedido(TipoDeEntrega.SEDEX);
        pedido1.adicionarProduto(livro);
        pedido1.adicionarProduto(revista);
        pedido1.adicionarProduto(caderno);

        System.out.println("Valor total do pedido 1: " + pedido1.calculaPesoPedido());
    }
}