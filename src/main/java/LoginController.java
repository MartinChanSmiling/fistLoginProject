/**
 * Created by MartinCheng on 2017/4/28.
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.controller;

//实现 查找用户输入数据是否和数据库内容匹配，进行身份认证同时页面反馈
//uservo 其实就是一个model，用来不断信息，类似一个借口的作用，空架子，放置实体。比如说本例子中用户输入的用户名和密码

public class LoginController implements Controller {
    private UserDao userDao;
    @SuppressWarnings("unchecked")
    //出现了一个内置工具，来处理实际情况中Http的请求和回应）
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("userpwd");

        //这是什么？
        map model = new Hashmap();

        //将输入信息建立实体，进行验证 userDao不单单是调用数据库的数据，也有前端数据操作
        UserVO uservo = userDao.selectByName(userName, userPwd);
        //model(hashmap作用，put语法功能作用，ModelAndView的功能作用)
        if (uservo != null) {
            model.put("userVO", userVO);
            return new ModelAndView("WEB-INF/Main.jsp", model);
        } else {
            model.put("error", "Login failed");
            return new ModelAndView("WEB-INF/login.jsp", model);
        }
    }
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public UserDao getUserDao(){
        return userDao;
    }

}
