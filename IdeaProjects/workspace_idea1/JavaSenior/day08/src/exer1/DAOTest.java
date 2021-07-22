package exer1;

import org.junit.Test;

import java.util.List;

/**
 *
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 * @author YANG
 * @create 2021-04-12 16:57
 */
public class DAOTest {
    @Test
    public void test(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("AA",new User(1001,18,"Tom"));
        userDAO.save("BB",new User(1002,12,"Jerry"));
        userDAO.save("CC",new User(1003,112,"Jack"));
        userDAO.save("DD",new User(1004,132,"Aoder"));

        userDAO.update("CC",new User(1003,1333,"QWE"));

        userDAO.delete("DD");

        List<User> list = userDAO.list();
//        System.out.println(list);
        list.forEach(System.out::println);

//        User bb = userDAO.get("BB");
//        System.out.println(bb);
    }
}
