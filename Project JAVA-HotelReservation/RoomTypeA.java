public class RoomTypeA extends Room//η Κλαση αυτη κληρονομει την κλαση Room και υπερκαλυπτει την μεθοδο Τιμολογησης(income())
{
protected double pricePerDay;
public RoomTypeA( int maxCapacity, double pricePerDay)//Δημιουργος της κλασης RoomTypeA.
{
   super(maxCapacity, 0);
   this.pricePerDay=pricePerDay;
}   
public double income()//Αυτη η μεθοδος υπερκαλυπτει την μεθοδο Τιμολογησης της κλασης Room και υπολογιζει το συνολικο
{                    //κερδος με βαση το κοστος της καθε μερας του δωματιου της κρατησης αγνοωντας τον αριθμο των ατομων που διαμενουν.
int full=0;
    for (int i=0; i<30; i++)
    if(listAvailable[i]!=null)
    full++;
    return full*pricePerDay;
}
}