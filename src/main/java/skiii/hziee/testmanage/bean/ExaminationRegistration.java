package skiii.hziee.testmanage.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import skiii.hziee.testmanage.bean.BaseBean;
@Setter
@Getter
@Entity
@Table(name = "examination_registration")

public class ExaminationRegistration implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examination_registration_id")
    private Integer examination_registration_id;

    @Basic
    private String test_name;
    // 用户编号
    @Basic
    private Integer user_num;
    // 报名编号
    @Basic
    private String registration_num;
    // 考试编号
    @Basic
    private String test_id;
    // 考试费用
    @Basic
    private String examination_fee;
    // 姓名
    @Basic
    private String full_name;
    // 联系电话
    @Basic
    private String contact_number;

    // 创建时间
    @Basic
    private Timestamp create_time;
}

