/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0808.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08082 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int grade[][] = new int[2][2];
        int i = 0;
        int n;
        do {
            n = scanner.nextInt();
            if (n == -1){
                break;
            }
            if (i == grade.length){
                int tmpArr[][] = new int[grade.length * 2][2];
                for (int j = 0; j < grade.length; j++){
                    for (int k = 0; k < grade[j].length; k++){ //grade[j].length,length為[][]這個陣列的長度,也就是2
                        tmpArr[j][k] = grade[j][k];
                        //System.out.print(tmpArr[j][k] + " ");
                    }
                }
                grade = tmpArr;
            }
            grade[i][0] = i + 1;
            grade[i++][1] = n;
        } while (true);
        
        System.out.println();
        for (int j = 0; j < i; j++){
            System.out.print(grade[j][0] + " " + grade[j][1] + "\n");
        }    
        
    }
}