/*Αυτη η κλαση υπολογιζει το συνολικο κοστος ανα μερα διαμονηςαγνοωντας ποσα ατομα εχει η κρατηση
  και αν το κοστος ειναι μεγαλυτερο απο 500 τοτε γινεται εκπτωση 10% */
public class RoomTypeD extends Room //Ακομα αυτη η κλαση κληρονομει την κλαση Room.
{
    private double pricePerDay;
    public RoomTypeD( int maxCapacity, double pricePerDay)//Δημιουργος της κλασης RoomTypeD
    {
        super(maxCapacity,0);
        this.pricePerDay=pricePerDay;
    }
    public double income()//Αυτη η μεθοδος υπερκαλυπτει την μεθοδο τιμολογησης(income())της Room και υπολογιζει το συνολικο κοστος μιας κρατησης
    {                    // ενώς δωματιου και αν αυτο το κοστος ειναι μεγαλυτερο του 500euro κανει μια εκπτωση 10% και επιστρεφει το κοστος.
    double fullCost = super.income();
    if(fullCost>=500)
    fullCost=fullCost-((fullCost*10)/10);
    return fullCost;
}
}
