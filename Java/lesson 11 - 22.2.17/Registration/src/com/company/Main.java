package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("users.txt");

        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write("hello lkshdf lsdfl sdlkfg aslfhk sdlfsdlg sdglsdl lskdghalfh alfladfl;kjsdglk l \n akfjgaskf kajgka".getBytes());
            FileInputStream in = new FileInputStream(file);

//            byte[] buffer = new byte[1024];
//           int length = in.read(buffer);
//            String data = new String(buffer,0,length);
//            String datdda = new String();

          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//            InputStreamReader reader = new InputStreamReader(in);
            StringBuilder sb = new StringBuilder();
            String data = "";
            while ((data=bufferedReader.readLine())!=null){
                sb.append(data+"\n");

            }
            System.out.println(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
