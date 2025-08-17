import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testFretePacAte1Kg() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.PAC);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 0.5));
        pedido.adicionarProduto(new Produto("Produto2", 20.0, 0.4));
        assertEquals("10.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testFretePacAte2Kg() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.PAC);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 1.2));
        pedido.adicionarProduto(new Produto("Produto2", 20.0, 0.7));
        assertEquals("15.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testFretePacExcede2Kg() {
        Pedido pedido = new Pedido(TipoDeEntrega.PAC);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 1.5));
        pedido.adicionarProduto(new Produto("Produto2", 20.0, 1.0));
        Exception exception = assertThrows(Exception.class, pedido::calculaPesoPedido);
        assertTrue(exception.getMessage().contains("não aceita este tipo de entrega"));
    }

    @Test
    public void testFreteSedexAte0_5Kg() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.SEDEX);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 0.3));
        assertEquals("12.5", pedido.calculaPesoPedido());
    }

    @Test
    public void testFreteSedexAte1Kg() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.SEDEX);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 0.7));
        assertEquals("20.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testFreteSedexAcima1Kg() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.SEDEX);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 1.3));
        assertEquals("51.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testFreteRetirada() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.RETIRADA);
        pedido.adicionarProduto(new Produto("Produto1", 10.0, 2.0));
        assertEquals("0.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testPedidoSemProdutos() throws Exception {
        Pedido pedido = new Pedido(TipoDeEntrega.PAC);
        assertEquals("10.0", pedido.calculaPesoPedido());
    }

    @Test
    public void testTipoDeEntregaInvalido() {
        Pedido pedido = new Pedido(null);
        Exception exception = assertThrows(Exception.class, pedido::calculaPesoPedido);
        assertTrue(exception.getMessage().contains("Tipo de entrega inválido"));
    }
}