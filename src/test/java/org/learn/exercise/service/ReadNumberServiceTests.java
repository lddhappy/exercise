package org.learn.exercise.service;

import org.junit.jupiter.api.Test;

public class ReadNumberServiceTests {

    @Test
    public void parserTests() {
        //srf25.64-7sat
        String fullPath = "D:\\A.txt";
        ReadNumberService readNumberService = new ReadNumberService(fullPath);
        assert readNumberService.getMax() == 64;
        assert readNumberService.getMin() == -7;
    }
}
