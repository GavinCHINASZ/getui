public class Test01 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 9800000; i++) {
            for (int j = 0; j < 200; j++) {
                if (j == i){

                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
