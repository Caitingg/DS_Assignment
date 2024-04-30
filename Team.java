import java.util.NoSuchElementException;

public class Team {

    String teamName;
    int size;
    Node<Player1>head;
    Node<Player1>tail;

    int sumSalary;


    public Team(String teamName){
        this.teamName=teamName;

    }

    public void addPlayer(Player1 a){
        Node<Player1>newNode=new Node(a);
        if(size>=15){
            System.out.println("Team size much not exceed 15 players");
            return;
        }
        if(sumSalary+a.salary>20000){
            System.out.println("You dont have enough money");
            return;
        }
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
        }
        sumSalary +=a.salary;
        size++;
    }

    public void removePlayer(Player1 a){

        Node<Player1>temp=new Node<>(a);
        boolean found=false;
        for(int i=0;i<size;i++){
            if(temp.element.equals(a)){
                found=true;
                break;
            }
            temp=temp.next;
        }

        if(!found) {
            throw new NoSuchElementException("The Player does not in the list");
        }

        temp.previous.next=temp.next;
        temp.next.previous=temp.previous;
        size--;
        sumSalary -=a.salary;
    }

    public boolean isValidTeam(){
        if(size<10){
            return false;
        }
        if(size>15){
            return false;
        }
        if(count("Guards")<2||count("Forwards")<2||count("Centers")<2){
            return false;
        }

        if(sumSalary>20000){
            return false;
        }
        return true;

    }

    public int count(String position){
        int cnt=0;
        Node <Player1>temp=this.head;
        for(int i=0;i<size;i++){
            if(temp.element.getPosition().equals(position)){
                cnt++;
            }
            temp=temp.next;
        }
        return cnt;

    }






}
