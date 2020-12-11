package com.qh.venus.achilles.framework.idgen;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SequenceTestApi {
	public static void main(String[] args) {

		Set<Long> ids = new HashSet<Long>();
		for (int i = 0; i < 10; i++) {
			Long id = BuildIdFactory.getInstance().buildFactoryId("order");
			ids.add(id);
			System.out.println(id);
		}
		System.out.println("ids >>>>>>" + ids.size());
		long current = System.currentTimeMillis();
		buildId();
		System.err.println(System.currentTimeMillis() - current);
	}

	protected static void buildId() {

		CountDownLatch countDownLatch = new CountDownLatch(1000);
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					System.out.println("++++++++++id:" + BuildIdFactory.getInstance().buildFactoryId("order")
							);
				}
				countDownLatch.countDown();
			});
			thread.setName("thread-" + i);
			thread.start();
		}

		try {
			countDownLatch.await();
		} catch (Exception e) {

		}

	}

	protected static String getOrder() {
		Random random = new Random();
		int a = random.nextInt(8) + 1;
		String[] strArray = { "a", "b", "c", "d", "e", "f", "g", "h", "f" };
		return strArray[a];
	}
}
