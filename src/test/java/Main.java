import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.zst.web.handler.StaticResourceHandler;

@Singleton
public class Main {
    @Inject
    StaticResourceHandler staticResourceHandler;

    public static void main(String[] args){
        Injector injector = Guice.createInjector();
        Main obj = injector.getInstance(Main.class);
        System.out.println(obj.staticResourceHandler);
    }
}
