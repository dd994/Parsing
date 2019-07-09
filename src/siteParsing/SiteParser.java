package siteParsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.HashMap;
import java.util.Map;

public class SiteParser {
    public static void main(String[] args) throws Exception {
        String site = "https://www.olx.ua/uk/dnepr/";
        Map<String, String> ads = new HashMap<>();
        //подключение к сайту методом get
        Document doc = Jsoup.connect(site).get();

        //анализ документа  - получаем все элементы h3 (заголовки)
        Elements h3Elements = doc.getElementsByAttributeValue("class", "lheight22 margintop5");


        //пройдемся по каждому элементу
        h3Elements.forEach(h3Element -> {
            Element aElement = h3Element.child(0);//получим элемент а (ссылка находится на 1ой позиции тега h3)
            String url = aElement.attr("href");//получаем значение ссылки, вырезаной из атрибута href
            String title = aElement.child(0).text(); //ананлогично получаем значение текста из аттрибута strong, который на нулевой позиции  у a
            ads.put(title,(" ")+ url + ("\n")); //добавляем элементы в в коллекцию
        });

        System.out.println(ads.size());
        System.out.println(ads);


    }
}
