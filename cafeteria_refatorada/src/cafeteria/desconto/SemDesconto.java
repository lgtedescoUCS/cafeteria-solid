package cafeteria.desconto;

public class SemDesconto implements PoliticaDesconto {
    @Override
    public double aplicar(double subtotal) {
        return subtotal;
    }
}
