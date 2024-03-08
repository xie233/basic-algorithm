package org.jim.behavioral.strategy;


import java.io.File;

public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        ISortStrategy sortStrategy;
        if (fileSize < 6 * GB) { // [0, 6GB)
            sortStrategy = new QuickSort();
        } else if (fileSize < 10 * GB) { // [6GB, 100GB)
            sortStrategy = new ExternalSort();
        } else { // [100GB, ~)
            sortStrategy = new MapReduceSort();
        }
        sortStrategy.sort(filePath);
    }
}
