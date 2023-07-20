//package kr.ezen.jpademo;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class BbsRepositoryTest2 {
//    @Autowired
//    private BbsRepository bbsRepository;
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
//    public void countTest(){
//        int n = bbsRepository.countAllByWriter("writer7");
//        assertTrue(n==10);
//    }
//
//    @Test
//    public void findTest(){
//        List<Bbs> list = bbsRepository.findByWriter("writer3");
//        assertTrue(list.size() == 10);
//
//        //lamda
//        list.forEach(li -> System.out.println(li));
//        //람다식을 더 간편하게 사용하는 메서드 참조  문법
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    public void TitleAndWriter(){
//        List<Bbs> list = bbsRepository.findByTitleAndWriter("title2", "writer2");
//        assertTrue(list.size() == 1);
//    }
//
//    @Test
//    public void deleteTest(){
//        int n = bbsRepository.deleteByWriter("writer4");
//        assertTrue(n==10);
//
//        List<Bbs> list = bbsRepository.findByWriter("writer4");
//        assertTrue(list.size() == 0);
//    }
//
//}