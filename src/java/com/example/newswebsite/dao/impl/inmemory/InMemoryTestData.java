package com.example.newswebsite.dao.impl.inmemory;

import com.example.newswebsite.model.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {

        database.news.clear();
        database.categories.clear();
        database.users.clear();

        User larry = new User(1, "Larry", "larry@example.com", "larryppp");
        User shen = new User(2, "Shen", "shen@example.com", "shenppp");
        User earnestine = new User(3, "Earnestine", "earnestine@example.com", "earnestineppp");
        User lilian = new User(4, "Lilian", "lilian@example.com", "lilianppp");
        User levi = new User(5, "Levi", "levi@example.com", "levippp");
        List<User> users = Arrays.asList(larry, shen, earnestine, lilian, levi);
        users.forEach(user -> database.users.put(user.getUserId(), user));

        Category politics = new Category(1, "politics");
        Category health = new Category(2, "health");
        Category tech = new Category(3, "tech");
        Category sport = new Category(4, "sport");
        Category culture = new Category(5, "culture");
        List<Category> categories = Arrays.asList(politics, health, tech, sport, culture);
        categories.forEach(category -> database.categories.put(category.getCategoryId(), category));

        News southKorea = new News(1, "New Scandal Engulfs South Korean Leader in Wake of Marine’s Death", "President Yoon Suk Yeol has been accused of intervening in a probe into an accidental death during a peacetime search and rescue operation.", politics, LocalDateTime.of(2024, 6, 4, 10, 30));
        News friendships = new News(2, "Why in-person friendships are better for health than virtual pals", "A recent study analyzed data from nearly 13,000 volunteers, examining not only their number of friends, but also whether they saw each other. Having face-to-face contact with friends at least once per week was a strong predictor of better physical and mental health. Calling or texting didn’t bring similar benefits, says Eric Kim, professor of psychology at the University of British Columbia and the study’s lead author.", health, LocalDateTime.of(2024, 6, 5, 3, 15));
        News period = new News(3, "Girls’ periods are starting sooner, more irregular than past generations", "A new study of 71,341 women supports the growing concern that the age at which girls start menstruating is getting younger, and the trends are even more pronounced for some racial and ethnic groups. The findings also suggest that many girls and young women are experiencing irregular cycles for years, a risk factor for a variety of health concerns, including cardiovascular disease, metabolic diseases such as diabetes, and certain types of cancers.", health, LocalDateTime.of(2024, 6, 4, 16, 16));
        News tesla = new News(4, "Tesla settles another defect case, avoiding jury for second time this year", "SAN FRANCISCO — Tesla settled another case linking a passenger’s death with an alleged vehicle design defect, records show, the second time in less than two months that the automaker has avoided a jury trial just days before it was set to begin.", tech, LocalDateTime.of(2024, 6, 1, 5, 39));
        News golf = new News(5, "Nelly Korda tweaked her golf swing. ‘Crazy history’ has followed.", "Korda had been over-rotating her hands during her takeaway, a breakdown that made getting the club face square at impact more challenging than necessary. She tweaked the motion after she began working with swing coach Jamie Mulligan, who also has provided instruction to Patrick Cantlay, the eighth-ranked men’s golfer in the world.", sport, LocalDateTime.of(2024, 6, 9, 12, 37));
        News olympics = new News(6, "Gymnast Gabby Douglas ends attempt to qualify for Paris Olympics", "Three-time Olympic champion Gabby Douglas withdrew from this week’s national championships, ending her attempt to make the U.S. Olympic team for this summer’s Paris Games. USA Gymnastics confirmed Douglas’s withdrawal, and Douglas told ESPN she suffered an ankle injury in training this week that prevented her from participating.", sport, LocalDateTime.of(2024, 6, 1, 15, 46));
        News caravaggio = new News(7, "The Martyrdom of Saint Ursula: How Caravaggio's violent 17th Century paintings led to Goodfellas and Mean Streets", "As the record crowds flocking to see his last painting show, Caravaggio's violent life and the cinematic intensity of his work have proved to be irresistible for centuries", culture, LocalDateTime.of(2024, 6, 2, 9, 56));
        News hongKong = new News(8, "Hong Kong convicts 14 pro-democracy activists of subversion in landmark case", "The activists were found guilty of “conspiracy to subvert state power” in the largest national security case in the Chinese territory.", politics, LocalDateTime.of(2024, 6, 13, 6, 34));
        News johnLennon = new News(9, "Lost John Lennon guitar sets record at auction", "A guitar used by John Lennon has become the most expensive Beatles instrument ever sold at auction.The Framus 12-string Hootenanny acoustic guitar was found in an attic after being presumed lost for more than 50 years, auctioneers said.It sold for $2.9m (£2.3m) via a telephone bid at the Hard Rock Cafe in New York.", culture, LocalDateTime.of(2024, 6, 2, 16, 35));
        News openAI = new News(10, "OpenAI’s news deals continue, with Vox and the Atlantic signing on", "OpenAI announced deals with Vox Media and the Atlantic on Wednesday, adding to the growing number of news organizations taking money from the artificial-intelligence company in exchange for sharing their content.", tech, LocalDateTime.of(2024, 6, 3, 11, 13));
        News court = new News(11, "The biggest 2024 Supreme Court rulings so far, and what’s still to come", "In a Supreme Court term that coincides with the 2024 presidential primary season, the justices are at the center of many of the nation’s most politically sensitive debates. At the top of the list: former president Donald Trump’s eligibility to return to the White House and a challenge to a key element of the criminal charges against him related to his efforts to overturn Joe Biden’s 2020 election victory.", politics, LocalDateTime.of(2024, 6, 3, 18, 33));
        List<News> newsList = Arrays.asList(southKorea, friendships, period, tesla, golf, olympics, caravaggio, hongKong, johnLennon, openAI, court);
        newsList.forEach(news -> database.news.put(news.getNewsId(), news));

    }
}
