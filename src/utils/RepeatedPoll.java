package utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RepeatedPoll {
	
	private static final class MyDaemonFactory implements ThreadFactory {
		
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
		
		public MyDaemonFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                          poolNumber.getAndIncrement() +
                         "-thread-";
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread daemonThread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
			if (!daemonThread.isDaemon())
				daemonThread.setDaemon(true);
			if (daemonThread.getPriority() != Thread.NORM_PRIORITY)	
				daemonThread.setPriority(Thread.NORM_PRIORITY);
			return daemonThread;

		}
	}

	private final static ScheduledExecutorService scheduler; 
	
	
	static {
		// just a dirty trick to start as a deamon thread.
		// Thus it is automatically shut down at main-end.
		ThreadFactory deamonThreadFactory = new MyDaemonFactory();
		scheduler = Executors.newScheduledThreadPool(1, deamonThreadFactory);
//		scheduler = Executors.newScheduledThreadPool(1);
	}

	private RepeatedPoll() {
	}
	
	public static RepeatedPoll otsf = new RepeatedPoll();
	
	public static RepeatedPoll getInstance() {
		return otsf;
	}
	
	public void repeat(Runnable r) {
		scheduler.scheduleAtFixedRate(r, 100, 100, TimeUnit.MILLISECONDS);
	}

	public void stop() {
		scheduler.shutdown();
	}
	

}
