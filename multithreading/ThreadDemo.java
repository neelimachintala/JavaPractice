package multithreading;

public class ThreadDemo extends Thread{
    public static ThreadDemo t1;
    public static void main(String[] args) throws InterruptedException {
        System.out.println(currentThread().getName());//only one thread : main thread
        t1=new ThreadDemo();//new thread created
        System.out.println(t1.getState()); // in new state
        t1.start();
        Thread.sleep(1000);//main thread goes to sleep for 1 sec
        // t1 is in timed wait if main finishes its execution before t1 and t1 is in sleep.

        System.out.println("state of t1 "+ t1.getState());
        }

    @Override
    public void run(){
        try{
            System.out.println("in run " +t1.getState());//in runnable
            t1.sleep(3000);//sleeping here

        }catch(Exception e){
            System.out.println(e);
        }

        }
}
