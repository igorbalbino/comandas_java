package com.igor.gerenciadordecomandas;

import android.util.Log;
import android.webkit.JavascriptInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorComanda {

    private String TAG = "|GerenciadorComanda|";
    private Connection connection = null;
    private String databaseName = "";
    private String url = "jdbc:mysql://localhost:3306" + databaseName;

    private String username = "root";
    private String password = "121212";

    public GerenciadorComanda()  {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            Log.d(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Access denied: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.d(TAG, "Instância quebrada ou inexistente: " + e.getMessage());
        } catch (SQLException e) {
            Log.d(TAG, "Erro de SQL" + e.getMessage());
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @JavascriptInterface
    public void criaComanda(String nome, String pedido) {
        
    }

}
