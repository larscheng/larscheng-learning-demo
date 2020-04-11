package com.larscheng.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }


    @Autowired
    private BookMongoDbService bookMongoDbService;


    @PostMapping("/mongo/save")
    public String saveObj(@RequestBody Book book) {
        return bookMongoDbService.saveObj2(book);
    }

    @GetMapping("/mongo/findAll")
    public List<Book> findAll() {
        return bookMongoDbService.findAll();
    }

    @GetMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {
        return bookMongoDbService.getBookById(id);
    }

    @GetMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {
        return bookMongoDbService.getBookByName(name);
    }

    @PostMapping("/mongo/update")
    public String update(@RequestBody Book book) {
        return bookMongoDbService.updateBook(book);
    }

    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {
        return bookMongoDbService.deleteBook(book);
    }

    @GetMapping("/mongo/delById")
    public String delById(@RequestParam String id) {
        return bookMongoDbService.deleteBookById(id);
    }


    @GetMapping("/mongo/updateDemo")
    public String updateDemo(@RequestParam String id,
                             @RequestParam String key,
                             @RequestParam String obj) {
        return bookMongoDbService.update(id, key, obj);
    }

}
