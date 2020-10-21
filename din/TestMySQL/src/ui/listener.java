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
    private List<client> clients_list;
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
                ClientDAO c_dao = new ClientDAO();
                c = c_dao.findByIdclient(with, c);
                DB_Connection.CloseConnection(with);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // LOAD ALL CLIENTS
        if (e.getSource() == this.all) {
            // on all motion buttons enabled
            idSearch.setText("");
            forward.setEnabled(true);
            backwards.setEnabled(true);
            position = 0;
            // All clients:
            try {
                Connection_DB DB_Connection = new Connection_DB();
                Connection with = DB_Connection.OpenConnection();
                ClientDAO customerDAO = new ClientDAO();
                clients_list = customerDAO.findAll(with);
                DB_Connection.CloseConnection(with);
                // charge the first customer
                position = 0;
                c = clients_list.get(position);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //AHEAD
        if (e.getSource() == this.forward) {
            position++;
            if (position == clients_list.size()) {
                position--;
            }
            c = clients_list.get(position);

        }
        //BEHIND
        if (e.getSource() == this.backwards) {
            if (position > 0) {
                position--;
            }
            c = clients_list.get(position);
        }
        update(c);

    }

    private void update(client c) {
        this.id.setText(c.getId());
        this.notes.setText(c.getNotes());
    }
}
