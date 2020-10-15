package springboot.hello.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月6日.
*/
public class ZhangSan implements Serializable {
        /**
         *主键
         */
//         @Id
//   		 @GeneratedValue(generator = "UUID")
         private BigDecimal id; 
         
        /**
         *姓名
         */
         @Column(name="NAME")
         private String name;
         
        /**
         *年龄
         */
         @Column(name="AGE")
         private BigDecimal age;
         
        /**
         *工资
         */
         @Column(name="SALARY")
         private BigDecimal salary;
         

        public BigDecimal getId() {
            return id;
        }

        public void setId(BigDecimal id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public BigDecimal getAge() {
            return age;
        }

        public void setAge(BigDecimal age) {
            this.age = age;
        }
        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }
}
