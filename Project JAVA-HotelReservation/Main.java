import java.util.Random;    //εισαγωγη κλασεων που θα χρειαστουν.
import java.util.Scanner;  //εισαγωγη κλασεων που θα χρειαστουν.
public class Main              //Η Προσομοιωση που ζητηθηκε
{ 
    public static void main(String[] args)
    {
        Hotel hotel = new Hotel();  //Δημιουργια αντικειμενου τυπου Hotel
        Random  rand = new Random(); //Δημιουργια αντικειμενου τυπου Random οπου rand ισουτε με εναν τυχαιο αριθμο
        Room room0 = new Room(4,20); //δημιουργια αντικειμενου τυπου Room με συγκεκριμενα ορισματα
        Room room1 = new Room(2,10);  //        ,,       ,,           ,,           ,,               ,,
        Room room2 = new Room(4,50);  //        ,,       ,,           ,,           ,,               ,,
        Room room3 = new Room(6,60);  //        ,,       ,,           ,,           ,,               ,,
        Room room4 = new Room(4,100); //        ,,       ,,           ,,           ,,               ,,
        RoomTypeA room5 = new RoomTypeA(4,15); //δημιουργια αντικειμενου τυπου RoomTypeA με συγκεκριμενα ορισματα
        RoomTypeA room6 = new RoomTypeA(3,25); //        ,,       ,,           ,,           ,,               ,,
        RoomTypeB room7 = new RoomTypeB(4,50,10); //δημιουργια αντικειμενου τυπου RoomTypeB με συγκεκριμενα ορισματα
        RoomTypeC room8 = new RoomTypeC(6,3,5);  //δημιουργια αντικειμενου τυπου RoomTypeC με συγκεκριμενα ορισματα
        RoomTypeD room9 = new RoomTypeD(4,30);   //        ,,       ,,           ,,           ,,               ,,
        RoomTypeD room10 = new RoomTypeD(5,35); //δημιουργια αντικειμενου τυπου RoomTypeD με συγκεκριμενα ορισματα
        RoomTypeE room11 = new RoomTypeE(4,20);  //δημιουργια αντικειμενου τυπου RoomTypeE με συγκεκριμενα ορισματα
        hotel.getListRoom().add(room0); //Εδω δημιουργειται μια κρατηση και προστειθετε σε καποιο δωματιο
        hotel.getListRoom().add(room1); //Εδω δημιουργειται μια κρατηση και προστειθετε σε καποιο δωματιο
        hotel.getListRoom().add(room2); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room3); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room4); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room5); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room6); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room7); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room8); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room9); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room10); //        ,,       ,,           ,,           ,,               ,,
        hotel.getListRoom().add(room11); //        ,,       ,,           ,,           ,,               ,,
   int choise = 0;
    do{
      int arrival=rand.nextInt(29)+1;
      int days=rand.nextInt(30-arrival)+1;
      int people=rand.nextInt(5)+1;
      String []People={"George","Maria","Stan","Dimitra","Alex","Sofia","Pamela","Josh","John","Sarah"};
      int peopleRandom=rand.nextInt(9);  
      Reservation res0=new Reservation(People[peopleRandom],arrival,days,people);
      hotel.addReservation(res0);
      if(rand.nextInt(3)==0){ //25% τυχαια πιθανοτητα να προκυψει ακυρωση κρατησης (διαλεγεται τυχαια ενας αριθμος απο 0 εως 3 και με την βοηθεια της μεθοδου ακυρωσης κρατησης ακυρωνεται η κρατηση τυχαια
      int position = rand.nextInt(hotel.getListReservation().size() - 1);
      hotel.cancelReservation(hotel.getListReservation().get(position).getreservationCode());
      }                                                        
        System.out.println("Menu:");                            //Εδω με την βοηθεια τον εντολων εκτυπωσης δημιουργουμε ενα Menu απο το οποιο ο χρηστης διαλεγει πια επιλογη θελει
        System.out.println("0:Next Repetition");               //γραφοντας τον αριθμο της καθε επιλογης που αναγραφεται και ακολουθοντας προσεκτικα τις συμβουλες που ακολουθουν
        System.out.println("1:Add Reservation");
        System.out.println("2:Cancel Reservation(Write reservation code)");
        System.out.println("3:Show Reservations List");
        System.out.println("4:Show Rooms List");
        System.out.println("5:Show Reservations Plan");
        System.out.println("6:Show Sum Of Incomes");
        System.out.println("7:Shut Down");
        Scanner keyboard=new Scanner(System.in); //δημιουργια αντικειμενου keyboard τυπου Scanner για την εισαγωγη δεδομενων απο το πληκτρολογιο
        System.out.println("Choose choise 0 or 1 or 2 or 3 or 4 or 5 or 6 or 7");
        choise=keyboard.nextInt();//εδω με αυτη την εντολη εισαγεται απο το πληκτρολογιο το νουμερο που εγραψε ο χρηστης για να εκτελεστει η συγκεκριμενη ενεργεια που θελει
        switch(choise){ //με την βοηθεια της switch φτιαχνουμε ολες τις δυνατε επιλογες που θελουμε και αναλογα με το τι απαντησει ο χρηστης  χρησιμοποιειται το καθε αντισοιχο case.
        case 0: break; //Επομενη Επαναληψη
        
        case 1: //Προσθηκη κρατησης (ο χρηστης δινει προαιρετικα το συγκεκριμενο αριθμο δωματιου
        System.out.println("(Give with this specific order:NAME,ARRIVAL,DAYS STAYING,PEOPLE NUMBER)");
        String x1=keyboard.next();
        int x2=keyboard.nextInt();
        int x3=keyboard.nextInt();
        int x4=keyboard.nextInt();
        Reservation res1=new Reservation(x1,x2,x3,x4); //Δημιουργια αντικειμενου κρατησης με ορισματα που εισαγονται απο το πληκτρολογιο με συγκεκριμενη σειρα
        hotel.addReservation(res1);
        break;

        case 2:
        System.out.println("Write the reservation code"); //Ακυρωση κρατησης γραφοντας τον κωδικο της κρατησης
        int x5=keyboard.nextInt();
        hotel.cancelReservation(x5);
        break;
        
        case 3:                   //Εκτυπωση πινακα με ολες τις κρατησεις του ξενοδοχειου
        hotel.getListReservation();   
        String S = new String();
        S += ("Reservation's Code\t|Client's Name\t|Room's Code\t\n");
     for(int i = 0;i<= hotel.getListReservation().size() -1;i++)
      S += (hotel.getListReservation().get(i).getreservationCode()+"\t\t|"+hotel.getListReservation().get(i).getclientName()+"\t|"+hotel.getListReservation().get(i).getRoom().getroomCode()+"\t\n");
      System.out.println(S);
        break;
        
        case 4:            //Εκτυπωση πινακα με τα δωματια του ξενοδοχειου
        hotel.getListRoom();
        String S1 = new String();
        S = ("Room's Code"+"\t|Completeness"+"\t|Income\t\n");
     for(int j = 0;j<= hotel.getListRoom().size() -1;j++)
     S1+=(hotel.getListRoom().get(j).getroomCode()+"\t\t|"+(hotel.getListRoom().get(j).full())+"%\t\t|"+hotel.getListRoom().get(j).income()+"\t\n");
     System.out.println(S1);
        break;
        
        case 5:        //Προβολη πλανου κρατησεων με την βοηθεια της μεθοδου resPlan()
        hotel.resPlan();
        break;
        
        case 6:      //Προβολη εσόδων
        System.out.println("Write if you want a specific Room Code or if you do not want a specific Room Code write 0(zero).");
        int x6=keyboard.nextInt(); //Προβολη εσόδων συγκεκριμενου δωματιου με συγκεκριμενο κωδικο δωματιου που δινεται απο το πληκτρολογιο
        if (x6==0)
        System.out. println(hotel.incomeCalc());
        else System.out.println(hotel.incomeCalc(x6)); //Προβολη συνολικων εσόδων του ξενοδοχειου απο ολα τα δωματια
        break;
        
        case 7:break; //Τερματισμος προγραμματος
        default:break;
        }
    }while(choise != 7);
    
 }
}
