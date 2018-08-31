package springboot.hello.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
* Created by hbm Generator<27683139@qq.com> on 2018-8-31.
*/
public class TbUser implements Serializable {
        /**
         *ID
         */
         @Id
   		 @GeneratedValue(generator = "JDBC")
         private Integer id; 
         
        /**
         *用户名
         */
        // @Column(name="username")
         private String username;
         
        /**
         *年龄
         */
        // @Column(name="age")
         private Integer age;
         
        /**
         *创建时间
         */
        // @Column(name="ctm")
         private Date ctm;
         

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
        public Date getCtm() {
            return ctm;
        }

        public void setCtm(Date ctm) {
            this.ctm = ctm;
        }
}
