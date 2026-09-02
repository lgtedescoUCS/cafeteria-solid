package cafeteria;

import cafeteria.apresentacao.NotificadorPedido;
import cafeteria.apresentacao.NotificadorPedidoConsole;
import cafeteria.bebida.Capuccino;
import cafeteria.bebida.Frappuccino;
import cafeteria.desconto.DescontoProfessor;
import cafeteria.desconto.SemDesconto;
import cafeteria.persistencia.RepositorioPedido;
import cafeteria.persistencia.RepositorioPedidoArquivo;
import cafeteria.persistencia.RepositorioPedidoNulo;
import cafeteria.persistencia.RepositorioPedidoSQL;
import cafeteria.servico.ServicoPedido;

public class Main {

    public static void main(String[] args) {
        NotificadorPedido tela = new NotificadorPedidoConsole();

        // --- Cenário base: balcão da cafeteria, log em TXT ---
        RepositorioPedido emArquivo = new RepositorioPedidoArquivo("log_pedidos.txt");
        ServicoPedido balcao = new ServicoPedido(emArquivo, tela);
        balcao.processar(new Capuccino(), 2, "Professor", new DescontoProfessor());

        // --- Cenário 1: troca para SQL. ServicoPedido NÃO MUDA. ---
        RepositorioPedido emSQL = new RepositorioPedidoSQL();
        ServicoPedido balcaoSQL = new ServicoPedido(emSQL, tela);
        balcaoSQL.processar(new Capuccino(), 2, "Professor", new DescontoProfessor());

        // --- Cenário 2: nova bebida Frappuccino. Nenhum 'if' foi tocado. ---
        balcao.processar(new Frappuccino(), 1, "Comum", new SemDesconto());

        // --- Cenário 3: totem de autoatendimento, SEM log em arquivo. ---
        RepositorioPedido semLog = new RepositorioPedidoNulo();
        ServicoPedido totem = new ServicoPedido(semLog, tela);
        totem.processar(new Frappuccino(), 1, "Comum", new SemDesconto());
    }
}
