
package gofish;
import java.util.*;
/**
 *
 * @author Ethan Isaacs
 */
public class GoFish {
static card[][] deck = new card[4][10];
static ArrayList <card> p1 = new ArrayList<>();
static int p1Points = 0;
static ArrayList <card> p2 = new ArrayList<>();
static int p2Points = 0;
static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int playerTurn = 1;
        for(int a = 0;a<4;a++){//create deck
            for(int b = 1;b<11;b++){
                switch(a){
                case (0):
                    deck[a][b-1]=new card("salmon",b);
                break;
                case(1):
                    deck[a][b-1]=new card("cod",b);
                break;
                case(2):
                    deck[a][b-1]=new card("swordfish",b);
                break;
                case(3):
                    deck[a][b-1]=new card("catfish",b);
                break;
                }
            }
        }//end deck
        
        for(int a = 0;a<7;a++){//give decks 
            p1.add(deal());
            System.out.println("Player one got the "+p1.get(p1.size()-1));
            p2.add(deal());
            System.out.println("Player two got the "+p2.get(p2.size()-1));
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(p2Points<37&&p1Points<3){
            
            switch(playerTurn){//main method
                case(1):
                    
                    if(p1.size()<=0){
                        for(int a = 7;a>0;a--){
                            p1.add(deal());
                        }
                        System.out.println("\nYou were out of cards so here is 7 more!");
                    }
                    System.out.println("Player one: "+p1Points+" points! Your current hand is ");///////////////////////////////////////////////////
                    p1=sorted(p1);
                    check4(1);
                    for(int a = 0; a<p1.size();a++){
                        System.out.println(p1.get(a));
                    }
                    ask(p1,p2,1);
                    check4(1);
                    playerTurn = 2;
                    System.out.println("Checkpoint! press any number continue to next player");
                                        int nothingness = scan.nextInt();
                    break;
                    
                case(2):
                    if(p2.size()<=0){
                        for(int a = 7;a>0;a--){
                            p2.add(deal());
                        }
                        System.out.println("\nYou were out of cards so here is 7 more!");
                    }
                    
                    System.out.println("Player 2: "+p2Points+" points! Your current hand is ");
                    p2=sorted(p2);
                    check4(2);
                    for(int a = 0; a<p2.size();a++){
                        System.out.println(p2.get(a));
                    }
                    ask(p2, p1,2);
                    check4(2);
                    playerTurn = 1;
                    System.out.println("Checkpoint! press any number continue to next player");
                                        nothingness = scan.nextInt();
                break;
            }
        }
        System.out.println("end loop VICTOR! TELL ETHAN PLS");
    }
    
    
    public static card deal(){
        int random = (int)(Math.random()*40);
        return(deck[random/10][random%10]);
    }
    
    public static ArrayList<card> clearCards(ArrayList<Integer> index, int player){
        ArrayList<card> result = new ArrayList<>();
        boolean removing = false;
        if(player == 1){
            for(int a = p1.size()-1;a<=0;a++){
                for(int b = p1.size()-1;b<=0;b++){
                    if(p1.get(a).getNum()==index.get(b))
                        removing = true;
                    p1.remove(a);
                }
                if(!removing)
                    result.add(p1.get(a));
                removing = false;
            }
            p1Points++;
            System.out.println("You got a point, player one!");
        }
        else{
            for(int a = p2.size()-1;a<=0;a++){
                for(int b = p2.size()-1;b<=0;b++){
                    if(p2.get(a).getNum()==index.get(b))
                        removing = true;
                    p2.remove(a);
                }
                if(!removing)
                    result.add(p2.get(a));
                removing = false;
            }
        }
        p2Points++;
        System.out.println("You got a point, player two!");
        
        return result;
    }
    
    public static void ask(ArrayList<card> asker, ArrayList<card> giver, int player){
        boolean gotone = true;
        int compensation = 0;
        int request = 0;
        do{
            System.out.println("It is your turn to ask. Please input a number between 1-10 to ask the other player");
            request = scan.nextInt();
        }
        while(request>10||request<1);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            gotone=false;
            if(giver.size()>0){
                for(int a = giver.size()-1;a>=0;a--){
                    if(giver.get(a).getNum()==request){
                        asker.add(giver.get(a));
                        giver.remove(a);
                        compensation++;
                        System.out.println("you got a card!");
                        gotone = true;
                        if(giver.size()<7)
                        giver.add(deal());
                    }
                }   
                if(!gotone){
                    System.out.println("\n\n\n\n\nyou didn't get a card, Go fish");
                    asker.add(deal());
                    
                }
            }
            
    }
    
    public static void check4(int player){
        ArrayList <Integer> ones =new ArrayList<>();
        ArrayList <Integer> twos =new ArrayList<>();
        ArrayList <Integer> threes =new ArrayList<>();
        ArrayList <Integer> fours =new ArrayList<>();
        ArrayList <Integer> fives =new ArrayList<>();
        ArrayList <Integer> sixes =new ArrayList<>();
        ArrayList <Integer> sevens =new ArrayList<>();
        ArrayList <Integer> eights =new ArrayList<>();
        ArrayList <Integer> nines =new ArrayList<>();
        ArrayList <Integer> tens =new ArrayList<>();
        if(player == 1){
        for(int a = 0;a<=p1.size()-1;a++){
                switch(p1.get(a).getNum()){
                    case(1):
                        ones.add(a);
                        if(ones.size()>=4){
                            p1=clearCards(ones, 1);
                            ones.clear();
                        }
                        break;
                    case(2):
                        twos.add(a);
                        if(twos.size()>=4){
                            p1=clearCards(twos,1);
                            twos.clear();
                        }
                        break;
                    case(3):
                        threes.add(a);
                        if(threes.size()>=4){
                            p1=clearCards(threes,1);
                            threes.clear();
                        }
                        break;
                    case(4):
                        fours.add(a);
                        if(fours.size()>=4){
                            p1=clearCards(fours,1);
                            fours.clear();
                        }
                        break;
                    case(5):
                        fives.add(a);
                        if(fives.size()>=4){
                            p1=clearCards(fives,1);
                            fives.clear();
                        }
                        break;
                    case(6):
                       sixes.add(a);
                        if(sixes.size()>=4){
                            p1=clearCards(sixes,1);
                            sixes.clear();
                        }
                        break;
                    case(7):
                        sevens.add((Integer)a);
                        if(sevens.size()>=4){
                            p1=clearCards(sevens,1);
                            sevens.clear();
                        }
                        break;
                    case(8):
                       eights.add(a);
                        if(eights.size()>=4){
                            p1=clearCards(eights,1);
                            eights.clear();
                        }
                        break;
                    case(9):
                        nines.add(a);
                        if(nines.size()>=4){
                            p1=clearCards(nines,1);
                            nines.clear();
                        }
                        break;
                    case(10):
                        tens.add(a);
                        if(tens.size()>=4){
                            p1=clearCards(tens,1);
                            tens.clear();
                        }
                        break;
                }
            }
        }
        else{
            
            for(int a = 0;a<=p2.size()-1;a++){
                switch(p2.get(a).getNum()){
                    case(1):
                        ones.add(a);
                        if(ones.size()>=4){
                            p2=clearCards(ones, 2);
                            ones.clear();
                        }
                        break;
                    case(2):
                        twos.add(a);
                        if(twos.size()>=4){
                            p2=clearCards(twos,2);
                            twos.clear();
                        }
                        break;
                    case(3):
                        threes.add(a);
                        if(threes.size()>=4){
                            p2=clearCards(threes,2);
                            threes.clear();
                        }
                        break;
                    case(4):
                        fours.add(a);
                        if(fours.size()>=4){
                            p2=clearCards(fours,2);
                            fours.clear();
                        }
                        break;
                    case(5):
                        fives.add(a);
                        if(fives.size()>=4){
                            p2=clearCards(fives,2);
                            fives.clear();
                        }
                        break;
                    case(6):
                       sixes.add(a);
                        if(sixes.size()>=4){
                            p2=clearCards(sixes,2);
                            sixes.clear();
                        }
                        break;
                    case(7):
                        sevens.add(a);
                        if(sevens.size()>=4){
                            p2=clearCards(sevens,2);
                            sevens.clear();
                        }
                        break;
                    case(8):
                       eights.add(a);
                        if(eights.size()>=4){
                            p2=clearCards(eights,2);
                            eights.clear();
                        }
                        break;
                    case(9):
                        nines.add(a);
                        if(nines.size()>=4){
                            p2=clearCards(nines,2);
                            nines.clear();
                        }
                        break;
                    case(10):
                        tens.add(a);
                        if(tens.size()>=4){
                            p2=clearCards(tens,2);
                            tens.clear();
                        }
                        break;
                }
            }
        }
    }
    
    public static ArrayList<card> sorted(ArrayList<card> player){
        for(int a = 0;a<player.size()+10;a++){
            for(int b = 0;b<player.size()-1;b++)
            if(player.get(b).getNum()>player.get(b+1).getNum()){
                card temp = player.get(b+1);
                player.set(b+1, player.get(b));
                player.set(b,temp);
            }
        }
        return player;
    }
    
}
