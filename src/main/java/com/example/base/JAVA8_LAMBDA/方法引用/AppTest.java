package com.example.base.JAVA8_LAMBDA.方法引用;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.function.*;

@Data
class Fruit {
    protected Integer weight;

    protected String color;

}

class Apple extends Fruit{

    public Apple() {
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

class Orange extends Fruit{

    public Orange() {
    }

    public Orange(Integer weight) {
        this.weight = weight;
    }

    public Orange(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text) {
        return text + "Kind regards";
    }
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}

public class AppTest {
    
    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }
    
    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }   

    public static void main(String[] args) {


        /**
         * 方法引用
         */
        Function<String, @Nullable Integer> stringIntegerFunction = (String s) -> Integer.parseInt(s);
        Function<String, @Nullable Integer> stringIntegerFunction2 = Integer::parseInt;
        BiPredicate<List<String>, String> contains = (List<String> list,String element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;


        /**
         * 构造函数引用
         */
        // 无参构造函数
        Supplier<Apple> supplier = () -> new Apple();
        Apple apple = supplier.get();
        Supplier<Apple> supplier2 = Apple::new;
        apple = supplier2.get();
        
        // 一个参数的构造函数
        Function<Integer, Apple> function = (weight) -> new Apple(weight);
        apple = function.apply(110);
        Function<Integer, Apple> function2 = Apple::new;
        apple = function.apply(110);
        
        // 两个参数的构造函数
        BiFunction<Integer, String, Apple> function3 = (weight, color) -> new Apple(weight, color);
        apple = function3.apply(100, "red");
        BiFunction<Integer, String, Apple> function4 = Apple::new;
        apple = function4.apply(100, "red");


        Fruit fruit = giveMeFruit("apple", 100);
        System.out.println(fruit);

        fruit = giveMeFruit("orange", 100);
        System.out.println(fruit);

        List<Apple> invertory = new ArrayList<>();
        invertory.add(new Apple(110, "yellow"));
        invertory.add(new Apple(130, "green"));
        invertory.add(new Apple(110, "red"));
        invertory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        for (Apple a : invertory) {
            System.out.println(a);
        }

        // 谓词复合
        Predicate<Apple> redApple = (a) -> "red".equals(a.getColor());
        Predicate<Apple> nonRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);

        // 函数复合
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        // f(g(x))
        Function<Integer, Integer> h = f.andThen(g);
        Integer hResult = h.apply(1);
        System.out.println(hResult);
        // g(f(x))
        Function<Integer, Integer> c = f.compose(g);
        Integer cResult = c.apply(1);
        System.out.println(cResult);

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);

    }
}


