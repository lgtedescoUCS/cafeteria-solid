package cafeteria.bebida;

public class Cafe implements Bebida {
    @Override public String getNome()      { return "Cafe"; }
    @Override public double getPrecoBase() { return 10.0;  }
}
