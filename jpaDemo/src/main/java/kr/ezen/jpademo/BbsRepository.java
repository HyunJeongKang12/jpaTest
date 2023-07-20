package kr.ezen.jpademo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BbsRepository extends CrudRepository<Bbs, Long> {

    //////////// query Method use ////////////

    // select count(*) from bbs where writer = :writer
    int countAllByWriter(String writer);

    // select * from bbs where writer = :writer
    List<Bbs> findByWriter(String writer);

    // select * from bbs where title = :title and writer = :writer
    List<Bbs> findByTitleAndWriter(String title, String writer);

    // delete from bbs where writer = :writer
    @Transactional
    int deleteByWriter(String writer);

    //////////// @query use JPQL ////////////
    @Query("SELECT b from Bbs b")
    List<Bbs> findAll();

    @Query("SELECT b from Bbs b where b.title=?1 and b.writer=?2")
    List<Bbs> findByTitleAndWriter2(String title, String writer);

    @Query("SELECT b from Bbs b where b.title = :title and b.writer = :writer")
    List<Bbs> findByTitleAndWriter3(String title, String writer);

    //////////// NativeQuery ////////////
    @Query(value = "select * from bbs", nativeQuery = true)
    List<Bbs> findAllBySQL();

    @Query(value = "select title, writer from bbs", nativeQuery = true)
    List<Object[]> findAllBySQL2();

}
