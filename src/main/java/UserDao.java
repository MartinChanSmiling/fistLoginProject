import javax.swing.tree.RowMapper;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.el.Expression;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.PatameterizedBeanPropertyRowMapper;


/**
 * Created by MartinCheng on 2017/4/28.
 */
//实现接口后产生的方法就是 select*的效果
    public class UserDao implements UserDaoImp {
    private JdbcTemplate jdbcTemplate;
    //List描述find返回类型
    public List find(){
        String sql="select * from user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    //提前挑用setid使下面使用的Id都是re.getId取得的Id
    //下面增添删改的可以专心实现自己的功能
    private static final class UserMapper implements RowMapper(){
        //什么语法？Object描述mapRow返回类型
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
            UserVO uservo=new UserVO();
            uservo.setId(rs.getId("id"));
            uservo.setPwd(rs.getId("name"));
            uservo.setName(rs.getName("name"));
            return uservo;
        }
    }

    public void delete (int id){
        String sql="delete from user where id =?";
        jdbcTemplate.update(sql,id);
    }

    public void insert (UserVO uservo){
        String sql="insert into user (name, pwd) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{
                uservo.getName(),uservo.getPwd()
        });
    }

    //类描述方法返回的类型,查找
    public UserVO select (int id){
        String sql="select * from user where name=? and pwd=?";
        try {
            return jdbcTemplate.queryForObject(sql,ParameterizedBeanPropertyRowMapper.newInstantce(UserVO.class),id);
        }  catch(Exception e){
            return null;
        }
    }

    //修改
    public void update(UserVO uservo){
        String sql="update user set name=?, pwd=? where id=?";
        jdbcTemplate.update(sql,uservo.getName(),uservo.getPwd(),uservo.getId());
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public JdbcTemplate jdbcTemplate(){
        return jdbcTemplate;
    }

}


