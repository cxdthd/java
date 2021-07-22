package java0;

/**
 * 商品类
 * @author YANG
 * @create 2021-04-01 22:43
 */
public class Goods implements Comparable{

    //按价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods o1 = (Goods)o;

            //方式一
            if (this.price > o1.price){
                return 1;
            }else if (this.price < o1.price){
                return -1;
            }else {
//                return 0;
                //这里加-号就是反向排序
                return -this.name.compareTo(o1.name);
            }

            //方式二
//            return Integer.compare(this.price,o1.price);
        }
        throw new RuntimeException("输入的类型不匹配！！！");
    }

    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


}
