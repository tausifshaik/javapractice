package com.learning.basics;
	
/*
 * In Java, the programmers don’t need to take care of destroying the objects that are out of use. The Garbage Collector takes care of it.
		Garbage Collector is a Daemon thread that keeps running in the background. Basically, it frees up the heap memory by destroying the unreachable objects.
		Unreachable objects are the ones that are no longer referenced by any part of the program.
		We can choose the garbage collector for our java program through JVM options, we will look into these in later section of this tutorial.
 */

/*
 * How Automatic Garbage Collection works?
		Automatic Garbage collection is a process of looking at the Heap memory, identifying(also known as “marking”) the unreachable objects, and destroying them with compaction.
		An issue with this approach is that, as the number of objects increases, 
		the Garbage Collection time keeps on increasing, as it needs to go through the entire list of objects, looking for the unreachable object.
		
		However, the empirical analysis of applications shows that most of the objects are short-lived.
		
		This behavior was used to improve the performance of JVM, and the adopted methodology is commonly called Generational Garbage Collection.
		In this method, the Heap space is divided into generations like Young Generation, Old or Tenured Generation, and Permanent Generation.
		
		The Young generation heap space is the new where all the new Objects are created. Once it gets filled up, minor garbage collection (also known as, Minor GC) takes place.
		 Which means, all the dead objects from this generation are destroyed 
		This process is quick because as we can see from the graph, most of them would be dead. The surviving objects in young generation are aged and eventually moves to the older generations.
		The Old Generation is used to store long surviving objects. Typically, a threshold is set for young generation object and when that age is met, 
		the object gets moved to the old generation. Eventually, the old generation needs to be collected. This event is called a Major GC (major garbage collection). 
		Often it is much slower because it involves all live objects.
		Also, there is Full GC, which means cleaning the entire Heap – both Young and older generation spaces.
 */


/*
 * Java Garbage Collectors
	The JVM actually provides four different garbage collectors, all of them generational. Each one has their own advantages and disadvantages.
	The choice of which garbage collector to use lies with us and there can be dramatic differences in the throughput and application pauses.
	
	All these, split the managed heap into different segments, using the age-old assumptions that most objects in the heap are short-lived and should be recycled quickly.
	
	So, the four types of garbage collectors are:
	Serial GC (-XX:+UseSerialGC): Serial GC uses the simple mark-sweep-compact approach for young and old generations garbage collection i.e Minor and Major GC.
	Serial GC is useful in client-machines such as our simple stand alone applications and machines with smaller CPU. It is good for small applications with low memory footprint.

	Parallel/Throughput GC This is JVM’s default collector in JDK 8. As the name suggests, it uses multiple threads to scan through the heap space and perform compaction.
	 A drawback of this collector is that it pauses the application threads while performing minor or full GC.
	It is best suited if applications that can handle such pauses, and try to optimize CPU overhead caused by the collector.
	
	The CMS collector
	The CMS collector (“concurrent-mark-sweep”) algorithm uses multiple threads (“concurrent”) to scan through the heap (“mark”) for unused objects that can be recycled (“sweep”).
	
	This collector goes in Stop-The-World(STW) mode in two cases:
	-While initializing the initial marking of roots, ie. objects in the old generation that are reachable from thread entry points or static variables
	-When the application has changed the state of the heap while the algorithm was running concurrently 
	and forcing it to go back and do some final touches to make sure it has the right objects marked.
	
	G1 collector
Last but not the least is the Garbage-First collector, designed for heap sizes greater than 4GB. It divides the heap size into regions spanning from 1MB to 32Mb, based on the heap size.

There is a concurrent global marking phase to determine the liveliness of objects throughout the heap. 
After the marking phase is complete, G1 knows which regions are mostly empty. It collects unreachable objects from these regions first, which usually yields a large amount of free space. So G1 collects these regions(containing garbage) first, and hence the name Garbage-First. G1 also uses a pause prediction model in order to meet a user-defined pause time target. It selects the number of regions to collect based on the specified pause time target.

 */
public class GarbageCollectionEx {

}
