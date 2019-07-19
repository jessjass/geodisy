package Crosswalking.XML;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Stack;

public class XMLLinkListElement extends XMLElement{
    Element e;
    Stack<XMLStackElement> stack;
    XMLDocument doc;

    public XMLLinkListElement(XMLDocument doc, Element e) {
        this.e = e;
        this.doc = doc;
        stack = new Stack<>();
    }

    public XMLLinkListElement(XMLDocument doc, String name) {
        this.doc = doc;
        e = doc.create_Element(name);
        stack = new Stack<>();
    }

    public void addNode(Element e) {
        stack.push(new XMLStackElement(doc, e));
    }

    public void addGMDNode(String s) {
        stack.push(new XMLStackElement(doc, doc.createGMDElement(s)));
    }

    public void addGCONode(String s){
        stack.push(new XMLStackElement(doc, doc.createGCOElement(s)));
    }

    public Element getElement() {
        getChildren();
        return e;
    }

    protected void getChildren() {
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                e.appendChild(stack.pop().getElement());
            }
        }
    }


}
