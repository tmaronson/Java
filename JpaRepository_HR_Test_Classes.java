
package com.hackerrank.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.springsecurity.dto.Book;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

  @Query(nativeQuery = true, value = "SELECT b.book_name FROM book b, reader r, reader_book_star rbs where b.book_id=rbs.book_id and r.reader_id=rbs.reader_id group by b.book_name order by count(r.first_name) desc limit 3;")
  Set<String> findTopThreePopularBooks();

}



package com.hackerrank.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

import com.hackerrank.springsecurity.dto.ReaderBookStar;
import org.springframework.data.jpa.repository.Query;


public interface ReaderBookStarRepository extends JpaRepository<ReaderBookStar, Long> {

  @Query(nativeQuery=true,value="SELECT rbs.star FROM book b, reader r, reader_book_star rbs where b.book_id=rbs.book_id and r.reader_id=rbs.reader_id;")
	Set<Long> findAllReaderBookStars();
}




package com.hackerrank.springsecurity.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackerrank.springsecurity.dto.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

  @Query(nativeQuery=true, value="SELECT max(rbs.star) FROM book b, reader r, reader_book_star rbs where b.book_id=rbs.book_id and r.reader_id=rbs.reader_id group by b.book_name;")
	Set<Long> findHighestStarInBooks();

   @Query(nativeQuery=true, value="SELECT rbs.star desc FROM book b, reader r, reader_book_star rbs where b.book_id=rbs.book_id and r.reader_id=rbs.reader_id and b.book_name=?1 order by rbs.star desc limit 3;")
	Set<Long> findTopThreeStarsInABook(String book);
}



