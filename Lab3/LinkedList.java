
public class LinkedList {
     int size;
    private Node head;
    private Node tail;
    Node current;

    /* Конструктор без аргументів */
    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }
    /* Додати елемент в кінець списку */
    public void add(Integer data) {
        Node nod = new Node();
        nod.setData(data);
       if(tail == null){
           head = nod;
           tail = nod;
       }else {
           tail.setNext(nod);
           tail = nod;
       }
       size++;//а указатель на первый элемент теперь ссылается на новый элемен
    }
    /* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
    public Integer get(int index) {
        if(head == null || index > size){
            return null;
        }else if(size == 0){
            return head.getData();
        }else {
            current = head;
            while (index>0){
                if(current == null){
                    return null;
                }else {
                    current = current.getNext();
                    index--;
                }
            }return current.getData();
        }
    }
    /* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
    public boolean delete(int index) {
        current = head;
        Node prev = head;
        if (head == null || index > size || index < 0){
            return  false;
        }else if(index == 0){
            head = head.getNext();
            size--;
            return true;
        }else{
            while(index > 0){
                prev = current;
                current = current.getNext();
                index--;
            }
            prev.setNext(null);
            prev.setNext(current.getNext());
            size--;
        }
        return true;
    }
    /*Поверта розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
    public int size() {
        return size;
    }
}