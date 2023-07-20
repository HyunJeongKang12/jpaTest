package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Data
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_id")  //테이블 생성시 컬럼id
    private Long id;
    private String password;
    private String name;
    private String email;

    //양방향(1:1 서로 참조) 참조
    // @JoinColumn(name = "cart_id")
    //   -> 양쪽 모두 설정시 FK가 2개가 됨 : 오류(관계형DB에서 fk 1개여야함)
    // ==> mappedBy 지정, FK 안만든다.
    @OneToOne(mappedBy = "member")
    private Cart cart;  //FK X

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}
