package skiii.hziee.testmanage.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Test{

    private Integer test_id;
    private String test_name;
    private Integer now_num;
    private Integer max_num;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begin_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;

    public Test() {

    }

    public Test(Integer test_id, String test_name, Integer now_num, Integer max_num, Date begin_time, Date end_time) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.now_num = now_num;
        this.max_num = max_num;
        this.begin_time = begin_time;
        this.end_time = end_time;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public Integer getNow_num() {
        return now_num;
    }

    public void setNow_num(Integer now_num) {
        this.now_num = now_num;
    }

    public Integer getMax_num() {
        return max_num;
    }

    public void setMax_num(Integer max_num) {
        this.max_num = max_num;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Test{" +
                "test_id=" + test_id +
                ", test_name='" + test_name + '\'' +
                ", now_num=" + now_num +
                ", max_num=" + max_num +
                ", begin_time=" + begin_time +
                ", end_time=" + end_time +
                '}';
    }
}
