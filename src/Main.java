import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem voSys = new VotingSystem();
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<String> choices2 = new ArrayList<String>();
        choices2.add("Java");
        choices2.add("Python");
        choices2.add("JavaScript");
        choices2.add("C/C++");
        choices2.add("Golang");
        choices2.add("None");
        choices.add("Me");
        choices.add("You");
        choices.add("him");
        voSys.createVoting("Who is the best person on the Earth?", true, 0, choices );
        voSys.printResults(0);

        voSys.vote(0, new Person("Tom", "Hardy"));
        voSys.vote(0, new Person("Mohsen", "Yeganeh"));
        voSys.vote(0, new Person("John", "Wick"));
        voSys.printResults(0);
        voSys.printVoters(0);
        voSys.createVoting("What is the best language among these?", false, 0, choices2);
        voSys.vote(1, new Person("Tom", "hardy"));
        voSys.vote(1, new Person("Mohsen", "Yeganeh"));
        voSys.vote(1, new Person("john", "Wick"));
        voSys.vote(1, new Person("Ethan", "Young"));
        voSys.vote(1, new Person("Donald", "mc.ly"));
        voSys.vote(1, new Person("Sam", "Smith"));
        voSys.printResults(1);
        voSys.printVoters(1);
        voSys.printVoting(1);
        voSys.printResults(1);
    }
}