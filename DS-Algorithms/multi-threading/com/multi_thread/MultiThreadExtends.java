package com.multi_thread;

class Method1 extends Thread {
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("MultiThreadExtends.method1()" + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

class Method2 extends Thread {
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("Method2" + i);
		}
	}
}

public class MultiThreadExtends extends Thread {
	public static void main(String[] args) {
		Thread method1 = new Method1();
		Thread method2 = new Method2();
		method1.start();
		method2.start();
	}
}
