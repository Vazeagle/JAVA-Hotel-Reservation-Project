
public class RoomTypeB extends RoomTypeA //RoomTypeB κληρονομει την κλαση RoomTypeA και υπερκαλυπτει την μεθοδο τιμολογησης(income())
{
double discountPerDay;
public RoomTypeB(int maxCapacity,double pricePerDay,double discountPerDay)//Δημιουργος της κλασης RommTypeB
{     
   super(maxCapacity, 0);  
   this.discountPerDay=discountPerDay;
}   
public double income()//Αυτη η μεθοδος υπερκαλυπτει την μεθοδο τιμολογησης(income())της RoomTypeA αλλα για καθε επιπλεον μερα διαμονης
{                    // μιας κρατησης η τιμη της μερας μειωνεται διαδοχικα με ενα ποσο discountPerDay το οπιο καθοριζεται απο τον χρηστη
double sum = 0;
int currentCode = 0;
int k=0;
for (int i=0; i<30; i++)
    if(listAvailable[i]!=null){
    if(currentCode != listAvailable[i].getreservationCode()){currentCode = listAvailable[i].getreservationCode();k=0;}
    k++;
    if(pricePerDay-discountPerDay*k > pricePerDay/2){sum+=pricePerDay-discountPerDay*k;}else{sum+=pricePerDay/2;}
    }
    return sum;
     }
     public boolean cancel(int cancelCode) //Αυτη η μεθοδος υπερκαλυπτει την μεθοδο ακυρωσης της κλασης RoomTypeA
    {                                     //ομως δεν δεχεται ακυρωσεις απλα επιστρεφει false
     return false;
    }
    }


 