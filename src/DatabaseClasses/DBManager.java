/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import entities.Player;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import skill.Skill;
import skill.SkillSlot;

/**
 *
 * @author ykx5915
 */
public class DBManager {
    
    private final static String URL = "jdbc:derby:Tribute;create=true";
    private final static String username = "tribute";
    private final static String password = "pdc";
    Connection DBConnection;
    
    public DBManager() {
        establishConnection();
    }
    
    public void establishConnection() {
        if (this.DBConnection == null) {
            try {
                DBConnection = DriverManager.getConnection(URL, username, password);
                //System.out.println(URL + "   CONNECTED....");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }
        

    public void closeConnections() {
        if (DBConnection != null) {
            try {
                DBConnection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Connection getConnection() {
        return DBConnection;
    }
    
    public Player loadPlayer(String playerName) {
        ResultSet rs = null;

        try {
            Statement statement = DBConnection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from Save";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String name = rs.getString("Name");
                if(name.equals(playerName)) {
                    HashMap playerData = new HashMap();
                    playerData.put("name", name);
                    String job = rs.getString("Job");
                    playerData.put("job", job);
                    int level = rs.getInt("Level");
                    playerData.put("level", level);
                    
                    String skill_one = rs.getString("Skill_one");
                    String skill_two = rs.getString("Skill_two");
                    String skill_three = rs.getString("Skill_three");
                    String skill_four = rs.getString("Skill_four");
                    SkillSlot playerSkillSlot = loadSkillSlot(skill_one, skill_two, skill_three, skill_four);
                    playerData.put("skillslot", playerSkillSlot);
                    
                    Player loadedPlayer = new Player(playerData);
                    return loadedPlayer;
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private SkillSlot loadSkillSlot(String skill_one, String skill_two, String skill_three, String skill_four) {
        Skill skill1 = loadSkill(skill_one);
        Skill skill2 = loadSkill(skill_two);
        Skill skill3 = loadSkill(skill_three);
        Skill skill4 = loadSkill(skill_four);
        
        SkillSlot loadedSkillSlot = new SkillSlot(skill1, skill2, skill3, skill4);
        
        return loadedSkillSlot;
    }
    
    private Skill loadSkill(String skill) {
        if(skill.isEmpty()) return null;
        
        String[] skillSplit = skill.split("_");
        int id = Integer.parseInt(skillSplit[0]);
        String name = skillSplit[1];
        String description = skillSplit[2];
        int damage = Integer.parseInt(skillSplit[3]);
        int levelrequirement = Integer.parseInt(skillSplit[4]);
        int maxUsage = Integer.parseInt(skillSplit[5]);
        Skill loadedSkill = new Skill(id, name, description, damage, levelrequirement, maxUsage);
        return loadedSkill;
    }
    
    public void savePlayer(Player player) {
        try {
            Statement statement = DBConnection.createStatement();
            
            String playerName = player.getName();
            String playerJob = player.getJob();
            int playerlevel = player.getLevel();
            
            SkillSlot playerSkillSlot = player.getSkillSlot();
            
            String skill1String = getSkill(playerSkillSlot, 0);
            String skill2String = getSkill(playerSkillSlot, 1);
            String skill3String = getSkill(playerSkillSlot, 2);
            String skill4String = getSkill(playerSkillSlot, 3);
            
            if(!playerExists(player.getName())) {
                String sqlInsert = "insert into Save values("
                    + "'"+playerName+"', '"+playerJob+"', "+playerlevel+", '"+skill1String+"', '"+skill2String+"', "
                    + "'"+skill3String+"', '"+skill4String+"')";
                
                statement.executeUpdate(sqlInsert);
            } else {
                String sqlUpdate = "UPDATE Save SET Level = "+playerlevel+", Skill_one = '"+skill1String+"', Skill_two = '"+skill2String+"', Skill_three = '"+skill3String+"'"
                        + ", Skill_four = '"+skill4String+"' WHERE Name='"+playerName+"'";
                statement.executeUpdate(sqlUpdate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getSkill(SkillSlot skillSlot, int index) {
        Skill skill = skillSlot.getSkill(index);
        if(skill != null) return skill.saveSkill();
        return "";
    }
    
    public boolean playerExists(String player) {
        ResultSet rs = null;

        try {
            Statement statement = DBConnection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from Save";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String name = rs.getString("Name");
                if(name.equals(player)) return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Skill> getSkillList(String jobTable) {
        ArrayList<Skill> skillList = new ArrayList<>();
        
        ResultSet rs = null;

        try {
            Statement statement = DBConnection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from " + jobTable;

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int damage = rs.getInt("Damage");
                int levelRequirement = rs.getInt("LevelRequirement");
                int maxUsage = rs.getInt("MaxUsage");
                
                Skill skill = new Skill(id, name, description, damage, levelRequirement, maxUsage);
                skillList.add(skill);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return skillList;
    }
    
    
    public static void main(String[] args) throws SQLException {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());

//        Testing loadplayer
//        Player peter = dbManager.loadPlayer("Peter");
//        System.out.println(peter.getName());
//        System.out.println(peter.getSkillSlot().getSkill(0).getName());
//        System.out.println(peter.getSkillSlot().getSkill(1).getName());
//        System.out.println(peter.getSkillSlot().getSkill(2).getName());
//        System.out.println(peter.getSkillSlot().getSkill(3).getName());

//        Player dave = new Player("Dave", "Warrior");
//        dbManager.savePlayer(dave);
//        
//        Player loadedDave = dbManager.loadPlayer("Dave");
//        System.out.println(loadedDave.getName());
//        System.out.println(loadedDave.getLevel());
//        loadedDave.levelUp();
//        System.out.println(loadedDave.getLevel());
//        
//        dbManager.savePlayer(loadedDave);
//        loadedDave = dbManager.loadPlayer("Dave");
//        System.out.println(loadedDave.getLevel());
        System.out.println(dbManager.playerExists("Peter"));
        Player peter = dbManager.loadPlayer("Peter");
    }

    
    
    
        
   
}
