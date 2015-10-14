package com.artcode.training.week3.downloader;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.net.URL;

public class EXUADownloader {
    public void parseURL(String url) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        XPath path = XPathFactory.newInstance().newXPath();
        XPathExpression compile = path.compile("//a[text()='load']");
        URL urlObject = new URL(url);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlObject.openConnection().getInputStream());
        NodeList list = (NodeList) compile.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.item(i).getAttributes().getNamedItem("href"));
        }
    }

    public static void main(String[] args) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        new EXUADownloader().parseURL("http://www.ex.ua/93390339?r=82380,80926");
    }
}
