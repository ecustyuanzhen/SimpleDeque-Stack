import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
	
	int size;
	node firstnode;
	node lastnode;
	   public Deque(){						// construct an empty deque
		   firstnode = new node();
		   lastnode = new node();
		   lastnode.previous = firstnode;
		   firstnode.next = lastnode;
		   size = 0;
	   }                           
	   public boolean isEmpty(){			// is the deque empty?	
		   return size < 0;
	   }                 
	   public int size(){					// return the number of items on the deque	
		   return size;
	   }                        
	   public void addFirst(Item item) {		// add the item to the front
		   if(item!=null){
			   node currentnode = new node();
			   firstnode.item = item;
			   currentnode.next = firstnode;
			   firstnode.previous = currentnode;
			   firstnode = currentnode;  
			   size++;
		   }else {throw new IllegalArgumentException("addFirst() or addLast() with a null argument")  ;}
		   	   
	   }          
	   public void addLast(Item item){		// add the item to the end
		   if(item!=null){
			   node currentnode = new node();
			   lastnode.item = item;
			   lastnode.next = currentnode;
			   currentnode.previous = lastnode;
			   lastnode = currentnode;	
			   size++;
		   }else {throw new IllegalArgumentException("addFirst() or addLast() with a null argument")  ;}
	   }           
	   public Item removeFirst(){		   // remove and return the item from the front
		   if(isEmpty()){
			   throw new NoSuchElementException("NoSuchElement");
		   }else{
			   firstnode.next = firstnode.next.next;
			   firstnode.next.previous = firstnode;	
			   size--;
			   return firstnode.next.item;
		   }
		   
	   }                
	   public Item removeLast(){			// remove and return the item from the end
		   if(size<1){
			   throw new NoSuchElementException("NoSuchElement");
		   }else{
			   lastnode.previous = lastnode.previous.previous;
			   lastnode.previous.next = lastnode;
			   size--;
			   return lastnode.previous.item;
		   }
	   }                 
	   public Iterator<Item> iterator(){	// return an iterator over items in order from front to end
		   return new duqueiterator();
	   }         
	   public static void main(String[] args){
		   Deque<Integer> deque = new Deque<Integer>();// unit testing (optional)
		   
		   for(int i=1;i<9;i++){
			   deque.addFirst(i);
		   }
		   for(int i=0;i<9;i++){
			   deque.addLast(i);
		   }
		   for(int i=0;i<8;i++){
			   deque.removeFirst();
		   }
		   for(int i=0;i<9;i++){
			   deque.removeLast();
		   }
		   deque.addFirst(0);
		   Iterator<Integer> dequeIterator = deque.iterator();
		   //dequeIterator.remove();
		   System.out.println("³¤¶È£º"+deque.size);
		   //System.out.print(deque.firstnode.next.item);
		   while (dequeIterator.hasNext()) {
			  //System.out.print(-1); 
			System.out.print(dequeIterator.next());
		}
		   
		   
	   }   
	   class node{
		   Item item;
		   node next;
		   node previous;
	   }
	   class duqueiterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			firstnode = firstnode.next;
			if (firstnode!=lastnode) {
				
				return true;
			}
			return false;
		}

		@Override
		public Item next() {
			 if(size<1){
				   throw new NoSuchElementException("NoSuchElement");
			   }else{
				   return firstnode.item;
			   }
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("UnsupportedOperation");
		}
	
		  
	   }
}
