/**
 * Created by MartinCheng on 2017/4/28.
 */

import java.util.List;

//转换为interface之后瞬间没有乱码，不需要像class一样实现
public interface UserDaoImp {
    public void insert(UserVO userVO);
    public void delete(int id);
    public void update(UserVO userVO);
    public UserVO select (int id);
    public List find();
    public UserVO selectByName(String name,String pwd);
}

//为数据库操作产生接口
//增加，删除，修改内容；查找（两种方式）UserVo类型的数据；查找List类型的数据；



