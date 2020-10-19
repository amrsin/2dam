/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class listener implements ActionListener {

    private JTextField id, idSearch;
    private JTextArea notes;
    private JButton backwards, forward, search, all;
    private List<client> clients;
    private int position;

    public listener(JTextField id, JTextArea notes, JTextField idSearch,
            JButton backwards, JButton forward, JButton search, JButton all) {
        this.id = id;
        this.notes = notes;
        this.idSearch = idSearch;
        this.backwards = backwards;
        this.forward = forward;
        this.search = search;
        this.all = all;
        position = 0;
    }

    public void actionPerformed(ActionEvent e) {
       client c = new client();
        // FIND A CLIENT
        if (e.getSource() == this.search) {
        // in searches disabled movement buttons
            forward.setEnabled(false);
            backwards.setEnabled(false);
            try {

                Connection_DB DB_Connection = new Connection_DB();
                Connection with = DB_Connection.OpenConnection();
                Connection_DB customerDAO = new Connection_DB();
                c.setId(idSearch.getText());
                c = ClientDAO.findById(with, c);
                DB_Connection.CloseConnection(with);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}