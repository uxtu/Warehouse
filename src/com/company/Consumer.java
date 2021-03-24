package com.company;

public class Consumer implements Runnable{
    private Warehouse wh;
    Consumer(Warehouse wh){
        this.wh = wh;
    }
    @Override
    public void run() {
        try {
            for(int i = 0; ; i++)
                wh.sale();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
