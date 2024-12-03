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
public class Horse extends Creature {

    private static int numer = 0;

    public Horse() {
        name = "Horse" + ++numer;
        ic = 'H';
        level = 2;
    }

    @Override
    public Creature move(Creature killedCreature) { // 判斷新物種是否會被吃掉 (被吃掉:用原物種取代，不被吃:新物種保持不變)
        moved = true;
        if (killedCreature == null) { // 如果新物種不存在 (扣血: 檢查原物種血量，如果血量已為0，原物種消失)(被吃掉)
            return this.checkLife();
        } else if (killedCreature.level < this.level) {
            return this;  // 如果新物種level比較低 (不扣血)(被吃掉)
        }
        return killedCreature; //(不被吃) 
    }

}
