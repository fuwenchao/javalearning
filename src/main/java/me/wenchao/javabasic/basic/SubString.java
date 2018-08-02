package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 14:15 2018/7/5
 * @DESC
 */
public class SubString {
    public static void main(String[] args) {
        String str = "付r文超wenchaofu";
        String subStr = subString(str, 2, 2);
        String subStr2 = subString2(str, 3);
        String subStr3 = subString3(str, 4);
        System.out.println(subStr3);
    }

    private static String subString(String str, int beginIndex, int length) {
        StringBuilder sb = new StringBuilder();
        if (beginIndex < 0 || beginIndex > str.length() || (length + beginIndex) > str.length()) {
            throw new IndexOutOfBoundsException("out of string ");
        }
        char[] chars = str.toCharArray();
        for (int i = beginIndex; i < beginIndex + length; i++) {
            char chr = chars[i];
            sb.append(chr);


        }

        return sb.toString();
    }

    // 这样写是不正确的
    private static String subString2(String str, int length) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {

            sb.append(String.valueOf(bytes[i]));

        }

        return sb.toString();

    }

    private static String subString3(String str, int length) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {

            if (count < length) {
                if (isChinese(aChar)) { //如果是中文
                    count += 2;
                    if (count <= length) {
                        sb.append(aChar);
                    } else break;

                } else {
                    sb.append(aChar);
                    count++;

                }
            }else break;
        }
        return sb.toString();

    }

    private static boolean isChinese(char aChar) {
        String str = String.valueOf(aChar);
        if (str.getBytes().length > 1) {
            return true;
        }
        return false;


    }
}
