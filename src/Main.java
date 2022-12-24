public class Main {

    // Ключи
    static long n = 57;
    static long e = 31;

    // Общие параметры
    static long p = 23;
    static long g = 5;

    public static void main(String[] args) {

        // Сообщения для проверки подлинности подписи
        long[][] messages_to_verify = new long[][] { {25, 28}, {12, 42}, {48, 15} };

        // Проверка подписи
        for (long[] mes : messages_to_verify)
            System.out.println(check_RSA(mes[0], mes[1], e, n));


        // Секретные параметры
        long x = 12;
        long k = 13;

        // Хеш сообщения
        long m = 18;

        // Проверка Эль Гамаля
        System.out.println("\n" + check_El_Gamal(x, k, m));
    }

    // Проверка подписи по RSA
    static boolean check_RSA(long m, long  s, long e, long n) {
        return m == ((long) Math.pow(s, e)) % n;
    }

    // Проверка по Эль Гамалю
    static boolean check_El_Gamal(long x, long k, long m) {

        long y = ((long) Math.pow(g, x)) % p;
        long a = ((long) Math.pow(g, k)) % p;

        long k1 = (long) Math.pow((1 % (p - 1)) * 1.0 / k, -1);
        long b = (k1 * (m - x * a)) % (p - 1);

        return (Math.pow(y, a) * Math.pow(a, b)) % p == ((long) Math.pow(g, m) % p);
    }




}