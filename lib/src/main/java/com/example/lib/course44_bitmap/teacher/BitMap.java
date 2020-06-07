package com.example.lib.course44_bitmap.teacher;

public class BitMap { // Java 中 char 类型占 16bit，也即是 2 个字节
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(1000);
        bitMap.set(900);
        bitMap.get(900);
    }
}

