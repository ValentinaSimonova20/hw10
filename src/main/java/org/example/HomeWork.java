package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/contest/356/problem/A
     */
    @SneakyThrows
    public void championship(InputStream in, OutputStream out) {
        RedBlackTree<Integer> readBlackTree = new RedBlackTree<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] firstLine = reader.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        for(int i = 1; i < n + 1; i++) {
            readBlackTree.add(i);
        }

        for(int i = 0; i < m; i++) {
            int[] battleResult = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            readBlackTree.setWinnerBy(
                    battleResult[2],
                    IntStream.range(battleResult[0], battleResult[1] + 1).boxed().toArray(Integer[]::new)
            );
        }

        for(int i = 1; i < n + 1; i++) {
            Integer winnerBy = readBlackTree.getWinnerBy(i);
            out.write(String.valueOf(winnerBy != null ? winnerBy : 0).getBytes());
            if(i < n) {
                out.write(" ".getBytes());
            }
        }

    }


}
