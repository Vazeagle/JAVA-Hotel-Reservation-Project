public class Room
{
private int roomCode;
protected int maxCapacity;
private double pricePerPerson;
private static int counter;
Reservation[] listAvailable=new Reservation[30]; 
public Room( int maxCapacity, double pricePerPerson)//Δημιουργος της κλασης Room
{
    ++counter;
    this.roomCode=counter;
    this.maxCapacity=maxCapacity;
    this.pricePerPerson=pricePerPerson;
}   
 public int getroomCode(){return roomCode;}
 public int getmaxCapacity(){return maxCapacity;}
 public double getpricePerPerson(){return pricePerPerson;}
 
 public double income()//Μεθοδος Τιμολογησης. Αυτη η μεθοδος υπολογιζει συνολικο το εισοδημα με βαση τα ατομα που διαμενουν.
 {
     double cost=0;
      for (int i=0; i<30; i++)
      if(listAvailable[i]!=null)
      cost+=listAvailable[i].getperson()*pricePerPerson;
     
     return cost;
}
public boolean cancel(int cancelCode)//Μεθοδος Ακυρωσης. Αυτη η μεθοδος  παιρνοντας σαν ορισμα τον κωδικο μιας κρατησης
{                                    // αφαιρει απο τον πινακα διαθεσιμοτητας την κρατηση για το δωματιο.
    for (int i=0; i<30; i++)
    if(listAvailable[i]!=null)
    if(listAvailable[i].getreservationCode()==cancelCode)
    listAvailable[i]=null;
    return true;
}
public double full()//Μεθοδος Πληροτητας. Αυτη η μεθοδος επιστρεφει το ποσοστο(%)πληροτητας του δωματιου.
{
    int full=0;
    for (int i=0; i<30; i++)
    if(listAvailable[i]!=null)
    full++;
    return (full/30)*100;
}    
public boolean check(int i){return ((this.listAvailable[i] == null)?false:true);} 
}
 













