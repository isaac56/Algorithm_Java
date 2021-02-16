package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 매칭점수 {
    class Site{
        double basic;
        double linkScore;
        List<String> links;
        int linkNum;

        public Site(double basic, List<String> links){
            this.basic = basic;
            this.links = links;
            this.linkNum = links.size();
        }
    }
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();

        List<String> urls = new ArrayList<>();
        HashMap<String, Site> hm = new HashMap<>();
        for(int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
            String url = getURL(pages[i]);
            urls.add(url);
            hm.put(url,new Site(getBasicScore(pages[i],word),getLink(pages[i])));
        }
        for(String url : urls){
            Site site = hm.get(url);
            for(String link : site.links){
                Site linkSite = hm.get(link);
                if(linkSite != null)
                    linkSite.linkScore += site.basic / (double)site.linkNum;
            }
        }
        int answer = 0;
        double maxScore = 0;
        for(int i = 0; i < urls.size(); i++) {
            Site site = hm.get(urls.get(i));
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
        int searchStart = 0;
        while(true){
            int href = page.indexOf("<a href=",searchStart);
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
