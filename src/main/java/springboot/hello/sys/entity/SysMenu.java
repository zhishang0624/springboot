package springboot.hello.sys.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月9日.
*/
public class SysMenu implements Serializable {
        /**
         *主键
         */
         @Id
   		 @GeneratedValue(generator = "UUID")
   	 
         private String id; 
         
        /**
         *菜单名
         */
         @Column(name="MENU_NAME")
         private String menuName;
         
        /**
         *菜单编码
         */
         @Column(name="MENU_CODE")
         private String menuCode;
         
        /**
         *访问路径
         */
         @Column(name="ACC_URL")
         private String accUrl;
         
        /**
         *上级ID
         */
         @Column(name="UP_ID")
         private String upId;
         
        /**
         *创建时间
         */
   		 @JsonFormat(pattern = "yyyy-MM-dd")
         @Column(name="CREATE_TIME")
         private Date createTime;
         
        /**
         *创建人
         */
         @Column(name="CREATE_ID")
         private String createId;
         
        /**
         *最后修改时间
         */
   		 @JsonFormat(pattern = "yyyy-MM-dd")
         @Column(name="LAST_UPDATE_TIME")
         private Date lastUpdateTime;
         
        /**
         *修改人
         */
         @Column(name="UPDATE_ID")
         private String updateId;
         

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
        public String getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(String menuCode) {
            this.menuCode = menuCode;
        }
        public String getAccUrl() {
            return accUrl;
        }

        public void setAccUrl(String accUrl) {
            this.accUrl = accUrl;
        }
        public String getUpId() {
            return upId;
        }

        public void setUpId(String upId) {
            this.upId = upId;
        }
        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        public String getCreateId() {
            return createId;
        }

        public void setCreateId(String createId) {
            this.createId = createId;
        }
        public Date getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(Date lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }
        public String getUpdateId() {
            return updateId;
        }

        public void setUpdateId(String updateId) {
            this.updateId = updateId;
        }
}
