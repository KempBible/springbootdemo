package test.Java从入门到精通第2版.第7章;

public class doWhileDemo7_5 {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            ++i;
        }while (i <= 10);
        System.out.println(sum);
    }
}
