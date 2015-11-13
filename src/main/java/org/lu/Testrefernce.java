package org.lu;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Testrefernce {
	public static void main(String... args) {
		One one = new One("aaa", "bbb");

		ReferenceQueue<Object> rq = new ReferenceQueue<>();

		PhantomReference<One> wr = new PhantomReference<>(one, rq);
		one = null;
		System.gc();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rq.poll());

	}

	// static One old;

	static class One {
		final String a;
		final String b;

		One(String a, String b) {
			this.a = a;
			this.b = b;
		}

		@Override
		protected void finalize() throws Throwable {
			try {
				System.out.println("cleaning...");
			} catch (Throwable t) {
				throw t;
			} finally {
				super.finalize();
			}
		}

	}

	@SuppressWarnings("unchecked")
	static void testWeakRef() {
		One one = new One("aaa", "bbb");
		One two = one;

		ReferenceQueue<Object> rq = new ReferenceQueue<>();

		WeakReference<One> wr = new WeakReference<>(one, rq);
		one = null;
		two = null;
		System.out.println(wr.get());
		System.out.println(rq.poll());
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(wr.get());
		System.out.println(((WeakReference<One>) rq.poll()).get());
	}

	static void testWeakMap() {
		Map<One, String> weakmap = new WeakHashMap<>();

		One a = new One("aa", "aaa");
		One b = new One("bb", "bbb");

		weakmap.put(a, "abc");
		weakmap.put(b, "aaa");

		a = null;
		System.gc();

		System.out.println(weakmap);
	}
}
