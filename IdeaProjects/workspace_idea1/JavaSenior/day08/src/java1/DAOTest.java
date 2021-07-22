package java1;

import org.junit.Test;

import java.util.List;

/**
 * @author YANG
 * @create 2021-04-11 16:17
 */
public class DAOTest {

    @Test
    public void test(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> forList = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());

    }

}
