/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author asdfg
 */
public class ImagePath {
    public static class Character{
        public static final String FOLDER_CHARACTERS = "/characters";
        public static class Cat{
            public static final String SMALL_CAT_ACT = FOLDER_CHARACTERS + "/catact.png";
            public static final String SMALL_CAT_1 = FOLDER_CHARACTERS + "/cat1.png";
        }
    }
    
    public static class Scene{
        public static final String FOLDER_SCENES = "/scenes";
        
        public static final String CHARACTER_TYPE1 = FOLDER_SCENES + "/scene1.jpg";
    }
    
    public static class Tempo{
        public static final String FOLDER_TEMPOS =  "/tempos";
        public static final String TEMPO1 =  FOLDER_TEMPOS + "/tempo2.png";
        public static final String TEMPO2 =  FOLDER_TEMPOS + "/tempo3.png";
        public static final String TEMPO3 =  FOLDER_TEMPOS + "/tempo4.png";               
    }
}
