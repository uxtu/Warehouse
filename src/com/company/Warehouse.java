package com.company;

public class Warehouse {
    private int remainder = 0;
    private int forSale = 0;
    Warehouse(int p, int s){
        this.remainder = p;
        this.forSale = s;
    }
    public synchronized void sale() throws InterruptedException {
        while(remainder < forSale){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        remainder -= forSale;
        System.out.println("Sold " + forSale + " product, remainder = " + remainder);
        if(remainder == 0 ){ // если склад пуст заканчиваем выполнеение
            System.out.println("Warehouse is empty");
            System.exit(-1);
        }
        wait(1000);
        notify();
    }

    public synchronized void buy() throws InterruptedException {
        int forBuy = forSale + 2;
        while(remainder > forBuy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        remainder += forBuy;
        System.out.println("Bought " + forBuy + " product, remainder = " + remainder);
        wait(1000);
        notifyAll();
    }
}
