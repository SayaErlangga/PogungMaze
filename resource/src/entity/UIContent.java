package entity;

import javax.swing.*;


//Karena bentuknya masih abstrak, class ini tidak bisa dibuat langsung menjadi objek
abstract class UIContent {

    abstract JLabel bgLabel(String asset);

    abstract JLabel charLabel(String asset);
    abstract JLabel obsLabel(String asset);

    abstract JLabel homeUILabel(String asset);

    abstract JLabel winLabel(String asset);

    abstract JLabel timeLabel(String text);

    abstract JLabel notifLabel();

}
