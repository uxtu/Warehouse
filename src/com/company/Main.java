package com.company;

public class Main {

    public static void main(String[] args) {
		long m = System.currentTimeMillis();
		System.out.println((double) (System.currentTimeMillis() - m));
	    Warehouse wh = new Warehouse(10,3); //10 = склад, 3 = сколько за раз выкупается
	    Producer producer = new Producer(wh);
	    Consumer consumer = new Consumer(wh);
	    new Thread(producer).start();
	    new Thread(consumer).start();

    }
}
