package thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

	static ExecutorService service = Executors.newFixedThreadPool(5);
	static Cache cache = new Cache(500);
	static Object lock = new Object();

	public static void main(String[] args) throws Exception {

		List<Future<String>> futures = new LinkedList<>();

		for (int i = 0; i < 50; i++) {
			futures.add(service.submit(new Worker(i, cache)));
		}

		futures.forEach(future -> {
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

class Cache {

	private int size;

	public Cache(int size) {
		this.size = size;
	}

	Map<String, String> map = new ConcurrentHashMap<>();

	void set(String key, String value) {
		map.put(key, value + "___" + Thread.currentThread().getName());

		// If size reached almost full.do clean up
		if (size - (currentSize() + 10) >= 0) {

		}
	}

	String get(String key) {
		return map.get(key);
	}

	int currentSize() {
		return map.size();
	}
}

class Worker implements Callable<String> {

	private int data;
	private Cache cache;

	public Worker(int data, Cache cache) {
		this.data = data;
		this.cache = cache;
	}

	@Override
	public String call() throws Exception {
		String result = null;
		if (data % 2 == 0) {
			cache.set(String.valueOf(data), String.valueOf(data));
			result = cache.get(String.valueOf(data));
		} else {
			result = cache.get(String.valueOf(data - 1));
		}
		return result;
	}
}