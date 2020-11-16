
import java.util.ArrayList;//εισαγωγη απο την βιβλιοθηκη τις java κλασης που θα χρειαστουμε για την δημιουργια πινακων.
public class Hotel
{
    String hotelName;
ArrayList<Room> listRoom =new ArrayList<Room>();                        //Δημιουργια πινακα ,με αντικειμενα της κλασης Room
ArrayList<Reservation> listReservation = new ArrayList<Reservation>(); //Δημιουργια πινακα ,με αντικειμενα της κλασης Reservation
public void addRoom(Room room) //Αυτη η μεθοδος παιρνει ως όρισμα ενα αντικειμενο Room και το προσθετει στον πινακα δωματιων(listRoom)
{
listRoom.add(room);
}
public Reservation recoveryReservationCode(int resCode)//Αυτη η μεθοδος παιρνει ως όρισμα τον κωδικο της κρατησης(reservationCode) και επιστρεφει το αντικειμενο 
{                                                     //τυπου Reservation απο τον πινακα κρατησεων(listReservation) που αντισοιχει στον κωδικο αυτο αν δεν υπαρει reservation στη λιστα κρατησεων με αυτο τον κωδικο επιστρεφει null
for(int i = 0; i<listReservation.size(); i++)
if(listReservation.get(i).getreservationCode()==resCode){return listReservation.get(i); } 
return null;
}
public Room recoveryRoomCode(int roomCode)//Αυτη η μεθοδος παιρνει ως όρισμα τον κωδικο τον κωδικο του δωματιου(roomCode) και επιστρεφει το αντικειμενο 
{                                       //τυπου Room απο τον πινακα δωματιων(listRoom) που αντισοιχει στον κωδικο αυτο αν δεν υπαρχει room στη λιστα δωματιων με αυτο τον κωδικο επιστρεφει null
for(int i = 0; i<listRoom.size(); i++)
if(listRoom.get(i).getroomCode()==roomCode){return listRoom.get(i); } 
return null;
}
public boolean addRoomReservation(Reservation res,int roomCode)//Αυτη η μεθοδος παιρνει ορισμα ενα αντικειμενο Reservation π.χ.(res) και τον κωδικο δωματιου π.χ. (roomCode) 
{                                                             //και επιστρεφει μια τιμη boolean(true ή false)  που δειχνει αν εγινε η κρατηση με επιτυχια ή οχι    
    boolean done = recoveryRoomCode(roomCode).getReservation(res); //η μεταβλητη done που ειναι boolean,εδω καλουμε και αλλες μεθοδους να εκτελεστουν με αντικειμενα roomCode και res αντιστοιχα για να εκχωρηθει στο τελος στην done true ή false αναλογα με το αποτελεσμα των πραξεων. 
    if(done){listReservation.add(res);System.out.print("Reservation was registered with success  ");return true;} //εκτυπωση Reservation was registered with success και επιστροφη true αν η προσθηκη εγινε με επιτυχια
    System.out.print("Reservation was failed to register");return false;  //εκτυπωση Reservation was failed to register και επιστροφη false αν η προσθηκη απετυχε
}
public int addReservation(Reservation res) //Αυτη η μεθοδος παιρνει ορισμα ενα αντικειμενο Reservation π.χ.(res) και το προσθετει σε οποιοδηποτε δωματιο μπορει με την βοηθεια της προηγουμενης μεθόδου.
{
for(int i = 0; i<listRoom.size(); i++){ //Εδω διαβαζεται το μεγεθος της λιστα δωματιων(δηλαδη ποσα δωματια υπαρχουν)
if(addRoomReservation(res,listRoom.get(i).getroomCode()))
{
    System.out.println("in Room "+listRoom.get(i).getroomCode());//εκτυπωση αν η κρατηση εγινε με επιτυχια ή οχι και σε πιο δωματιο
    return listRoom.get(i).getroomCode();
}
}
return 0;
}
public void cancelReservation(int resCode )//Αυτη η μεθοδος παιρνει ορισμα τον κωδικο μιας κρατησης και ακυρωνει την κρατηση με την βοηθεια των εξης μεθοδωνrecoveryReservationCode() και την cancel() της κλασης Room
{
    boolean done = recoveryReservationCode(resCode).getRoom().cancel(resCode);
    if(done){listReservation.remove(recoveryReservationCode(resCode));System.out.println("Cancelation was made with success");return ;}//αν η ακυρωση εγινε με επιτυχια εκτυπωνει Cancelation was made with success
    System.out.println("Cancelation has failed");return;//αν η ακυρωση απετυχε εκτυπωνει Cancelation has failed
}
public double incomeCalc(int roomCode)//Αυτη η μεθοδος υπολογιζει και επιστρεφει τα συνολικα εσοδα ενως δωματιου βαζοντας τον κωδικο του δωματιου.
{
return recoveryRoomCode(roomCode).income();
}
public double incomeCalc()//Αυτη η μεθοδος υπολογιζει και επιστρεφει τα συνολικα εσοδα  ολων των δωματιων,διαβαζοντας ολα τα δωματια της λιστας δωματιων.
{double sum = 0;
for(int i = 0; i<listRoom.size(); i++)
sum+=listRoom.get(i).income();
return sum;
}
public void resPlan()   //Αυτη η μεθοδος διαβαζει δωματια της λιστας δωματιων και εκτυπωνει για το καθε ενα τον πινακα διαθεσιμοτητας του 
{                      //τις ημερες που ειναι αδειο εχει - ενω οταν ειναι γεματο * .
    System.out.print("Δωματιο");
            for(int i = 0;i<29;i++){
            System.out.print((i+1<10)?("\t0"+(i+1)):("\t"+(i+1)));
        }                               
        System.out.print("\t30");
         for(int i = 0;i <= this.listRoom.size() - 1;i++){
        System.out.println();
        System.out.print(this.listRoom.get(i).getroomCode());
        for(int j = 0;j<30;j++)
        System.out.print("\t"+((this.listRoom.get(i).check(j) == true)?"*":"_"));
        }
        System.out.println();

}
public ArrayList<Room> getListRoom(){return listRoom;}
public ArrayList<Reservation> getListReservation(){return listReservation;}
}

