package org.learn.exercise.service;

import org.junit.jupiter.api.Test;

public class LatLngTransferServiceTests {

    @Test
    public void parserTest() {
        LatLngTransferService service1 = new LatLngTransferService("-49°30'00\"");
        System.out.println(service1);
        LatLngTransferService service2 = new LatLngTransferService("-49°30'30\"");
        System.out.println(service2);
        LatLngTransferService service3 = new LatLngTransferService("55°23'17\"");
        System.out.println(service3);
    }
}
