package org.learn.exercise.service;

import org.learn.exercise.util.FileUtil;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取文件中的最大整数和最小整数
 */
public class ReadNumberService {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(-)?\\d+");
    private String fullPath;
    private int max;
    private int min;


    public ReadNumberService(String fullPath) {
        this.fullPath = fullPath;
        parser();
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "ReadNumberService{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    private void parser() {
        String content = FileUtil.getFileString(fullPath, StandardCharsets.US_ASCII);
        Matcher matcher = NUMBER_PATTERN.matcher(content);
        List<Integer> temp = new LinkedList<>();
        while (matcher.find()) {
            String numberString = matcher.group(0);
            temp.add(Integer.parseInt(numberString));
        }
        if (temp.size() <= 0) {
            throw new RuntimeException("file has no number");
        }
        this.max = temp.stream().mapToInt(i -> i).max().getAsInt();
        this.min = temp.stream().mapToInt(i -> i).min().getAsInt();
    }
}
