import cn.hutool.crypto.digest.DigestUtil;

public class Test01 {
    public static void main(String[] args) {
        /*long l = System.currentTimeMillis();
        for (int i = 0; i < 9800000; i++) {
            for (int j = 0; j < 200; j++) {
                if (j == i){

                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);*/

        // 999999 Rƞ:W3��31��?.
        // 888888 !!��w�M+��,3�
        String md5 = getMd5("999999");
        System.out.println(md5);
    }

    public static String getMd5(String str){
        try {
            byte[] bytes = DigestUtil.md5(str);
            String string = new String(bytes, "UTF-8");
            return string;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
