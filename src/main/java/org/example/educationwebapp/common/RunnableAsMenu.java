package org.example.educationwebapp.common;

import java.util.Scanner;

public interface RunnableAsMenu {

    default void showMenu() {
        while (true) {
            System.out.println("Hansi emeliyyati etmek isteyirsiniz?");
            System.out.println(
                    """
                            0. ilk defe yaratmaq\s
                            1. yenisini yaratmaq\s
                            2. yenilemek (update)\s
                            3. silmek\s
                            4. axtarmaq\s
                            5. hamisini gormek"""
            );

            int action = new Scanner(System.in).nextInt();
            switch (action) {
                case 0:
                    initialize();
                    break;
                case 1:
                    initializeNew();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    find();
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    void initialize();

    void initializeNew();

    void update();

    void delete();

    void find();

    void printAll();
}
