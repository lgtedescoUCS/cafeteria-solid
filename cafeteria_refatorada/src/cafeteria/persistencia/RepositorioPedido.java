package cafeteria.persistencia;

import cafeteria.modelo.Pedido;

/**
 * Abstração de persistência. Resolve a violação de DIP da classe original:
 * a regra de negócio passa a depender desta interface (alto nível),
 * NÃO de FileWriter, Connection JDBC, HttpClient etc. (baixo nível).
 *
 * Cenário de Mudança 1: trocar TXT por SQL é criar uma nova classe que
 * implemente esta interface. A classe de negócio NÃO MUDA.
 *
 * Cenário de Mudança 3: o totem de autoatendimento pode injetar uma
 * implementação que não escreve em lugar nenhum (Null Object) — ou
 * usar uma implementação diferente (ex.: envio para servidor central).
 */
public interface RepositorioPedido {
    void salvar(Pedido pedido);
}
