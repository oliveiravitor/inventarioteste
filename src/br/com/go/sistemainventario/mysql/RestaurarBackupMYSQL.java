/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemainventario.mysql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oliveira
 */
public class RestaurarBackupMYSQL {

    /**
     *
     * @return
     */
    public static boolean restoreDB() {
        try {
            List<String> command = new ArrayList<>();
            command.add("C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\mysql");
            command.add("-u");
            command.add("-p");
            command.add("-e");
            command.add("source c:\\temp\\inventarioteste.sql");

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process;
            try {
                process = processBuilder.start();
                System.out.println(process.waitFor());
                return true;
            } catch (IOException | InterruptedException ex) {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}