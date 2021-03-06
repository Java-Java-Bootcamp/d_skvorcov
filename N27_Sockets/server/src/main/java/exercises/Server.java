package exercises;

import java.net.ServerSocket;

public class Server implements AutoCloseable {
    private final ServerSocket serverSocket;

    public Server(int port) throws Exception {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws Exception {
        System.out.println("listen");

        while (true) {
            var socket = serverSocket.accept();
            try {
                System.out.println("accept: " + socket.getPort());
                try (var client = new ClientHandler(socket)) {
                    client.run();
                }
            }
            catch (Exception e) {
                System.out.println("exception: " + e);
            }
        }
    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
    }

    public static void main(String[] args) throws Exception {
        try (var server = new Server(8081)) {
            server.start();
        }
    }
}