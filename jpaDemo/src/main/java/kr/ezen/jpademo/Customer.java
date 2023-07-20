package kr.ezen.jpademo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
   // @GeneratedValue   //auto increment
    @Column(name = "customer_id")
    private String id;
    private String password;
    private String name;
    private String email;
    private Date inDate;
    private Date upDate;
    
    //자신TO상대
    // fetch = FetchType.EAGER : 두 엔티티의 정보를 한번에 가져오기(join)
    // fetch = FetchType.LAZY : 필요시에 따로 가져오기
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Bbs> list = new ArrayList<>();

}
