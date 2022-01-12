package org.learn.exercise.service;

import org.learn.exercise.model.Book;
import org.learn.exercise.util.ByteUtil;
import org.learn.exercise.util.FileUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class LibraryService {
    private String fullPath;
    private byte[] fileContent;
    private int bookCount;
    private List<Book> bookList;

    public LibraryService(String fullPath) {
        this.fullPath = fullPath;
        this.fileContent = FileUtil.getFileContent(fullPath);
        this.bookList = new LinkedList<>();
        parser();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * 将图书写入到目录下
     *
     * @param directoryPath 目录绝对地址
     */
    public void writeBookToDirectory(String directoryPath) {
        if (this.bookList.size() <= 0) {
            return;
        }
        this.bookList.forEach(book -> {
            String fileFullPath = directoryPath + File.separator + book.getBookNo();
            FileUtil.writeFileContent(fileFullPath, book.getBookContent());
        });
    }

    private void parser() {
        byte[] bookCountBytes = ByteUtil.slice(this.fileContent, 0, 4);
        this.bookCount = ByteUtil.byteToInt(bookCountBytes);

        for (int i = 0; i < bookCount; i++) {
            int start = 16 + i * 10;
            byte[] bookNoBytes = ByteUtil.slice(this.fileContent, start, 2);
            byte[] bookSizeBytes = ByteUtil.slice(this.fileContent, start + 2, 4);
            byte[] bookOffsetBytes = ByteUtil.slice(this.fileContent, start + 6, 4);

            short bookNo = ByteUtil.byteToShort(bookNoBytes);
            int bookSize = ByteUtil.byteToInt(bookSizeBytes);
            int bookOffset = ByteUtil.byteToInt(bookOffsetBytes);
            byte[] bookContent = ByteUtil.slice(this.fileContent, bookOffset, bookSize);
            Book book = new Book(bookNo, bookSize, bookOffset, bookContent);
            this.bookList.add(book);
        }

    }
}
