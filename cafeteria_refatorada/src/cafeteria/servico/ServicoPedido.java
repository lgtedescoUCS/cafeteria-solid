package cafeteria.servico;

import cafeteria.apresentacao.NotificadorPedido;
import cafeteria.bebida.Bebida;
import cafeteria.desconto.PoliticaDesconto;
import cafeteria.modelo.Pedido;
import cafeteria.persistencia.RepositorioPedido;

/**
 * Núcleo de NEGÓCIO da cafeteria — responsável APENAS por orquestrar
 * o cálculo e a finalização de um pedido.
 *
 * SRP: tem uma única responsabilidade — coordenar o pedido.
 *      Preço da bebida, desconto, persistência e notificação são
 *      delegados a colaboradores.
 *
 * OCP: novas bebidas e novas políticas de desconto são adicionadas
 *      sem alterar esta classe.
 *
 * DIP: depende somente de ABSTRAÇÕES (Bebida, PoliticaDesconto,
 *      RepositorioPedido, NotificadorPedido). Não conhece TXT,
 *      SQL, System.out ou qualquer detalhe de infraestrutura.
 *
 * Note que esta classe NÃO MUDA nos três cenários propostos.
 */
public class ServicoPedido {

    private final RepositorioPedido repositorio;
    private final NotificadorPedido notificador;

    public ServicoPedido(RepositorioPedido repositorio, NotificadorPedido notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public Pedido processar(Bebida bebida, int quantidade, String tipoCliente,
                            PoliticaDesconto desconto) {
        double subtotal = bebida.getPrecoBase() * quantidade;
        double total = desconto.aplicar(subtotal);

        Pedido pedido = new Pedido(bebida.getNome(), quantidade, tipoCliente, total);
        repositorio.salvar(pedido);
        notificador.notificar(pedido);
        return pedido;
    }
}
