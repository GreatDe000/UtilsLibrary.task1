package oop.task;

public class Test {

    public static void runAllTests() {
        System.out.println("=== Тест библиотеки ===\n");

        testSplit();
        testJoin();
        testReplace();
        testEqualsIgnoreCase();
        testIndexOf();
        testFormat();
        testReverse();

        System.out.println("\n=== Конец тестов ===");
    }

    private static void testSplit() {
        System.out.println("split:");
        String[] result = StringUtils.split("one,two,three", ",");
        for (String s : result) {
            System.out.println(" - " + s);
        }
        System.out.println();
    }

    private static void testJoin() {
        System.out.println("join:");
        String[] parts = {"one", "two", "three"};
        String result = StringUtils.join(parts, " | ");
        System.out.println("Результат: " + result + "\n");
    }

    private static void testReplace() {
        System.out.println("replace:");
        String result = StringUtils.replace("I like Java", "Java", "Python");
        System.out.println("Результат: " + result + "\n");
    }

    private static void testEqualsIgnoreCase() {
        System.out.println("equalsIgnoreCase:");
        boolean res = StringUtils.equalsIgnoreCase("Hello", "hello");
        System.out.println("Сравнение 'Hello' и 'hello': " + res + "\n");
    }

    private static void testIndexOf() {
        System.out.println("indexOf:");
        int pos = StringUtils.indexOf("The quick brown fox", "brown");
        System.out.println("Позиция 'brown' в тексте: " + pos + "\n");
    }

    private static void testFormat() {
        System.out.println("format:");
        String result = StringUtils.format("Привет, %s! Добро пожаловать в %s.", "Дмитрий", "Java");
        System.out.println("Результат: " + result + "\n");
    }

    private static void testReverse() {
        System.out.println("reverse:");
        String result = StringUtils.reverse("Hello World!");
        System.out.println("Результат: " + result + "\n");
    }
}