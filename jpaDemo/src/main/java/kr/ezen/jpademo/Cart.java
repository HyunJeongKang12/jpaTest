package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
//@Data  toString()
@Getter
@Setter
public class Cart {
    @Id
    private Long id;

    //양방향 참조(1:1 서로 참조)
    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)  //inner join
    private Member member;  //FK

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
            //    ", member=" + member +   //한쪽 주석처리
                '}';
    }
}
