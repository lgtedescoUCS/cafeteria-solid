package cafeteria.apresentacao;

import cafeteria.modelo.Pedido;

public class NotificadorPedidoConsole implements NotificadorPedido {
    @Override
    public void notificar(Pedido pedido) {
        System.out.printf("Total do pedido: R$ %.2f%n", pedido.getTotal());
    }
}
