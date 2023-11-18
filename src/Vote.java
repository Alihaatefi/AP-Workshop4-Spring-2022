import java.util.Objects;

public class Vote {
    private final Person voter;
    private final String date;

    public Vote(Person voter, String date){
        public Person getVoter();
        public String getDate();
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voter, vote.voter) && Objects.equals(date, vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
}
