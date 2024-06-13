package com.example.matchtracker.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.matchtracker.Entity.Match;
import com.example.matchtracker.Entity.News;
import com.example.matchtracker.Entity.Player;
import com.example.matchtracker.Entity.Unit;
import com.example.matchtracker.Fragment.MatchesFragment;
import com.example.matchtracker.Fragment.NavBarFragment;
import com.example.matchtracker.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton;

    private ArrayList<Match> matches = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<News> news = new ArrayList<>();
    private ArrayList<Unit> units = new ArrayList<>();
    private MatchesFragment matchList;
    private NavBarFragment navBar;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Match game1 = new Match("Alan", "Fred", "02.01.24 17:00 ", "02.01.24 19:00 ", "Alan", "Fairy Lake", "65");
        Match game2 = new Match("Sean", "Poul", "07.05.24 13:00 ", "07.05.24 14:00 ", "Sean", "Desert of Death", "12");
        Match game3 = new Match("Derek", "Mattew", "01.01.24 15:00 ", "01.01.24 17:00 ", "Mattew", "Borderlands", "123");
        matches.add(game1);
        matches.add(game2);
        matches.add(game3);

        Player ownersProfile = new Player(R.drawable.profile_image1,"Anth0s", "1000","12.06.24", "128", "1", "desert of death", "crossbow archer");
        Player player2 = new Player(R.drawable.profile_image2,"Alan", "678","12.06.24", "234", "123", "desert of death", "crossbow archer");
        Player player3 = new Player(R.drawable.profile_image3,"Sean", "1132","12.06.24", "645", "431", "desert of death", "crossbow archer");
        Player player4 = new Player(R.drawable.profile_image4,"Derek", "934","12.06.24", "723", "32", "desert of death", "crossbow archer");
        Player player5 = new Player(R.drawable.profile_image5,"Fred", "246","12.06.24", "687", "53", "desert of death", "crossbow archer");
        Player player6 = new Player(R.drawable.profile_image6,"Poul", "576","12.06.24", "23", "43", "desert of death", "crossbow archer");
        Player player7 = new Player(R.drawable.profile_image7,"Mattew", "1678","12.06.24", "567", "76", "desert of death", "crossbow archer");
        Player player8 = new Player(R.drawable.profile_image8,"Tom", "5474","12.06.24", "54", "465", "desert of death", "crossbow archer");
        Player player9 = new Player(R.drawable.profile_image9,"Bill", "1233","12.06.24", "3", "24", "desert of death", "crossbow archer");
        Player player10 = new Player(R.drawable.profile_image10,"Connor", "1456","12.06.24", "12", "765", "desert of death", "crossbow archer");
        players.add(ownersProfile);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);

        News news1 = new News("Update #1", "The King has announced a new tournament in honor of the upcoming holiday. All knights are invited " +
                "to participate and show their skills in battle. The winner will receive a valuable prize from the royal treasury.", "09.06.24", true);
        news1.setImageResId(R.drawable.news_image1);
        News news2 = new News("Update #2", "A group of mysterious strangers appeared in the city. They claim to be travelers from distant lands, but some people suspect" +
                " that they are spies sent by the enemy kingdom. The guards are on high alert and are trying to find out more about these strangers.","10.06.24", false);
        News news3 = new News("Update #3", "The royal court is preparing for a grand ball in honor of the anniversary of the king's reign. Guests from all over " +
                "the kingdom are expected to attend the event. The ball promises to be a magnificent celebration with music, dancing, and feasting.", "11.06.24", true);
        news3.setImageResId(R.drawable.news_image3);
        News news4 = new News("Update #4", "The kingdom is facing a threat from the neighboring barbarian tribes. They have united under the leadership " +
                "of a fierce warlord and are preparing to attack the border towns. The king is gathering an army to defend his lands and protect his subjects.", "12.06.24", false);
        news.add(news1);
        news.add(news2);
        news.add(news3);
        news.add(news4);

        Unit swordsman = new Unit("Swordsman", 5, 50, 8);
        Unit spearman = new Unit("Spearman", 3, 35, 4);
        Unit axeman = new Unit("Axeman", 9, 45, 3);
        Unit shortbowArcher = new Unit("Shortbow", 6, 30, 8);
        Unit longbowArcher = new Unit("Longbow", 3, 25, 4);
        Unit crossbowArcher = new Unit("Crossbow", 7, 40, 3);
        Unit knight = new Unit("Knight", 5, 30, 3);
        Unit cuirassier = new Unit("Cuirassier", 2, 50, 7);
        Unit horsebackArcher = new Unit("HorseArcher", 3, 25, 2);
        Unit onePunchMan = new Unit("OnePunchMan", 1000, 1000, 1000);

        units.add(swordsman);
        units.add(spearman);
        units.add(axeman);
        units.add(shortbowArcher);
        units.add(longbowArcher);
        units.add(crossbowArcher);
        units.add(knight);
        units.add(cuirassier);
        units.add(horsebackArcher);
        units.add(onePunchMan);


        matchList = new MatchesFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainActivityContent, matchList);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed(){
        int count = getFragmentManager().getBackStackEntryCount();
        if(count == 0){
            super.onBackPressed();
        }
        else{
            getFragmentManager().popBackStack();
        }
    }

    public ArrayList<Match> getMatches(){
        return matches;
    }

    public void addNewMatch(Match newMatch){
        matches.add(newMatch);
    }

    public Player getOwner(){
        return players.get(0);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public ArrayList<News> getNews(){
        return news;
    }

    public void addNews(News anotherNews){
        news.add(anotherNews);
    }

    public ArrayList<Unit> getUnits(){
        return units;
    }

    public void updatePageTitle(String newTitle){
        Bundle bundle = new Bundle();
        bundle.putString("newTitle", newTitle);
        navBar = new NavBarFragment();
        navBar.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navBar, navBar);
        fragmentTransaction.commit();
    }

}
