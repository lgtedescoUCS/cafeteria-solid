package cafeteria.persistencia;

import cafeteria.modelo.Pedido;

/**
 * Cenário de Mudança 3: Totem de Autoatendimento.
 *
 * Implementação "Null Object" — não persiste nada, simplesmente descarta.
 * O totem injeta esta classe no ServicoPedido e ganha o mesmo
 * comportamento de negócio SEM gerar arquivo de log.
 *
 * Alternativa equivalente: o totem injetaria uma implementação que
 * envia o pedido por HTTP para o servidor central da cafeteria.
 */
public class RepositorioPedidoNulo implements RepositorioPedido {
    @Override
    public void salvar(Pedido pedido) {
        // Intencionalmente vazio.
    }
}
