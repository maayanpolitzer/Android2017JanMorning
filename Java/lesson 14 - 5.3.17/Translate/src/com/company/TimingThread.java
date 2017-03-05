package com.company;

/**
 * Created by hackeru on 05/03/2017.
 */
public class TimingThread extends Thread {

    private OnDelayEndListener listener;  // null

    public TimingThread(OnDelayEndListener listener){
        this.listener = listener;
    }

    @Override
    public void run() {
        while(listener.isWorking()) {
            listener.changeWords();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("CRASH!!!");
                return; // break also possible...
            }
        }
    }
}
