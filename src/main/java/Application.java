import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class Application {

    public static void main(String[] args) {

        //create Javalin server object
        //By default server runs on localhost port 8080
        Javalin app = Javalin.create().start();

        //create a GET response to port 8080 root or home page
        // home = /
        // get() takes annon class created from an interface as 2nd argument
        //we can override the handle() in Handler interface to send response to client
        //here we are sending simple "Hello World!" text as response to request to home page.
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello World!");
            }
        });

    }
}
