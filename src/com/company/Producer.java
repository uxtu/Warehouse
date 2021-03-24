package com.company;

public class Producer implements Runnable{
    private Warehouse wh;
    Producer(Warehouse wh){
        this.wh = wh;
    }
    @Override
    public void run() {
        try {
            for(int i = 0; ; i++)
                wh.buy();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
