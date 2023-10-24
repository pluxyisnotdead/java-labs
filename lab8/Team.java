package lab8;
import java.util.ArrayList;
import java.util.Collections;

public class Team{
    private String country;
    private String name;
    private ArrayList<Player> players;

    public Team(String country, String name, ArrayList<Player> players){
        setCountry(country);
        setName(name);
        setPlayers(players);
    }

    public void sortByNum(){
        Collections.sort(players);

//        for (int i = 0; i < players.size() - 1; i++){
//            for (int j = i + 1; j < players.size(); j++){
//                if (players.get(i).getNumber() > players.get(j).getNumber()){
//                    Player temp = players.get(i);
//                    players.set(i, players.get(j));
//                    players.set(j, temp);
//                }
//            }
//        }
    }

    public double averageAge(){
        int allAges = 0;

        for(var player : players){
            allAges += player.getAge();
        }

        return (double) (allAges / players.size());
    }

    public String getName() {
        return name;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public String getCountry() {
        return country;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
