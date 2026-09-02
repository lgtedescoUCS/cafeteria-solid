package cafeteria.bebida;

/**
 * Cenário de Mudança 2: nova bebida.
 * Note como adicionamos um item ao cardápio SEM modificar nenhuma classe
 * existente — apenas criamos esta classe nova. Princípio OCP respeitado.
 */
public class Frappuccino implements Bebida {
    @Override public String getNome()      { return "Frappuccino"; }
    @Override public double getPrecoBase() { return 18.0;         }
}
