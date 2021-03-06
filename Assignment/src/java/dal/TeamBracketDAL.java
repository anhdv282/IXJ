/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import entities.TeamBracket;
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
public class TeamBracketDAL {
    private static final String ID = "id";
    private static final String LABEL = "label";
    private static final String TEAMID = "team_id";
    private static final String BRACKET = "bracket";
    
    public List<TeamBracket> getAllTeamBracket(){
        List<TeamBracket> lst = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/team_bracket.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(BRACKET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                TeamBracket teamBracket = new TeamBracket();
                teamBracket.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                teamBracket.setLabel(element.getElementsByTagName(LABEL).item(0).getTextContent());
                teamBracket.setTeam(Integer.parseInt(element.getElementsByTagName(TEAMID).item(0).getTextContent()));
                lst.add(teamBracket);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    public TeamBracket getTeamBracketByID(int id){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/team_bracket.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(BRACKET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                TeamBracket teamBracket = new TeamBracket();
                if(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()) == id){
                    teamBracket.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                    teamBracket.setLabel(element.getElementsByTagName(LABEL).item(0).getTextContent());
                    teamBracket.setTeam(Integer.parseInt(element.getElementsByTagName(TEAMID).item(0).getTextContent()));
                    return teamBracket;
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeamBracketDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
