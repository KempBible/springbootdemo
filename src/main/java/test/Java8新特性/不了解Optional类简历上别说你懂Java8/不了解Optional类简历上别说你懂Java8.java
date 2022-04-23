package test.Java8新特性.不了解Optional类简历上别说你懂Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 16:04
 */
public class 不了解Optional类简历上别说你懂Java8 {
    public static void main(String[] args) {
        // 1.创建Optional类
        Optional<String> empty = Optional.empty();
        Optional<String> opt = Optional.of("小玲羔");
        System.out.println(opt.get());

//        Optional<String> opt1 = Optional.of(null);
//        System.out.println(opt1.get());

        // 2.isPresent
        System.out.println(opt.isPresent());

        opt = Optional.ofNullable(null);
        System.out.println(opt);

        opt = Optional.of("达令羔");
        opt.ifPresent(name -> System.out.println(name.length()));

        // 3.orElse和orElseGet
        //（1）orElse
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("binghe");
        System.out.println(name);
        //（2）orElseGet
        String nullName1 = null;
        String name1 = Optional.ofNullable(nullName).orElseGet(() -> "binghe");
        System.out.println(name1);
        //（3）二者有什么区别？
        不了解Optional类简历上别说你懂Java8 test = new 不了解Optional类简历上别说你懂Java8();
        test.test();

        // 4.orElseThrow
        System.out.println("444444444444");
        String nullName2 = null;
//        String name2 = Optional.ofNullable(nullName2).orElseThrow(IllegalArgumentException::new);
//        System.out.println(name2);

        // 5.get
        System.out.println("555555555");
        Optional<String> opt5 = Optional.of("binghe");
        String name5 = opt5.get();
        System.out.println(name5);
        Optional<String> opt5_1 = Optional.ofNullable(null);
        System.out.println(opt5_1);

        // 6.filter
        System.out.println("66666666");
        String name6 = "binghe";
        Optional<String> nameOptional = Optional.of(name6);
        boolean isBinghe = nameOptional.filter(n -> "binghe".equals(name6)).isPresent();
        System.out.println(isBinghe);
        boolean isBinghe1 = nameOptional.filter(n -> "binghe1".equals(name6)).isPresent();
        System.out.println(isBinghe1);

        System.out.println(filterPerson(new Person(18)));
        System.out.println(filterPerson(new Person(29)));
        System.out.println(filterPerson(new Person(16)));
        System.out.println(filterPerson(new Person(34)));
        System.out.println("---------------------------------");
        System.out.println(filterPersonByOptional(new Person(56)));
        System.out.println(filterPersonByOptional(new Person(30)));

        // 7.map
        System.out.println("777777777777");
        List<String> names = Arrays.asList("binghe001", "binghe002", "", "binghe003", "", "binghe004");
        Optional<List<String>> listOptional = Optional.of(names);
        int size = listOptional.map(List::size).orElse(0);
        System.out.println(size);
        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
        System.out.println(correctPassword);
        correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
        System.out.println(correctPassword);

        //8.flatMap
        System.out.println("88888888888888888");
        Person8 person8 = new Person8("binghe", 18);
        Optional<Person8> person8Optional = Optional.of(person8);

        Optional<Optional<String>> nameOptionalWrapper = person8Optional.map(Person8::getName);
        Optional<String> nameOptional8 = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name8 = nameOptional8.orElse("");
        System.out.println(name8);

        String name8_1 = person8Optional.flatMap(Person8::getName).orElse("");
        System.out.println(name8_1);
    }

    public static boolean filterPersonByOptional(Person person) {
        return Optional.ofNullable(person).map(Person::getAge).filter(p -> p > 25).filter(p -> p < 35).isPresent();
    }

    public static boolean filterPerson(Person person) {
        boolean isInRange = false;
        if (person != null && person.getAge() > 25 && person.getAge() <= 35) {
            isInRange = true;
        }
        return isInRange;
    }

    private void test() {
        String name = "binghe001";

        System.out.println("Using orElseGet:");
        String defaultName = Optional.ofNullable(name).orElseGet(this::getDefaultName);
        System.out.println(defaultName);
        assertEquals("binghe001", defaultName);

        System.out.println("Using orElse:");
        String defaultText = Optional.ofNullable(name).orElse(getDefaultName());
        System.out.println(defaultText);
        assertEquals("binghe001", defaultName);
    }

    public String getDefaultName() {
        System.out.println("Getting Default Name");
        return "binghe";
    }
}