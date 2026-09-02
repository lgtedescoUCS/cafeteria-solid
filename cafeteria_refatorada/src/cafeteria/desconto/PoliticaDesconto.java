package cafeteria.desconto;

/**
 * Strategy de desconto. Permite acomodar novas políticas
 * (Aluno, Funcionário, VIP, Cupom promocional) sem alterar a regra
 * de cálculo do pedido.
 */
public interface PoliticaDesconto {
    double aplicar(double subtotal);
}
