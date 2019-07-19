package Crosswalking.XML;

import org.w3c.dom.Element;

public abstract class XMLElement  {
XMLDocument doc;
Element e;

    public abstract void addNode(Element e);
    public abstract void addGMDNode(String s);
    public abstract void addGCONode(String s);
    protected abstract void getChildren();

    public Element getElement(){
        getChildren();
        return e;
    }


    //Adds the element at the lowest level of the hierarchy that holds the value
    public void addVal(String altTitleVal, String label) {
        Element val = doc.createGCOElement(label);
        val.setNodeValue(altTitleVal);
        e.appendChild(val);
    }
}
