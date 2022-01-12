package org.learn.exercise.model;

public class Book {
    private short bookNo;
    private int bookSize;
    private int bookOffset;
    private byte[] bookContent;

    public Book(short bookNo, int bookSize, int bookOffset, byte[] bookContent) {
        this.bookNo = bookNo;
        this.bookSize = bookSize;
        this.bookOffset = bookOffset;
        this.bookContent = bookContent;
    }

    public short getBookNo() {
        return bookNo;
    }

    public void setBookNo(short bookNo) {
        this.bookNo = bookNo;
    }

    public int getBookSize() {
        return bookSize;
    }

    public void setBookSize(int bookSize) {
        this.bookSize = bookSize;
    }

    public int getBookOffset() {
        return bookOffset;
    }

    public void setBookOffset(int bookOffset) {
        this.bookOffset = bookOffset;
    }

    public byte[] getBookContent() {
        return bookContent;
    }

    public void setBookContent(byte[] bookContent) {
        this.bookContent = bookContent;
    }
}
