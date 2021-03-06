/*Αυτη η κλαση διαβαζει μια κρατηση και βλεπει το ποσες μερες ειναι ενα συγκεκριμενο δωματιο δεσμευμενο απο την κρατηση
  και αν οι μερες δεσμευσης του ειναι ισες ή ξεπερνανε τις 5 μερες τοτε το ξενοδοχειο δινει αλλη μια επιπλεον μερα
  δωρεαν διαμονης με την προυποθεση ωστοσο οτι η επομενη μερα απο αυτην που θα εφευγαν θα ηταν κενη,δηλαδη το δωματιο
  την επομενη μια μερα θα ηταν αδειο.*/
public class RoomTypeE extends RoomTypeA //Αυτη η κλαση κληρονομιε την κλαση RoomTypeA.
{
 private  static int freeDay=0;   //Αυτη η μεταβλητη μετραει τις συνολικα δωρεαν ημερες των κρατησεων
 public RoomTypeE(int maxCapacity, double pricePerDay) //Δημιουργος την κλασης RoomTypeE.
 {
 super(maxCapacity, 0);  
 
 }
 public boolean getReservation(Reservation res)//Αυτη η μεθοδος υπερκαλυπτει την μεθοδο προσθηκης κρατησης της Room καιελεγχει αν η επομενη μερα απο τον πινακα  
                                              // διαθεσιμοτητας του δωματιου της κρατησης ειναι ελευθερο τοτε δινεται μια επιπλεον δωρεαν μερα διαμονης στη συγκεκριμενη κρατηση
 {                                           //σε αυτο το δωματιο και επιστρεφεται true αλλιως αν δεν ειναι κενο το δωματιο την επομενη μερα δεν δινεται αυτη η δωρεαν μερα και επιστρεφεται false.
     boolean can=false;
   for (int i=res.getarrival()-1; i<res.getarrival()+res.getstay()-1; i++) //εδω με αυτη την επαναληψει διαβαζεται και ελεγχεται ο πινακας διαθεσημοτητας και η επομενη ημερα μια κρατησης ενως δωματιου.
      if(listAvailable[i]!=null)
       return false;
       if(res.getperson()>maxCapacity)
       return false;
       if(listAvailable[res.getarrival()+res.getstay()]==null){
       can=true;
       freeDay++;}
     for (int i=res.getarrival()-1; i<res.getarrival()+res.getstay()-((can==false)?1:0); i++)  //Εδω ελεγχεται αν η επομενη ημερα ανηκει σε αλλη κρατηση αν οχι τοτέ επιστρεφει true 
                                                                                               //και καταχωρειτε αυτη η extra μερα σε αυτη την συγκεκριμενη κρατηση του δωματιου.
     listAvailable[i]=res;
     res.setRoom(this);
     return true;    
 }
 public double income()//Αυτη η μεθοδος φροντιζει στο να μην υπολογιστει στο συνολικο κοστος το κοστος της δωρεαν ημερας
 {                    //συνολικα για ολες τις δωρεαν μερες των κρατησεων ενος δωματιου που μπορει να υπαρχουν.
     double sum=super.income();
     sum-=pricePerDay*freeDay;
     return sum;
 }
}