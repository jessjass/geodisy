package Crosswalking.XML;

import Crosswalking.Crosswalking;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Wrapper for the Document class so I can control it more easily
 */
public class XMLDocument {
    Document doc;
    XMLStackElement stack;

    public XMLDocument() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            docBuilder = docFactory.newDocumentBuilder();

            doc = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        stack = new XMLStackElement(this,"root");

    }

    public Document getDoc(){
        return doc;
    }

    public Element createGMDElement(String s){
        return doc.createElement(addGMD(s));
    }

    public Element createGCOElement(String s){
        return doc.createElement(addGCO(s));
    }

    public Element create_Element(String s){
        return doc.createElement(s);
    }

    // GMD is either a description or parent element w/o a value
    private String addGMD(String s){
        return "gmd:" + s;
    }

    // GCO indicates generally a value rather than a description
    private String addGCO(String s) {
        return "gco:" + s;
    }

    public XMLStackElement getRoot(){
        return stack;
    }

    public void addRoot(XMLStackElement e){
        stack = e;
    }
}
