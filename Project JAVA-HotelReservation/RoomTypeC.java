
public class RoomTypeC extends Room //Αυτη η κλαση κληρονομει την κλαση Room και υπερκαλυπτει την μεθοδο προσθηκς κρατησης ωστε να ελεγχει
{                                  //αν τα ατομα της κρατησης ειναι περισοτερα απο τα ελαχιστα ατομα ,ομοιως και για τις μερες διαμονης με τις ελαχιστες μερες διαμονης.
 private int minPerson, minDays;
 public RoomTypeC(int maxCapacity, int minPerson, int minDays)//Δημιουργος της κλασης RoomTypeC
 {
     super(maxCapacity, 0);
     this.minPerson=minPerson;
     this.minDays=minDays;
 }
    public boolean getReservation(Reservation res) //Αυτη η μεθοδος διαβαζειτον πινακα διαθεσιμοτητας ελεγχοντας αν τα ατομα της κρατησης ενος δωματιου ειναι περισοτερα απο τα ελαχιστα ατομα
 {                                                 //οπως και οι μερες διαμονης με τις ελαχιστες μερες διαμονης,αν ισχυουν αυτες οι προυποθεσεις επιστρεφει true αλλιως false.
     for (int i=res.getarrival()-1; i<res.getarrival()+res.getstay()-1; i++)
     {  
     if(listAvailable[i]!=null)
       return false;
       if(res.getperson()>maxCapacity)
       return false;
       if(res.getperson()>=minPerson && res.getstay()>=minDays)
       return true;
    }
     for (int i=res.getarrival()-1; i<res.getarrival()+res.getstay()-1; i++)                    
     listAvailable[i]=res;
     res.setRoom(this);
     return true;
 }    
}