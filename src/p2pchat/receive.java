package p2pchat;



public class receive implements Runnable {
 
    Client c;

    receive(Client aThis) {
        c = aThis;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            c.receive();
        }
    }
}
