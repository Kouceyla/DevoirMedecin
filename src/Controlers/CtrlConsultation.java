package Controlers;

import Tools.ConnexionBDD;

import java.sql.*;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getLastNumberOfConsultation()
    {
        int maxNumero = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement(" SELECT MAX(idConsult) \n" +
                    "FROM consultation");
            rs = ps.executeQuery();
            rs.next();
            maxNumero =rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return maxNumero;
    }
    public void InsertConsultation(int idConsult, String dateConsult, int numPatient, int numMedecin)
    {
        // A vous de jouer
        try {
            ps = cnx.prepareStatement("INSERT INTO `consultation` (`idConsult`,`dateConsult`, `numPatient`,`numMedecin`) VALUES (?,?,?,?)");
            ps.setInt(1,idConsult);
            ps.setString(4,dateConsult);
            ps.setInt(3,numPatient);
            ps.setInt(2,numMedecin);
            
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void InsertConsultation(int parseInt, int numMed, int numPat, int idConsult, int dateConsult) {
    }
}
