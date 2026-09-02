package cafeteria.modelo;

/**
 * Representa um pedido finalizado, já com total calculado.
 * Modelo de domínio anêmico — apenas dados. É consumido pelas camadas
 * de persistência e apresentação sem que elas precisem conhecer a lógica
 * de cálculo.
 */
public class Pedido {

    private final String tipoBebida;
    private final int quantidade;
    private final String tipoCliente;
    private final double total;

    public Pedido(String tipoBebida, int quantidade, String tipoCliente, double total) {
        this.tipoBebida = tipoBebida;
        this.quantidade = quantidade;
        this.tipoCliente = tipoCliente;
        this.total = total;
    }

    public String getTipoBebida() { return tipoBebida; }
    public int getQuantidade() { return quantidade; }
    public String getTipoCliente() { return tipoCliente; }
    public double getTotal() { return total; }
}
