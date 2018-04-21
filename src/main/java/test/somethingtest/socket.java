package test.somethingtest;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by tcc on 2017/6/30.
 */
public class socket {

    public static final int PORT = 8088;

    public static void main(String[] args) {

    }

    public void test() throws Exception{

        InetAddress addr = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(addr, PORT), 30000);
            socket.setSendBufferSize(100);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            int i = 0;

            while (true) {
                System.out.println("client sent --- hello *** " + i++);
                out.write("client sent --- hello *** " + i);
                out.flush();

                Thread.sleep(1000);
            }
        } finally {
            socket.close();
        }
    }
}
