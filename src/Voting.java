import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
public class Voting {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    Random rand = new Random();
    private int type = 0;
    private String question;
    private final ArrayList<Person> voters = new ArrayList<>();
    private final HashMap<String, HashSet<Vote>> choices = new HashMap<>();
    boolean isAnonymous = true;

    public Voting(int type, String question, boolean isAnonymous, ArrayList<String> choices) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        for(String j : choices){
            HashSet<Vote> v = new HashSet<Vote>();
            this.choices.put(j,v);
        }
    }

    public ArrayList<String> getChoices() {
        ArrayList<String> gt = new ArrayList<String>();
        for (String qu : this.choices.keySet()) {
            gt.add(qu);
        }
        return gt;
    }

    public void createChoices(String choice) {
        choices.put(choice, new HashSet<>());
    }

    public void vote(Person voter) {
        int i = this.choices.size();
        int random = rand.nextInt(i);
        ArrayList<String> choices = getChoices();
        voters.add(voter);
        this.choices.get(choices.get(random)).add(new Vote(voter, dtf.format(now)));

    }

    public void printResults() {
        System.out.println("Vote result :\n");
        for (String i : choices.keySet()) {
            System.out.println(i + " > " + choices.get(i).size());
        }
    }
    public void printVoters(){
        for(String i : choices.keySet()){
            for(Vote v : choices.get(i)){
                System.out.println(i + " : " + "[ " +v.getVoter().getFirstName() + "." + v.getVoter().getLastName() + "/" + v.getDate());
            }

        }

    }
    public ArrayList<Person> getVoters(){
        return this.voters;
    }

    public HashMap<String, HashSet<Vote>> getChoicesAndVoters(){
        return this.choices;
    }
    public boolean getIsAnonymous(){
        return this.isAnonymous;
    }
    public int getType(){
        return this.type;
    }
    public String getQuestion(){
        return this.question;
    }
}