//nombre de la package donde guardamos las cosas

package com.iesemilidarder.restaurants.core;

//importamos las librerias que necesitamos

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// creacion de clase
// parte  del trabajo SD y SXI
public class Leer {
    //otro manerade conexion de base datos sim repetir
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String THIN_URL = "jdbc:oracle:thin:@35.205.41.45:1521:XE";
    private static final String USER = "usuari";
    private static final String PASSWORD = "usuari";

    private Object executeQuery(String query, Function<ResultSet, Object> f) {
        Connection con;
        Statement stmt;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Object o = f.apply(rs);
            stmt.close();
            con.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Restaurant> LeerRestAPI(String consulta) {

        //VERSION GENERICS
        List<Restaurant> ar = new ArrayList<>();
        try {
            String query;
            if (StringUtils.isEmpty(consulta)) {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI AND ROWNUM <=5 ORDER BY RES_MITJANA DESC ";

            } else {
                query = "SELECT * FROM restaurants res JOIN trestaurants tres ON tres.TRS_CODI = res.RES_TRS_CODI WHERE lower(res.RES_NOM) LIKE '%" + consulta.toLowerCase() + "%'";

            }

            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Restaurant res = new Restaurant();
                res.setCode(rs.getString("RES_CODI"));
                res.setNom(rs.getString("RES_NOM"));
                res.setAdresa(rs.getString("RES_ADRECA"));
                res.setWebsite(rs.getString("RES_WEB"));
                res.setTelefono(rs.getString("RES_TELEFON"));
                res.setTipus(rs.getString("TRS_DESCRIPCIO"));
                res.setImagen(rs.getString("RES_URL_IMG"));
                res.setMitjana(rs.getString("RES_MITJANA"));


                ar.add(res);
            }

        } catch (Exception e) {
            System.out.println((e.toString()));
        }
        return ar;
    }






    public List getRestaurants(boolean Search) {
        List<Restaurant> arrayRestaurants = new ArrayList<>();
        ResultSetMapper<Restaurant> mapper = new ResultSetMapper<>();
        try {
            final String query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                    "RESTAURANTS R,TRESTAURANTS TR WHERE  R.RES_TRS_CODI = TR.TRS_CODI";
            if (Search) {
                //VERSION GENERICS
                Class.forName(DRIVER);
                Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                //aqui indicamos que mientras existan restaurantes
                arrayRestaurants = mapper.mapResultSetToObject(rs, Restaurant.class);
                stmt.close();
                con.close();
            } else {
                //VERSION FUNCTIONAL
                arrayRestaurants = new ArrayList<>();
                Function<ResultSet, Object> func = new Function<ResultSet, Object>() {
                    public Object apply(ResultSet rs) {
                        return mapper.mapResultSetToObject(rs, Restaurant.class);
                    }
                };
                arrayRestaurants = (ArrayList) executeQuery(query, func);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayRestaurants;
    }


//    // Parte de trabajo de IAW
//    // creacion de array list
    public ArrayList readRestaurant(String consulta) {
        ArrayList restaurant = new ArrayList();
        try {
            //creacion de conexion de la base de datos
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();

            ResultSet rs;
            if (consulta == null) {
                rs = stmt.executeQuery("Select RES_NOM,RES_ADRECA,RES_WEB,RES_TELEFON,TRS_DESCRIPCIO,RES_URL_IMG,RES_MITJANA,RES_CODI FROM Restaurants,TRESTAURANTS WHERE trs_codi = res_trs_codi AND ROWNUM <= 5 ORDER BY RES_MITJANA DESC ");
            } else {
                rs = stmt.executeQuery("Select RES_NOM,RES_ADRECA,RES_WEB,RES_TELEFON,TRS_DESCRIPCIO,RES_URL_IMG,RES_MITJANA,RES_CODI FROM Restaurants,TRESTAURANTS WHERE trs_codi = res_trs_codi AND lower(RES_NOM) LIKE '%" + consulta.toLowerCase() + "%'");
            }
            // bucles treure totes se filas de base de datos
            while (rs.next()) {
                String nom = rs.getString("RES_NOM");
                String adresa = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String tipus = rs.getString("TRS_DESCRIPCIO");
                String Imagen = rs.getString("RES_URL_IMG");
                String Mitjana = rs.getString("RES_MITJANA");
                String Code = rs.getString("RES_CODI");

                Restaurant std = new Restaurant();

                std.setNom(nom);
                std.setAdresa(adresa);
                std.setWebsite(website);
                std.setTelefono(telefono);
                std.setTipus(tipus);
                std.setImagen(Imagen);
                std.setMitjana(Mitjana);
                std.setCode(Code);

                restaurant.add(std);
            }
            stmt.close();
            // cirre de la conexion de la base de datos
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return restaurant;
    }


    public Restaurant readinfo(String id) {
        Restaurant res = null;
        ArrayList<Opinions> opini = new ArrayList<Opinions>();
        try {
            //creacion de conexion de la base de datos
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
          /* sentencia sqL */
            ResultSet rs;
            rs = stmt.executeQuery("Select * " +
                    "FROM Restaurants,TRESTAURANTS WHERE TRS_CODI = RES_TRS_CODI " +
                    " AND RES_CODI=" + id);

            // bucles treure totes se filas de base de datos
            if (rs.next()) {
                String nom = rs.getString("RES_NOM");
                String adresa = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String tipus = rs.getString("TRS_DESCRIPCIO");
                String Imagen = rs.getString("RES_URL_IMG");
                String Mitjana = rs.getString("RES_MITJANA");
                String Code = rs.getString("RES_CODI");
                String Latitud = rs.getString("RES_LATITUD");
                String Longitud = rs.getString("RES_LONGITUD");


                res = new Restaurant();

                res.setNom(nom);
                res.setAdresa(adresa);
                res.setWebsite(website);
                res.setTelefono(telefono);
                res.setTipus(tipus);
                res.setImagen(Imagen);
                res.setMitjana(Mitjana);
                res.setCode(Code);



            }

            //stmt.close();

            rs = stmt.executeQuery("Select * " +
                    "FROM Restaurants,OPINIONS WHERE  OPI_RES_CODI = RES_CODI AND RES_CODI =" + id);

            // bucles treure totes se filas de base de datos
            while (rs.next()) {


                Opinions opi  = new Opinions();

                String opicodi = rs.getString("OPI_CODI");
                String OpiObserv = rs.getString("OPI_OBSERVACIO");;
                String OpiPunt = rs.getString("OPI_PUNTUACIO");
                String OpiRev = rs.getString("OPI_OPINIO_REVISADA");

                opi.setOpiCodi(opicodi);
                opi.setOpiObserv(OpiObserv);
                opi.setOpiPunt(OpiPunt);
                opi.setOpiRev(OpiRev);

                opini.add(opi);

            }

            res.setOpinions(opini);

            stmt.close();
            // cirre de la conexion de la base de datos
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return res;
    }

}