package exercise.daytime;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;


public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init(){
        System.out.println("Bean " + getName() + " is initialized");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Cleaning up resources or performing final actions!");
    }
    // END
}
