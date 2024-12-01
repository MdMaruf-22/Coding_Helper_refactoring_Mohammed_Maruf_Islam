package code_clone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxAndWhiskerChart {
    ChartPanel chartPanel;
    JScrollPane scrollPane;
    private List<Double> getInputData(double l[]) {
        ArrayList<Double> list = new ArrayList<>();
        for (int j = 0; j < l.length; j++) {
            list.add(l[j]);

        }
        return list;
    }

    public void display() {
        JFrame f = new JFrame("Clone_Check");

        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultBoxAndWhiskerCategoryDataset boxData = new DefaultBoxAndWhiskerCategoryDataset();

        for (int i = 0; i < CosineSimilarity.similarArray.size(); i++) {
            boxData.add(getInputData(CosineSimilarity.similarArray.get(i)), "First_Project vs Second_Project", CloneCheck.ProjectFileName1.get(i));
        }
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setFillBox(true);
        renderer.setUseOutlinePaintForWhiskers(true);

        renderer.setMedianVisible(true);
        renderer.setMeanVisible(false);

        CategoryAxis xAxis = new CategoryAxis("First_Project_Files");
        NumberAxis yAxis = new NumberAxis("Second_Project_Values");
        CategoryPlot plot = new CategoryPlot(boxData, xAxis, yAxis, renderer);
        final JFreeChart chart = new JFreeChart(
                "Box-and-Whisker Plot",
                new Font("SansSerif", Font.BOLD, 20),
                plot,
                true
        );
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        f.add(new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 600);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void BoxWhisker() {
        EventQueue.invokeLater(new BoxAndWhiskerChart()::display);
    }
}

/*
Dtata preporcessing pipelin, process data from various file such as CSV,JSON and XML.The processing step for these
fioles for formas are simmilar,but each file formatr requires specific steps for reading,parsing and saving
Design a system that can process different file formats,while general flow (reading, parsing,saving) is the same
but implementation for eacg step is differetncbased on file
CSV: require reading line by line,parsing comma seperated value and saving it in a structed format
JSON: requires reading a json file parsing objects and maping to class structure
XML:reading a xml file,parsing it with xmlparser and saving
in the client code we can easily process dufferetn file format by simply selecting appropriate processor,use
design pattern in java to do this.Not actually full n
 */
