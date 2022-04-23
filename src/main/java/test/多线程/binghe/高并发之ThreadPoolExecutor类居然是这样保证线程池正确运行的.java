package test.多线程.binghe;

//https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489398&idx=1&sn=307c7b3d78aa275a682263bd218f9a1d&chksm=cf55a077f822296112d619dbc1641725d59c7b826ae59cb3216aa2bcf98fd15e100ded7d2fce&cur_album_id=1659019088070803460&scene=189#wechat_redirect

import java.util.concurrent.*;

class CustomPolity implements RejectedExecutionHandler{

    public CustomPolity() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()){
            System.out.println("使用调用者所在的线程来执行任务");
            r.run();
        }
    }
}

public class 高并发之ThreadPoolExecutor类居然是这样保证线程池正确运行的 {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new CustomPolity());
}
