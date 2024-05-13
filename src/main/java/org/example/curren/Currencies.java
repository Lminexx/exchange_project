package org.example.curren;
import org.example.curren.Controller.Controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
public class Currencies {
    private Controller controller;
    public static Document getPage(){
        String url = "https://www.cbr.ru/currency_base/daily/";
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
    public String getWallet(){
        Document page = getPage();
        Double wallet = null;
        var rows = page.select("tr");
        for (Element row: rows){
            var columns = row.select("td");
            if(columns.size()>=2 && columns.get(1).text().equals(controller.getComboFirstWallet().getValue().split(" ")[0])){
                wallet = Double.parseDouble(columns.get(4).text().replace(",","."))/Integer.parseInt(columns.get(2).text());
            }
        }
        return String.valueOf(wallet);
    }
    public String getEdWallet(){
        Document page = getPage();
        int wallet = 0;
        var rows = page.select("tr");
        for (Element row: rows){
            var columns = row.select("td");
            if(columns.size()>=2 && columns.get(1).text().equals(controller.getComboFirstWallet().getValue().split(" ")[0])){
                wallet = Integer.parseInt(columns.get(2).text());
            }
        }
        return String.valueOf(wallet);
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
