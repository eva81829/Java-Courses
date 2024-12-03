/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0918.pkg1;

/**
 *
 * @author Eka
 */
public abstract class Creature {
    private String name;
    private char ic;
    private int level;
    private int life;
    private boolean moved;
    private int[] direction;
    private int count;
    
    public Creature(){
        life = 5;
        moved = true;
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 8};
        direction = arr;
        count = 0;
    }
    
    private void shuffle(){
        for (int i = 0; i < 7; i++) {
            int swap = (int) (Math.random() * (8 - i) + i);
            int tmp = direction[i];
            direction[i] = direction[swap];
            direction[swap] = tmp;
        }
    }    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setIc(char ic){
        this.ic = ic;
    }
    
    public char getIc(){
        return ic;
    }    
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getLife(){
        return life;
    }
    
    public void decreaseLife(){
        life--;
    }
    
    public void increaseLife(){
        life++;
    }  
    
    public void setMoved(boolean moved){
        this.moved = moved;
    }    
    
    public boolean getMoved(){
        return moved;
    }
    
    public int move(int number) {
        return direction[number];
    }
    
    public int eat(Creature killedCreature) { // 判斷新物種是否會被吃掉 (被吃掉:true，不被吃:false)
        if (killedCreature == null){ // 如果新物種不存在 (扣血: 檢查原物種血量，如果血量已為0，原物種消失)(被吃掉)
            return 0;
        } else if (killedCreature.level < this.level){ //如果新物種level比較低 (不扣血)(被吃掉)
            return 1;
        }
        return -1; //(不被吃)
    }

}
