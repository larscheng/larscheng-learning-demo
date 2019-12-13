package com.larscheng.www;

import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2018/8/9 20:46
 */
@Repository
public class BookMongoDbDao extends MongoDbDao<Book> {
    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
}
