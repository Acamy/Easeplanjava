package com.hebaohua.part6_Spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Hebh
 * @date 2018/2/2
 * @description:
 */
public class JDBC {
    // 容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void testApp() throws Exception {
        UserDao ud = (UserDao) ac.getBean("userDao");
//        ud.save();
        System.out.println(ud.findById(1));
        System.out.println(ud.getAll());
    }
}

class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save() {
        String sql = "insert into t_dept(deptName) values('test');";
        jdbcTemplate.update(sql);
    }

    public Dept findById(int id) {
        String sql = "select * from t_dept where deptId=?";
        List<Dept> list = jdbcTemplate.query(sql, new MyResult(), id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    public List<Dept> getAll() {
        String sql = "select * from t_dept";
        List<Dept> list = jdbcTemplate.query(sql, new MyResult());
        return list;
    }

    class MyResult implements RowMapper<Dept> {
        // 如何封装一行记录
        @Override
        public Dept mapRow(ResultSet rs, int index) throws SQLException {
            Dept dept = new Dept();
            dept.setDeptId(rs.getInt("deptId"));
            dept.setDeptName(rs.getString("deptName"));
            return dept;
        }
    }
}

class Dept {
    private int deptId;
    private String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
