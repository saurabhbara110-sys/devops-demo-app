import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Hello {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8081), 0);

        // Home endpoint
        server.createContext("/", (HttpExchange exchange) -> {

            String response = "Hello from DevOps Demo App!";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        // Health endpoint
        server.createContext("/health", (HttpExchange exchange) -> {

            String response = "{\"status\":\"UP\"}";

            exchange.getResponseHeaders()
                    .set("Content-Type", "application/json");

            exchange.sendResponseHeaders(200, response.length());

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        // Info endpoint
        server.createContext("/info", (HttpExchange exchange) -> {

            String response =
                    "{\"application\":\"devops-demo-app\",\"version\":\"1.0\"}";

            exchange.getResponseHeaders()
                    .set("Content-Type", "application/json");

            exchange.sendResponseHeaders(200, response.length());

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        server.start();

        System.out.println("DevOps Demo App started on port 8081");
    }
}
