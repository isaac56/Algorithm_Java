package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class 매칭점수 {
    class Site{
        double basic;
        double linkScore;
        List<String> linkes;
        int linkNum;

        public Site(double basic, List<String> linkes){
            this.basic = basic;
            this.linkes = linkes;
            this.linkNum = linkes.size();
        }
    }
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();

        HashMap<String, Site> hm = new HashMap<>();
        for(int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
            hm.put(getURL(pages[i]),new Site(getBasicScore(pages[i],word),getLink(pages[i])));
        }
        for(int i = 0; i < pages.length; i++) {
            Site site = hm.get(getURL(pages[i]));
            for(String link : site.linkes){
                Site linkSite = hm.get(link);
                if(linkSite != null)
                    linkSite.linkScore += site.basic / (double)site.linkNum;
            }
        }

        int answer = 0;
        double maxScore = 0;
        for(int i = 0; i < pages.length; i++) {
            Site site = hm.get(getURL(pages[i]));
            // System.out.println(i +"번째: 기본="+site.basic +", 링크점수=" + site.linkScore);
            if(maxScore < site.basic + site.linkScore){
                maxScore = site.basic + site.linkScore;
                answer = i;
            }
        }

        return answer;
    }

    String getURL(String page){
        int head = page.indexOf("<head>");
        String toFind = "<meta property=\"og:url\" content=\"";
        int start = page.indexOf(toFind, head) + toFind.length();
        int end = page.indexOf('"',start);

        return page.substring(start, end);
    }

    List<String> getLink(String page){
        List<String> ret = new ArrayList<>();
        String search = "<a href=";
        int searchStart = 0;
        while(true){
            int href = page.indexOf(search,searchStart);
            if(href == -1)
                break;

            int start = page.indexOf('"',href) + 1;
            int end = page.indexOf('"',start);
            ret.add(page.substring(start,end));

            searchStart = end;
        }
        return ret;
    }

    double getBasicScore(String page, String search){
        double score = 0;
        String[] words = page.split("[^a-z]");
        for(String word : words){
            if(word.equals(search))
                score++;
        }
        return score;
    }
}
