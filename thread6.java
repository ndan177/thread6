package thread6;
class A{
    public void smt(){
        try{
            for(int i=5;i>0;i--){
                System.out.println("Count: " + i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class UsingThread extends Thread{
    private Thread th;
    private String threadName;
    A a;
    
    public UsingThread(String name, A incomingA){
        threadName=name;
        a= incomingA;
    }
    public void run(){
        synchronized(a){
            a.smt();
        }
        System.out.println("Thread "+ threadName +" exists now");
    }
    public void start(){
        System.out.println("thread "+threadName+ "has started");
        if(th==null){
            th=new Thread(this, threadName);
            th.start();
        }
    }
}
public class Thread6 {
    
    public static void main(String[] args) {
        A aob=new A();
        UsingThread th1= new UsingThread("first thread ",aob);
        UsingThread th2= new UsingThread("second thread ",aob);
        th1.start();
        th2.start();
        
        try{
            th1.join();
            th2.join();
        }catch(Exception e){
            System.out.println("throus with it");
        }
    }
}
