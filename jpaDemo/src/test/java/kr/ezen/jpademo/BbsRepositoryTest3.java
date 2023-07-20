//package kr.ezen.jpademo;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BbsRepositoryTest3 {
//    @Autowired
//    private BbsRepository bbsRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @BeforeEach
//    public void dummyData(){
//        for(int i=1; i <= 100; i++){
//            Bbs bbs = new Bbs();
//            bbs.setBno((long)i);
//            bbs.setTitle("title" + i);
//            bbs.setContent("content" +i);
//            bbs.setWriter("writer"+(i%10));//0~9
//            bbs.setViewCnt((long) (Math.random()*100));  // 0~99
//            bbs.setRegDate(new Date());
//            bbs.setUpDate(new Date());
//
//            bbsRepository.save(bbs);
//        }
//    }
//
//    @Test
//    @DisplayName("쿼리를 직접생성해서 JPQL 작성 테스트")
//    public void createQueryTest(){
//        String query = "select b from Bbs b";
//        TypedQuery<Bbs> tQuery = em.createQuery(query, Bbs.class);
//        List<Bbs> list = tQuery.getResultList();
//
////        list.forEach(System.out::println);
//        list.forEach(p -> System.out.println(p));
//        assertTrue(list.size() ==100);
//    }
//
//    @Test
//    @DisplayName("@Query JPQL 작성 테스트")
//    public void createAnnoTest(){
//        List<Bbs> list = bbsRepository.findAll();
//        assertTrue(list.size() ==100);
//    }
//
//    @Test
//    @DisplayName("@Query JPQL 작성 테스트2")
//    public void createAnnoTest2(){
//        List<Bbs> list = bbsRepository.findByTitleAndWriter2("title1", "writer1");
//        assertTrue(list.size() ==1);
//    }
//
//    @Test
//    @DisplayName("@Query Native 쿼리 테스트")
//    public void createNativeQueryTest(){
//        List<Bbs> list = bbsRepository.findAllBySQL();
//        assertTrue(list.size() ==100);
//    }
//
//    @Test
//    @DisplayName("@Query Native 쿼리 테스트")
//    public void createNativeQueryTest2(){
//        List<Object[]> list = bbsRepository.findAllBySQL2();
////        list.forEach(System.out::println);  //[Ljava.lang.Object;@2ab1c7a9
////        list.forEach(p -> System.out.println(p));
//        //object를 stream객체(arr)로 변환하여(컨베어벨트 처럼) 꺼내놓고 map이용
//        list.stream().map(arr -> Arrays.toString(arr)).forEach(System.out::println);
//
//        assertTrue(list.size() ==100);
//    }
//}