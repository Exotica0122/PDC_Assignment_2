/*
 * This database class is to initiallize the tables
 * It will not be in the final publish of the game
 * but it is included for demonstrations
 */
package DatabaseClasses;

import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ykx5915
 */
public class TableSetter {
    
    private DBManager dbManager;
    
    public TableSetter() {
        dbManager = new DBManager();
    }
    
    public void createWarriorTable() {
        try {
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "WarriorSkill";
            
//          Reset to recreate table:

//            String sqlDrop = "DROP TABLE " + newTableName;
//            statement.executeUpdate(sqlDrop);

            String sqlCreate = "create table " + newTableName + " (ID int not null,"
                    + "Name varchar(20), Description varchar(50),"
                    + ""
                    + "Damage int, LevelRequirement int, MaxUsage int, PRIMARY KEY (ID))";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "1, 'Punch', 'Punches with great force', 10, 3, 20),"
                    + "("
                    + "2, 'Side_Kick', 'Attacks with a tight side kick', 20, 5, 20),"
                    + "("
                    + "3, 'Headbutt', 'Headbutts the enemy with unexpected', 35, 10, 15),"
                    + "("
                    + "4, 'Pound', 'Pound enemy with players weight', 40, 15, 15),"
                    + "("
                    + "5, 'Double-Slash', 'Slashed twice with great force', 45, 22, 12),"
                    + "("
                    + "6, 'Slice', 'Slices enemy with sword', 50, 28, 12),"
                    + "("
                    + "7, 'Dice', 'Dices enemys body part', 60, 35, 10),"
                    + "("
                    + "8, 'Wonder-Slash', 'A slash powerful to cut through titanium', 80, 40, 5),"
                    + "("
                    + "9, 'Shield-bash', 'Bashes enemy with a shield with spikes', 100, 50, 3),"
                    + "("
                    + "10, 'Swift-Slash', 'An attack that is faster than reaction', 120, 66, 2)";
            statement.executeUpdate(sqlInsert);

            //statement.close();
            System.out.println("Table created");

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createArcherTable() {
        try {
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "ArcherSkill";
            
//          Reset to recreate table:

//            String sqlDrop = "DROP TABLE " + newTableName;
//            statement.executeUpdate(sqlDrop);

            String sqlCreate = "create table " + newTableName + " (ID int not null,"
                    + "Name varchar(20), Description varchar(50),"
                    + ""
                    + "Damage int, LevelRequirement int, MaxUsage int, PRIMARY KEY (ID))";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "1, 'Sling', 'Slings enemy with a pebble', 10, 3, 20),"
                    + "("
                    + "2, 'Double Sling', 'Slings with two pebbles', 20, 5, 20),"
                    + "("
                    + "3, 'Dart Shot', 'Shots extremely accurate dart', 35, 10, 15),"
                    + "("
                    + "4, 'Swift Shot', 'Shots light weight shots', 40, 15, 15),"
                    + "("
                    + "5, 'Triple Sling', 'Slings with three normal darts', 45, 22, 12),"
                    + "("
                    + "6, 'Explosive Arrow', 'Shots highly explosive arrows', 50, 28, 12),"
                    + "("
                    + "7, 'Electric Shot', 'Shots electric arrow', 60, 35, 10),"
                    + "("
                    + "8, 'Scatter Arrow', 'Shots arrow that can reflect off walls', 80, 40, 5),"
                    + "("
                    + "9, 'Blaster', 'Blast shot with an arrowgun', 100, 50, 3),"
                    + "("
                    + "10, 'Rain-of-arrows', 'High amount of arrows rain the enemy', 120, 66, 2)";
            statement.executeUpdate(sqlInsert);

            //statement.close();
            System.out.println("Table created");

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getSkillQuery(String table) {
        ResultSet rs = null;

        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from " + table;

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int damage = rs.getInt("Damage");
                int levelRequirement = rs.getInt("LevelRequirement");
                int maxUsage = rs.getInt("MaxUsage");
                
                System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description
                    + ", Damage: " + damage + ", LevelRequirement: " + levelRequirement + ", MaxUsage: " + maxUsage);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createSaveStateTable() {
        try {
            Statement statement = dbManager.getConnection().createStatement();
            String newTableName = "Save";
            
//          Reset to recreate table:

            String sqlDrop = "DROP TABLE " + newTableName;
            statement.executeUpdate(sqlDrop);

            String sqlCreate = "create table " + newTableName + " ("
                    + "Name varchar(20), Job varchar(50), Level int,"
                    + "Skill_one varchar(100), Skill_two varchar(100), "
                    + "Skill_three varchar(100), Skill_four varchar(100))";
            statement.executeUpdate(sqlCreate);
            
            String sqlInsert = "insert into " + newTableName + " values("
                    + "'Peter', 'Archer', 2, '1_Sling_Slings enemy with a pebble_10_3_20', '2_Double Sling_Slings with two pebbles_20_5_20', "
                    + "'3_Dart Shot_Shots extremely accurate dart_35_10_15', '4_Swift Shot_Shots light weight shots_40_15_15')";
            statement.executeUpdate(sqlInsert);
            

            //statement.close();
            System.out.println("Table created");

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getSaveQuery() {
        ResultSet rs = null;

        try {
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from Save";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String name = rs.getString("Name");
                String job = rs.getString("Job");
                int level = rs.getInt("Level");
                String skill_one = rs.getString("Skill_one");
                String skill_two = rs.getString("Skill_two");
                String skill_three = rs.getString("Skill_three");
                String skill_four = rs.getString("Skill_four");
                
                System.out.println("Name: " + name + ", Job: " + job + ", Level: " + level +
                    ", Skill 1: " + skill_one + ", Skill 2: " + skill_two + ", Skill 3: " + skill_three + ", Skill 4: " + skill_four);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        TableSetter tableSetter = new TableSetter();
//      Table is already created  

//        tableSetter.createWarriorTable();
//        tableSetter.createArcherTable();
//        tableSetter.createSaveStateTable();

//        tableSetter.getSkillQuery("WarriorSkill");
//        System.out.println();
//        tableSetter.getSkillQuery("ArcherSkill");
//        System.out.println();
        tableSetter.getSaveQuery();
        tableSetter.dbManager.closeConnections();
    }
    
}
