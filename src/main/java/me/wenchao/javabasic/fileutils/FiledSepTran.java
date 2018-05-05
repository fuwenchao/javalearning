package me.wenchao.javabasic.fileutils;

import java.io.*;

/**
 * @Author wenchaofu
 * @DATE 17:44 2018/5/3
 * @DESC
 */
/** desc
 * file.rst
 * a|b|c
 * 1|2|3
 * convert to
 * a-b-c
 * 1-2-3
 */
public class FiledSepTran {
    public static final String OLD_SEP = "\\|";
    public static final String NEW_SEP = "-";
    public static final String filename = "D:\\file.txt";
    public static final String newfilename = "D:\\file_new.txt";



    public static void main(String[] args) throws IOException {
        int n = 0;
        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfilename)));
        while (( line = br.readLine()) != null) {
            sb.append(convertLine(line)).append("\r\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }


    private static String convertLine(String line){
        StringBuilder newLine = new StringBuilder();
        String[] fields = line.split(OLD_SEP);
        for (String field : fields) {
            System.out.println(field);
            newLine.append(field).append(NEW_SEP);
        }

        return newLine.substring(0,newLine.length()-1).toString();
    }
}
