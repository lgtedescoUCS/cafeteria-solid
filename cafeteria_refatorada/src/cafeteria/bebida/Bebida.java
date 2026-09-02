package cafeteria.bebida;

/**
 * Abstração de bebida. Resolve a violação de OCP:
 * para adicionar Frappuccino, Mocha, etc., basta criar uma nova classe
 * que implemente esta interface — nenhuma classe existente é modificada.
 */
public interface Bebida {
    String getNome();
    double getPrecoBase();
}
