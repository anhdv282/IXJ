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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author DANG
 */
public class GroupDAL {
    public List<Group> getGroup(){
        List<Group> lst = new ArrayList<>();
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            String path = "src\\xml\\group.xml";
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName("group");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                Group group = new Group();
                group.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                group.setName(element.getElementsByTagName("name").item(0).getTextContent());
                lst.add(group);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
}
