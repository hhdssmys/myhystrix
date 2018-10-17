package getstart;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 这是一个hystrix入门学习类
 *
 * @author qsnp241
 * @crate 2018-10-17 15:03
 */
public class CommandHelloWorld  extends HystrixCommand<String> {
    private String  name;

    protected CommandHelloWorld(String  name) {
        super(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        int a = 1/0;
        return  "Hello "+ name +" !";
    }

    @Override
    protected String getFallback() {
        return "error" + name;
    }

    public static void main(String[] args){
        String result = new CommandHelloWorld ("张三").execute();
        System.out.println(result);
    }
}