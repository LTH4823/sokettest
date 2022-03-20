package org.zerock.server.ui;

import org.zerock.server.service.FoodService;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FoodWebServer {

    private FoodService foodService;

    public FoodWebServer(FoodService service){
        this.foodService = service;
    }

    //bad code
    public void doRun()throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server ready..........");

        for (int i = 0; i < 100; i++) {
            Socket client = serverSocket.accept();
            System.out.println(client);
            OutputStream out = client.getOutputStream();
            List<String> foodList = foodService.recommand();

            //String msg = String.join(",", foodList) +"\n";

            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < foodList.size(); j++){
                builder.append("<h1>" + foodList.get(j)+"</h1>");
            }
            String msg = builder.toString();


            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            out.write(msg.getBytes(StandardCharsets.UTF_8));



        }//end for

    }
}
