package com.hl.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.date}")
    private String bookDate;
    @Value("${db.name}")
    private String dbName;

    @RequestMapping(value = "/customer")
    public String index() {
        return "Hello Customer," + bookName + ": " + bookAuthor + ": " + bookDate + ": " + dbName;
    }
}
