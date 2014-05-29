/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import entities.Match;
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
public class MatchDAL {
    private static final String MATCH = "match";
    private static final String ID = "id";
    private static final String KICKOFF = "kickoff";
    private static final String STAGE = "stage";
    private static final String TEAM1ID = "team1_id";
    private static final String TEAM2ID = "team2_id";
    private static final String VENUEID = "venue_id";
    
    public List<Match> getAllMatch(){
        List<Match> lst = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/match.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(MATCH);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                Match match = new Match();
                match.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                match.setKickoff(element.getElementsByTagName(KICKOFF).item(0).getTextContent());
                match.setStage(Integer.parseInt(element.getElementsByTagName(STAGE).item(0).getTextContent()));
                match.setVenue(new VenueDAL().getVenueByID(Integer.parseInt(element.getElementsByTagName(VENUEID).item(0).getTextContent())));
                    match.setHome(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM1ID).item(0).getTextContent())));
                    match.setAway(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM2ID).item(0).getTextContent())));
                lst.add(match);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    public Match getMatchByID(int id){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/match.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(MATCH);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                Match match = new Match();
                if (Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()) == id) {
                    match.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                    match.setKickoff(element.getElementsByTagName(KICKOFF).item(0).getTextContent());
                    match.setStage(Integer.parseInt(element.getElementsByTagName(STAGE).item(0).getTextContent()));
                    match.setVenue(new VenueDAL().getVenueByID(Integer.parseInt(element.getElementsByTagName(VENUEID).item(0).getTextContent())));
                    match.setHome(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM1ID).item(0).getTextContent())));
                    match.setAway(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM2ID).item(0).getTextContent())));
                    return match;
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Match> getMatchByTeam(int team){
        List<Match> lst = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/match.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(MATCH);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                if (Integer.parseInt(element.getElementsByTagName(TEAM1ID).item(0).getTextContent()) == team || Integer.parseInt(element.getElementsByTagName(TEAM2ID).item(0).getTextContent()) == team) {
                    Match match = new Match();
                    match.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                    match.setKickoff(element.getElementsByTagName(KICKOFF).item(0).getTextContent());
                    match.setStage(Integer.parseInt(element.getElementsByTagName(STAGE).item(0).getTextContent()));
                    match.setVenue(new VenueDAL().getVenueByID(Integer.parseInt(element.getElementsByTagName(VENUEID).item(0).getTextContent())));
                    match.setHome(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM1ID).item(0).getTextContent())));
                    match.setAway(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM2ID).item(0).getTextContent())));
                    lst.add(match);
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    public List<Match> getMatchByDate(String date){
        List<Match> lst = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/xml/match.xml");
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(path);
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName(MATCH);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                Element element = (Element)temp;
                if (element.getElementsByTagName(KICKOFF).item(0).getTextContent().toLowerCase().equals(date.toLowerCase())) {
                    Match match = new Match();
                    match.setId(Integer.parseInt(element.getElementsByTagName(ID).item(0).getTextContent()));
                    match.setKickoff(element.getElementsByTagName(KICKOFF).item(0).getTextContent());
                    match.setStage(Integer.parseInt(element.getElementsByTagName(STAGE).item(0).getTextContent()));
                    match.setVenue(new VenueDAL().getVenueByID(Integer.parseInt(element.getElementsByTagName(VENUEID).item(0).getTextContent())));
                    match.setHome(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM1ID).item(0).getTextContent())));
                    match.setAway(new TeamDAL().getTeambyID(Integer.parseInt(element.getElementsByTagName(TEAM2ID).item(0).getTextContent())));
                    lst.add(match);
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}
