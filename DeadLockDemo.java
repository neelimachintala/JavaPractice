package multithreading;

import static multithreading.DeadlockDemo.s1;
import static multithreading.DeadlockDemo.s2;

class DeadlockDemo {
    public static String s1="Java";
    public static String s2="Hello World";
    public static void main(String[] args) {
        Thred1 t1=new Thred1();
        Thred2 t2=new Thred2();
        t1.setName("first thread");
        t2.setName("second thread");
        t1.start();
        t2.start();

    }



}
class Thred1 extends Thread{
    public void run(){
        while(true){
            synchronized(s1)
            {
                System.out.println(Thread.currentThread().getName()+ " Locked " +s1);
                synchronized (s2) {
                    System.out.println(Thread.currentThread().getName()+ " Locked " +s2);

                }
            }
        }
    }
}
class Thred2 extends Thread{
  public void run(){
        while(true){
            synchronized(s2)
            {
                System.out.println(Thread.currentThread().getName()+ " Locked " +s2);
                synchronized (s1) {
                    System.out.println(Thread.currentThread().getName()+ " Locked " +s2);

                }
            }
        }
        }
        }


























