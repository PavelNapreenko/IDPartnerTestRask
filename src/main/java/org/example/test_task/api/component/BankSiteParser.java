package org.example.test_task.api.component;

import org.example.test_task.model.RateClass;
import org.example.test_task.service.RatesService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Component
public class BankSiteParser {

    private final RatesService ratesService;

    public BankSiteParser(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Scheduled(fixedRate = 30 * 60 * 1_000)
    @Async
    public void uploadData() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            URL url = new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            InputStream stream = url.openStream();
            Document doc = docBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            Element docEl = (Element) doc.getElementsByTagName("Cube").item(0);
            Node childNode = docEl.getFirstChild();

            while (childNode.getNextSibling() != null) {
                childNode = childNode.getNextSibling();

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    Date rateDate = sdf.parse(childElement.getAttribute("time"));
                    Node subChildNode = childNode.getFirstChild();

                    while (subChildNode.getNextSibling() != null) {
                        subChildNode = subChildNode.getNextSibling();
                        if (subChildNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element subChildElement = (Element) subChildNode;
                            if (subChildElement.getAttribute("currency").matches("USD|JPY|RUB")) {
                                String rateName = subChildElement.getAttribute("currency");
                                String rateValue = subChildElement.getAttribute("rate");
                                RateClass r = new RateClass();
                                r.setDate(rateDate);
                                r.setName(rateName);
                                r.setValue(new BigDecimal(rateValue));
                                r.setTime(LocalTime.now());
                                ratesService.saveRate(r);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



