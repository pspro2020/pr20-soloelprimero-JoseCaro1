package ejercicio20;

public class ElementResult {

    private int row;
    private int column;

    public ElementResult(int row, int column) {

        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("Ha sido encontrado en la fila %d y el la columna %d", row, column);
    }
}
