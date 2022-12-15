package skiii.hziee.testmanage.bean;
import lombok.Data;

import javax.persistence.*;


@MappedSuperclass
@Data
public class BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
