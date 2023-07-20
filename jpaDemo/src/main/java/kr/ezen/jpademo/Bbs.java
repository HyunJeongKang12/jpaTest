package kr.ezen.jpademo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Data
@Setter
@Getter
public class Bbs {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long bno;

    private String title;
//    private String writer;

    @ManyToOne  // 여러개의 게시글에 하나의 customer
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String content;
    private Long viewCnt;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date regDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date upDate;

    @Override
    public String toString() {
        return "Bbs{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
           //     ", customer=" + customer +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", regDate=" + regDate +
                ", upDate=" + upDate +
                '}';
    }
}
