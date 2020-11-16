
public class Reservation
{
 private String clientName;
 private int reservationCode;
 private int arrival, stay, person;
 private Room room=null;
 private static int counter=1;//Μεταβλητη κλασης για να κραταει τον κωδικο κρατησης θετικο και μοναδικο για καθε δωματιο. 
 //Δημιουργος της κλασης Reservation
 public Reservation(String clientName, int arrival, int stay, int person)
 {   ++counter;//Μεταβλητη ωστε να διαφερει καθε φορα ο κωδικος κρατησης.
     this.reservationCode=counter; //τα this.κατι μας βοηθουν στο να καλεστει η τιμή που δώθηκε απο πριν.
     this.clientName=clientName;
     this.person=person;
     this.arrival=arrival;
     this.stay=stay;
 }    
     //Μεθοδος κλάσης
     public void setRoom(Room room){this.room=room;}
     //Μεθοδοι στιγμιότυπων
     public String getclientName() { return clientName; }
     public int getreservationCode() {return reservationCode;}
     public int getperson() {return person;}
     public int getarrival() {return arrival;}
     public int getstay() {return stay;}
     public Room getRoom(){return room;}
}
