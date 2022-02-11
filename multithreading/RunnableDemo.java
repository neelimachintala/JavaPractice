package multithreading;

public class RunnableDemo  implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<2;i++){

            try{
                Thread.sleep(1000);
                System.out.println("Thread running is "+ Thread.currentThread().getName()+" in State "+ Thread.currentThread().getState());
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo r1=new RunnableDemo();
       Thread t0=new Thread(r1);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);
        t0.start();
        System.out.println("Current thread:"+Thread.currentThread().getName());
        t0.join();

        t1.start();
        System.out.println("Current thread:"+Thread.currentThread().getName());
        t1.join();

        t2.start();
        t2.join();
        System.out.println("t0 state"+ t0.getState());
        System.out.println("t1 state"+ t1.getState());
        System.out.println("t2 state"+ t2.getState());

    }
}
