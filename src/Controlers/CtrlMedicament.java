package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT idMedoc,nomMedoc,prixMedoc \n" +
                    "FROM `medicament` ");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Medicament medicament =new Medicament(rs.getInt(1),rs.getString(2),rs.getInt(3),0);
                lesMedicaments.add(medicament);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lesMedicaments;
    }
}
