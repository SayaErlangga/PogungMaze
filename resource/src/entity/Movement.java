package entity;

import javax.swing.*;

//Interface digunakan supaya setiap class lain yang memanggil class ini, harus menambahkan fungsi yang ada di kelas ini
interface Movement{

    ImageIcon upAndDown(boolean isUp);
    ImageIcon leftAndRight(boolean isLeft);

}
