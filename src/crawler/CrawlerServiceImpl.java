package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import user.UserServiceImpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    public static CrawlerServiceImpl getInstance(){return instance;}
    private CrawlerServiceImpl(){
        repository = CrawlerRepository.getInstance();
    }
    private CrawlerRepository repository;




    @Override
    public Map<String, ?> findNamesFromWeb(Map<String, ?> paramMap) throws IOException {
        return repository.save(paramMap);
    }

}