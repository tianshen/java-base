package com.example.base.JAVA8_LAMBDA;

import java.io.File;
import java.io.FileFilter;

public class FileTest {

    /**
     * 8之前
     *
     * @return
     */
    public File[] searchHiddenFile() {
        return new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }

    /**
     * 8之后
     *
     * @return
     */
    public File[] searchHiddenFile8() {
        return new File(".").listFiles(File::isHidden);
    }
}
