package ua.ithillel.lesson24_client_server;

import org.postgresql.ds.PGSimpleDataSource;
import ua.ithillel.lesson23_patterns.HeroDto;
import ua.ithillel.lesson23_patterns.HeroFabric;
import ua.ithillel.lesson23_patterns.HeroService;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HeroServer {

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
//        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("Hero");
        ds.setUser("postgres");
        ds.setPassword("ira");
        return ds;
    }

    public static void main(String[] args) throws IOException {

        DataSource dataSource = dataSource();
        HeroService heroService = HeroFabric.createService(dataSource);

        try (var serverSocket = new ServerSocket(8080)) {

            System.out.println("Connection successful");
            System.out.println("Listening on port 8080 . . .");
            while (true) {

                var socket = serverSocket.accept();
                new Thread(new ServerHandle(socket, heroService)).start();
                System.out.println("Connection successful");
                System.out.println("Waiting for input . . . ");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static class ServerHandle implements Runnable {
        private final Socket socket;
        private final HeroService heroService;

        public ServerHandle(Socket socket, HeroService heroService) {
            this.socket = socket;
            this.heroService = heroService;
        }

        @Override
        public void run() {
            try (var out = new PrintWriter(socket.getOutputStream(), true);
                 var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String inputLine;
                //Чекаємо вхідні дані та надсилаємо їх назад
                while (!socket.isClosed() && (inputLine = in.readLine()) != null) {
                    String[] tokens = inputLine.split(" ");
                    if (tokens[0].equals("name")) {
                        String heroName = tokens[1];

                        if (!tokens[2].isEmpty()) {
                            heroName = tokens[1] + " " + tokens[2];
                        }
                        String finalHeroName = heroName;
                        HeroDto heroDto = heroService.getHeroes()
                                .stream()
                                .filter(heroes -> heroes.getName().equals(finalHeroName))
                                .findFirst()
                                .orElse(null);
                        if (heroDto != null) {
                            out.println(heroDto.toString());
                        } else {
                            out.println("Hero not found.");
                        }
                    } else if (tokens[0].equals("exit")) {
                        System.out.println("Client exit the server!");
                        socket.close();
                    } else {
                        out.println("Unknown command.");
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
