package ejercicio20;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainInvokeAny {


    private boolean value=false;
    ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    int[][] matriz = getRandomMatriz5x5();
    List<Callable<ElementResult>> callableList = new ArrayList<>();
    Random random = new Random();
    ElementResult elementResult;


    public MainInvokeAny() {
        for (int i = 0; i < matriz.length; i++) {
            int num = random.nextInt(20)+20;
            System.out.println(num);
            callableList.add(new SearchElement(num, matriz, i));
        }
        try {

            elementResult = fixedThreadPool.invokeAny(callableList);

        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            System.out.println("Not found element");
            value=true;
        } finally {
            fixedThreadPool.shutdown();
        }

        if (!value) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.printf("La fila %d elemento %d\n", i, matriz[i][j]);
                }
                System.out.println();
            }
            System.out.println(elementResult);
        }




    }

    private int[][] getRandomMatriz5x5() {
        Random random = new Random();
        int result[][] = new int[5][5];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = random.nextInt(10) + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new MainInvokeAny();
    }
}
