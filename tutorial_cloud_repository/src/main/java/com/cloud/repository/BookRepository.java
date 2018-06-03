package com.cloud.repository;

import com.cloud.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Jimmy. 2018/6/3  21:08
 */
@Repository
public interface  BookRepository extends JpaRepository<Book, Long>,JpaSpecificationExecutor<Book> {
}
