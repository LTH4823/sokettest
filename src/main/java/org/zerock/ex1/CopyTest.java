package org.zerock.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class CopyTest {

    //bad code
    public static void main(String[] args)throws Exception {

        String path = "";

        InputStream inputStream = new URL(path).openStream();


        //InputStream inputStream = new FileInputStream("C:\\zzz\\aaa.jpg");

        System.out.println(inputStream);

        OutputStream outputStream = new FileOutputStream("C:\\zzz\\copy.mp4");

        long start = System.currentTimeMillis(); //1970-01-01

        byte[] buffer = new byte[8096];

        while(true){
            int count = inputStream.read(buffer);
            System.out.println(count);
            if(count == -1){
                break;
            }

            outputStream.write(buffer, 0, count);
        }//end while

        long end = System.currentTimeMillis();

        System.out.println("------------------------");
        System.out.println(end - start);

    }
}
