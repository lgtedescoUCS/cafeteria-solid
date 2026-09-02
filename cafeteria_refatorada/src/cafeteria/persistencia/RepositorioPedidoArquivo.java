package cafeteria.persistencia;

import java.io.FileWriter;
import java.io.IOException;
import cafeteria.modelo.Pedido;

/**
 * Implementação que persiste em arquivo TXT (mesmo comportamento do
 * código original, agora ISOLADO em sua própria classe).
 */
public class RepositorioPedidoArquivo implements RepositorioPedido {

    private final String caminhoArquivo;

    public RepositorioPedidoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public void salvar(Pedido pedido) {
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
            writer.write("Pedido: " + pedido.getTipoBebida()
                       + " | Qtd: " + pedido.getQuantidade()
                       + " | Cliente: " + pedido.getTipoCliente()
                       + " | Total: " + pedido.getTotal() + "\n");
        } catch (IOException e) {
            // Em ambiente real: lançar exceção de domínio ou usar logger.
            // Aqui mantemos simples para fins didáticos.
            throw new RuntimeException("Falha ao gravar log de pedido", e);
        }
    }
}
