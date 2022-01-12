package org.learn.exercise.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtil {
    /**
     * 默认采用大端模式
     */
    private static final ByteOrder DEFAULT_ORDER = ByteOrder.BIG_ENDIAN;

    public static int byteToInt(byte[] bs) {
        return ByteBuffer.wrap(bs).order(DEFAULT_ORDER).getInt();
    }

    public static short byteToShort(byte[] bs) {
        return ByteBuffer.wrap(bs).order(DEFAULT_ORDER).getShort();
    }

    public static byte[] slice(byte[] bs, int start, int length) {
        byte[] result = new byte[length];
        System.arraycopy(bs, start, result, 0, length);
        return result;
    }
}
