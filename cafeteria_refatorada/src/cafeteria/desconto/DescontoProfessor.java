package cafeteria.desconto;

public class DescontoProfessor implements PoliticaDesconto {
    private static final double PERCENTUAL = 0.20;

    @Override
    public double aplicar(double subtotal) {
        return subtotal * (1.0 - PERCENTUAL);
    }
}
