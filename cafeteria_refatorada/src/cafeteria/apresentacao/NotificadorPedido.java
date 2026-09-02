package cafeteria.apresentacao;

import cafeteria.modelo.Pedido;

/**
 * Abstração de apresentação. Separa a regra de negócio do canal por
 * onde o resultado é comunicado ao usuário (console, tela do totem,
 * impressora de cupom, app mobile etc.).
 */
public interface NotificadorPedido {
    void notificar(Pedido pedido);
}
