package ru.job4j.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class StringInternDemo {
    public static void main(String[] args) throws InterruptedException {

        String sb = new String("Hello");
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference weakReference = new WeakReference(sb, queue);
        sb = null;
        System.out.println(weakReference.get());
        Runtime.getRuntime().gc();
        String a = String.valueOf(queue.remove().toString());
        System.out.println(a);
        Object referent =  weakReference.get();


        String  savePoint = new String("Hello World");
        ReferenceQueue<String> savepointQ = new ReferenceQueue<>();
        WeakReference<String> savePointWRefernce = new WeakReference<>(savePoint, savepointQ);

        System.out.println("SavePoint created as a weak ref: " + savePointWRefernce);
        Runtime.getRuntime().gc();
        System.out.println("Any weak references in Q ? " + (savepointQ.poll() != null));
        savePoint = null;

        /*
            the only strong reference has been removed. The heap
             object is now only weakly reachable
         */
        System.out.println("Now to call gc...");
        Runtime.getRuntime().gc();

        /*
          the object will be cleared here - finalize will be called
         */
        System.out.println(savepointQ.poll() != null);
        System.out.println("Any weak references in Q ? "
                + (savepointQ.remove().toString()));
        System.out.println(savepointQ.poll() != null);
        System.out.println("Does the weak reference still hold the heap object ? "
                + (savePointWRefernce.get() != null));
        System.out.println("Is the weak reference added to the ReferenceQ  ? "
                + (savePointWRefernce.isEnqueued()));

    }
}
