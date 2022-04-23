package test.尚学谷.bilibili_4_常用类;

/**
 * 商品类
 */
public class 自定义类实现Comparable自然排序 implements Comparable {

    private String name;
    private double price;

    public 自定义类实现Comparable自然排序() {
    }

    public 自定义类实现Comparable自然排序(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    // 指明商品比较大小的方式：按照价格从低到高排序,再按照产品名称从低到高排序
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof 自定义类实现Comparable自然排序){
//            自定义类实现Comparable自然排序 goods = (自定义类实现Comparable自然排序)o;
//            // 方式一：
//            if (this.price > goods.price){
//                return 1;
//            }else if (this.price < goods.price){
//                return -1;
//            }else {
//                return 0;
//            }
//            // 方式二：
//            // return Double.compare(this.price, goods.price);
//        }
//        // return 0;
//        throw new RuntimeException("传入的数据类型不一致！");
//    }

//    // 指明商品比较大小的方式：按照价格从低到高排序,再按照产品名称从低到高排序
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof 自定义类实现Comparable自然排序){
//            自定义类实现Comparable自然排序 goods = (自定义类实现Comparable自然排序)o;
//            // 方式一：
//            if (this.price > goods.price){
//                return 1;
//            }else if (this.price < goods.price){
//                return -1;
//            }else {
////                return 0;
//                return this.name.compareTo(goods.name);
//            }
//            // 方式二：
//            // return Double.compare(this.price, goods.price);
//        }
//        // return 0;
//        throw new RuntimeException("传入的数据类型不一致！");
//    }

    // 指明商品比较大小的方式：按照价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        System.out.println("**********");
        if (o instanceof 自定义类实现Comparable自然排序){
            自定义类实现Comparable自然排序 goods = (自定义类实现Comparable自然排序)o;
            // 方式一：
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else {
//                return 0;
                // 取反
                return -this.name.compareTo(goods.name);
            }
            // 方式二：
            // return Double.compare(this.price, goods.price);
        }
        // return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }

    @Override
    public String toString() {
        return "自定义类实现Comparable自然排序{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
