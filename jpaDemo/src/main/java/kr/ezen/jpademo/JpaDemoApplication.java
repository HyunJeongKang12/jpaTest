package kr.ezen.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    EntityManagerFactory emf;  //인스턴스 변수

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(JpaDemoApplication.class);
        //SpringApplication.run(JpaDemoApplication.class, args);
        //System.out.println("Spring boot!!");
        app.setWebApplicationType(WebApplicationType.NONE);  //톰캣 동작 안함

        //static에서 emf 변수 사용 불가하므로 CommandLineRunner 인터페이스 상속 받아 run()수행
//        app.run();
    }

    @Override  //인스턴스 메소드
    public void run(String... args) throws Exception {
        System.out.println(emf);

        // 순수 jpa를 이용

        EntityManager em = emf.createEntityManager();
        Customer customer = new Customer();

        customer.setId("test");
        customer.setPassword("1234");
        customer.setName("홍길동");
        customer.setEmail("123@234");
        customer.setInDate(new Date());
        customer.setUpDate(new Date());

        //Transaction
        EntityTransaction tx = em.getTransaction();
        //저장
        tx.begin();
        em.persist(customer); //영속화

        //수정
        customer.setName("박길동");
        customer.setEmail("aaa@bbb.com");
        em.persist(customer);

        tx.commit();

        //조회
        //영속성 context(엔티티 매니저)에 있으면 가져오고 없으면 db접속하여 가져옴
        Customer customer2 = em.find(Customer.class, "test");
        System.out.println("customer == customer2 : " + (customer == customer2));

        Customer customer3 = em.find(Customer.class, "demo");
        System.out.println(" customer3 : " + customer3);  //null, 테이블에 존재하지 않음

        //삭제
        tx.begin();
        em.remove(customer);
        tx.commit();
    }
}
