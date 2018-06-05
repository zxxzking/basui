package com.lv.basui.test;

public class Producer implements Runnable {

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            synchronized (goods){
                if(goods.getNum() > 0){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(i % 2 == 0){

                    goods.setPinpai("aaa");
                }

            }

        }

    }
}
