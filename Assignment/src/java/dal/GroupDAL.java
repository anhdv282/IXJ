/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import entities.Group;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author DucNM
 */
public class GroupDAL {
    private static final String GROUP = "group";
    private static final String ID = "id";
    private static final String NAME = "name";
    
    public List<Group> getAllGroup() {
        List<Group> groups = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/group.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(GROUP);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                Group group = new Group();
                group.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                group.setName(element.getElementsByTagName(NAME).item(0).getTextContent());
                groups.add(group);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
    
    public Group getGroupByID(int id) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/group.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(GROUP);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                if (Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()) == id) {
                    Group group = new Group();
                    group.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                    group.setName(element.getElementsByTagName(NAME).item(0).getTextContent());
                    return group;
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
