package com.issoft.store.threads;

import com.issoft.store.commands.OrderCommand;

public class CleanUpCollectionThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OrderCommand orderCommand = new OrderCommand();
        orderCommand.getSelectedProducts().clear();
    }
}
