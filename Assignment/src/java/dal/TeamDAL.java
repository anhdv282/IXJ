/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import entities.Team;
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
 * @author DANG
 */
public class TeamDAL {
    private static final String GROUP = "team";
    private static final String CODE = "code";
    private static final String GROUPID = "group_id";
    private static final String ID = "id";
    private static final String NAME = "name";
    public List<Team> teamData(){
        List<Team> lst = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/team.xml");
        DocumentBuilder builder;
        try {
            builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(GROUP);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                Team team = new Team();
                team.setID(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                team.setCode(element.getElementsByTagName(CODE).item(0).getTextContent());
                team.setGroupID(Integer.parseInt(element.getElementsByTagName(GROUPID).item(0).getTextContent()));
                team.setName(element.getElementsByTagName(NAME).item(0).getTextContent());
                lst.add(team);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TeamDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TeamDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeamDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
}
