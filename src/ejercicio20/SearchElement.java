package ejercicio20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchElement implements Callable<ElementResult> {
    private final int search;
    private int[][] matriz;
    private List<Integer> row;
    private int numberRow;
    private int column;

    @Override
    public ElementResult call() throws Exception {
        boolean element = search();

        if (!element) {
            throw new RuntimeException("Not element found");
        }
        return new ElementResult(numberRow, column);


    }

    public SearchElement(int search, int matriz[][], int numberRow) {
        this.search = search;
        this.matriz = matriz;
        this.row = row;
        this.numberRow = numberRow;
    }

    private boolean search() {
        row = getRow(matriz, numberRow);
        for (int i = 0; i < row.size(); i++) {
            if (search == row.get(i)) {
                column = i;
                return true;
            }
        }

        return false;
    }

    private List<Integer> getRow(int matriz[][], int num) {
        if (matriz.length <= num) {
            throw new IllegalArgumentException("Invalid row");
        }
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < matriz[num].length; i++) {
            lista.add(matriz[num][i]);
        }
        return lista;
    }
}
