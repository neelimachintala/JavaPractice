package multithreading;

public class SynchroniziedMethodsDemo {
    public static void main(String[] args) {
        Values v=new Values();
        Thr1 t1=new Thr1(v);
        t1.setName("thread1");
        t1.start();
        Thr2 t2=new Thr2(v);
        t2.setName("thread2");
        t2.start();
        Thr3 t3=new Thr3(v);
        t3.setName("thread3");
        t3.start();


    }

}
class Values{
  synchronized void printValues(int n){
       for(int i=1;i<=5;i++){
         System.out.println(n*i);
        try{
        Thread.sleep(400);
        }catch(Exception e){
            System.out.println(e);
        }
       }

  }
}
class Thr1 extends Thread{
   Values values;
    Thr1(Values values){
        this.values=values;
    }
    public void run(){
        values.printValues(100);
    }
}



class Thr2 extends Thread{
    Values values;
    Thr2(Values values){
        this.values=values;
    }
    public void run(){
        values.printValues(10);
    }
}

class Thr3 extends Thread{
    Values values;
    Thr3(Values values){
        this.values=values;
    }
    public void run(){
        values.printValues(5);
    }
}