package cafeteria.persistencia;

import cafeteria.modelo.Pedido;

/**
 * Cenário de Mudança 1: persistência em banco SQL.
 *
 * Esqueleto demonstrativo. Em produção, este construtor receberia uma
 * DataSource (ou EntityManager / JdbcTemplate) e o método salvar()
 * executaria um INSERT preparado. O ponto-chave é:
 *
 *     A classe de negócio (ServicoPedido) NÃO MUDA UMA LINHA SEQUER
 *     para trocar de TXT para SQL. Basta injetar esta implementação
 *     no lugar de RepositorioPedidoArquivo.
 */
public class RepositorioPedidoSQL implements RepositorioPedido {

    // Em produção: private final DataSource dataSource;

    public RepositorioPedidoSQL(/* DataSource dataSource */) {
        // this.dataSource = dataSource;
    }

    @Override
    public void salvar(Pedido pedido) {
        // Pseudo-código:
        // try (Connection c = dataSource.getConnection();
        //      PreparedStatement ps = c.prepareStatement(
        //          "INSERT INTO pedido (bebida, qtd, cliente, total) VALUES (?,?,?,?)")) {
        //     ps.setString(1, pedido.getTipoBebida());
        //     ps.setInt(2, pedido.getQuantidade());
        //     ps.setString(3, pedido.getTipoCliente());
        //     ps.setDouble(4, pedido.getTotal());
        //     ps.executeUpdate();
        // } catch (SQLException e) {
        //     throw new RuntimeException("Falha ao gravar pedido no SQL", e);
        // }
        System.out.println("[SQL] INSERT pedido: " + pedido.getTipoBebida()
                + " total=" + pedido.getTotal());
    }
}
