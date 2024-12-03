/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg2builder;

/**
 *
 * @author Eka
 */
public class Course09232Builder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Student student = new Student.Builder("a", "12", "0911209421") //Builder pattern 使用在物件屬性只允許在建構階段進行設定, 之後就不能更動
                .setLineId("123")
                .setScore1(100)
                .setScore2(50)
                .setScore3(80)
                .gen();

    }

}
