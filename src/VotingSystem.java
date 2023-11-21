import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    Random rand = new Random();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime nowTime = LocalDateTime.now();

    public VotingSystem(){

    }
    public  void createVoting(String question,boolean isAnonymous,int type,ArrayList<String> choices){
        Voting v = new Voting(type, question, isAnonymous, choices);
        votingList.add(v);
    }
    public Voting getVoting(int index){
        return votingList.get(index);
    }
    public ArrayList<Voting> getVotingList(){

        return this.votingList;
    }

    public void printResults(int index){
        HashMap<String, HashSet<Vote>> content = votingList.get(index).getChoicesAndVoters();
        System.out.println("Result of the survey : ");
        for(String choice : content.keySet()){
            System.out.println(choice + " > " + content.get(choice).size());
        }
        System.out.println("--------------------------------------------------------");
    }
    public void printVoters(int index){
        ArrayList<Person> voters = votingList.get(index).getVoters();
        System.out.println("Voters : ");
        int i = 1;
        for(Person p : voters){
            System.out.println( i + " - " + p.toString());
            i++;
        }
        System.out.println("--------------------------------------------------------");
        /*while(it.hasNext()){
            System.out.println(it.next().getName() + " " + it.next().getLastName());
        }*/

    }
    public void printVoting(int index){
        ArrayList<String> choices = votingList.get(index).getChoices();
        System.out.println(votingList.get(index).getQuestion() + " : ");
        int j = 1;
        for(String choice : choices){
            System.out.println(j + " - " + choice);
            j++;
        }
        System.out.println("--------------------------------------------------------");


    }
    /*   int index = rand.nextInt(votingList.getLast().getChoices().size());*/
    public void vote(int index, Person voter){
        int size = votingList.get(index).getChoices().size();
        int random = rand.nextInt(size);

        Vote v = new Vote(voter, dtf.format(nowTime));
        String x = votingList.get(index).getChoices().get(random);
        votingList.get(index).getChoicesAndVoters().get(x).add(new Vote(voter, dtf.format(nowTime)));
        votingList.get(index).getVoters().add(voter);
    }
}

