


public class LinkList<item> {

	public LinkList() {
		this.first = null;
	}
	node first;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList<Integer> list = new LinkList<Integer>();
		for(int i=1;i<10;i++){
			list.addnode(i);
			list.addnode(i);
		}		
		
		//System.out.print(list.first.next.next);
		list.deleteRepeat();
		System.out.print("头指针："+list.first().value);		
	}
	class node{
		item value;
		node next;
	}
	void addnode(item item){
		node node = new node();
		node.value = item;
		if(first==null){
			first = node;
			first.next = null;
		}else {
			node.next = first;
			//System.out.print(first.next);
			first = node;
		}
		
	}
	node first(){
		return first;
	}
	void deleteRepeat(){
		node temp = first;
		node temp1 = first;
		System.out.print("原始栈数据：");
		while (temp.next!=null) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println(temp.value+" ");
		System.out.print("当前栈数据：");
		while (temp1.next!=null) {
			if(temp1.value==temp1.next.value ){
				temp1.next = temp1.next.next;
			}else {
				
				System.out.print(temp1.value+" ");
				temp1 = temp1.next;
			}
		}
		//System.out.print(first.value);
		
		//System.out.print(first.value);
		System.out.println(temp.value+" ");
	}
		
}
