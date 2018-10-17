package getstart;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * hystrix快速开始类
 *
 * @author qsnp241
 * @crate 2018-10-17 16:03
 */
public class HystrixObservableCommandHelloWord extends HystrixObservableCommand<String> {
    private String  name;

    protected HystrixObservableCommandHelloWord(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        //return  "Hello "+ name + " !";
        return null;
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        return null;
    }

    public static void main(String[] args){
        new HystrixObservableCommandHelloWord("李四").observe();
        new HystrixObservableCommandHelloWord("李四").toObservable();
    }

}