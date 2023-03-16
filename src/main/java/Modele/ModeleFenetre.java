package Modele;


import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModeleFenetre {
    private int width;
    private int height;
    private String title;


    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Scanner in = new Scanner(System.in);

    public ModeleFenetre() {
        saisirFen();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public void saisirFen() {
        System.out.println("Entrez le titre de la fênetre: ");
        title = in.nextLine();
        do {
            System.out.println("Entrez la largeur de la fenetre(max: "+screenSize.width+")");
            try {
                width = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
            }
        } while (width <= 0 || width > screenSize.width);
        do {
            System.out.println("Entrez la hauteur de la fenetre (max: "+screenSize.height+")");
            try {
                height = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
            }
        } while (height <= 0 || height > screenSize.height);
    }
}