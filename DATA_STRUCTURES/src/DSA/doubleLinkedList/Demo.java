package DSA.doubleLinkedList;
public class Demo extends Thread {
	public static void main(String[] args) {
    DoubleLinkedList list = new DoubleLinkedList();
    list.insertAtBegining(19);
    list.insertAtBegining(122);
    list.insertAtBegining(133);
    list.insertAtBegining(11);
    list.insertAtBegining(18);
    list.display();
    list.displayReverce();
    list.delAtPos(9);
    list.display();
    list.displayReverce();
}}
