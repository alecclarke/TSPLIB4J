package main;

import com.alexanderclarke.tsplib.NearestNeighbour;
import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.TSPPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by alexanderclarke on 2016-03-10.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TSPInstance problem = new TSPInstance(new File("/Users/alexanderclarke/Desktop/TSPLIB4J/src/resources/dj38.tsp"));
        NearestNeighbour nn = new NearestNeighbour(problem);
        TSPPanel panel = new TSPPanel(problem);
        System.out.println("Distance: " + nn.apply().distance(problem));
        panel.displayTour(nn.apply(), Color.RED);
        JFrame frame = new JFrame(problem.getName());
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

