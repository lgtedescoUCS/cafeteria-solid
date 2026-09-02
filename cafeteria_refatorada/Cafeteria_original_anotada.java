package cafeteria;

import java.io.FileWriter;
import java.io.IOException;

/**
 * VIOLAÇÃO DE SRP (Single Responsibility Principle):
 * Esta classe tem MÚLTIPLAS responsabilidades:
 *   1. Definir preço de bebidas
 *   2. Aplicar regras de desconto por tipo de cliente
 *   3. Calcular total
 *   4. Exibir resultado no console (apresentação)
 *   5. Persistir log em arquivo TXT (infraestrutura)
 *
 * Cada uma dessas responsabilidades é um motivo diferente para a classe mudar.
 */
public class Cafeteria {

    public void processarPedido(String tipoBebida, int quantidade, String tipoCliente) {
        double precoBase = 0;

        // VIOLAÇÃO DE OCP (Open/Closed Principle):
        // Para adicionar "Frappuccino", "Mocha", "Chocolate Quente" etc.,
        // é OBRIGATÓRIO ABRIR e MODIFICAR este método.
        // A classe não está fechada para modificação.
        if (tipoBebida.equalsIgnoreCase("Cafe")) {
            precoBase = 10.0;
        } else if (tipoBebida.equalsIgnoreCase("Capuccino")) {
            precoBase = 15.5;
        } else if (tipoBebida.equalsIgnoreCase("Cha")) {
            precoBase = 8.0;
        }
        // Bebida não cadastrada resulta silenciosamente em preço 0.

        double total = precoBase * quantidade;

        // VIOLAÇÃO DE OCP novamente:
        // Cada novo tipo de cliente (Aluno, Funcionário, VIP) exige
        // modificar este bloco. Regras de desconto são "hard-coded".
        if (tipoCliente.equalsIgnoreCase("Professor")) {
            total = total * 0.8; // 20% de desconto
        }

        // VIOLAÇÃO DE SRP:
        // A classe de negócio não deveria conhecer System.out.
        // Isso é responsabilidade da camada de apresentação.
        System.out.println("Total do pedido: R$ " + total);

        // VIOLAÇÃO DE SRP + DIP (Dependency Inversion Principle):
        // A classe Cafeteria depende DIRETAMENTE de uma implementação concreta
        // de baixo nível (FileWriter). Não há abstração entre a regra de
        // negócio e o mecanismo de persistência.
        //
        // VIOLAÇÃO DE OCP:
        // Para trocar TXT por banco SQL, JSON, API REST, fila de mensagens,
        // somos forçados a alterar a classe de negócio.
        try {
            FileWriter writer = new FileWriter("log_pedidos.txt", true);
            writer.write("Pedido: " + tipoBebida + " | Total: " + total + "\n");
            writer.close();
            System.out.println("Pedido salvo no arquivo com sucesso.");
        } catch (IOException e) {
            // Mensagem de erro também é apresentação misturada com negócio.
            System.out.println("Erro crítico no sistema de arquivos!");
        }
    }

    public static void main(String[] args) {
        Cafeteria sistema = new Cafeteria();
        sistema.processarPedido("Capuccino", 2, "Professor");
    }
}
