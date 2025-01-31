/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user1
 */
public class CommandSolver extends Thread {

    public enum MouseState {
        CLICKED,
        PRESSED,
        RELEASED,
        ENTERED,
        EXITED,
        WHEEL_MOVED,
        DRAGGED,
        MOVED
    }

    private static class Data {

        protected long time;

        public Data(long time) {
            this.time = time;
        }
    }

    private static class KeyData extends Data {

        private Map<Byte, Boolean> map;

        public KeyData(Map<Byte, Boolean> map, long time) {
            super(time);
            this.map = map;
        }
    }

    private static class MouseData extends Data {

        private MouseEvent e;
        private MouseState state;

        public MouseData(MouseEvent e, MouseState state, long time) {
            super(time);
            this.e = e;
            this.state = state;
        }
    }

    public interface KeyCommandListener {

        public void keyPressed(int commandCode, long trigTime);

        public void keyReleased(int commandCode, long trigTime);
    }

    public interface MouseCommandListener {

        public void mouseTrig(MouseEvent e, MouseState state, long trigTime);
    }

    public static class CommandWrapper {

        KeyData keyData;
        MouseData mouseData;

        private CommandWrapper(KeyData keyData, MouseData mouseData) {
            this.keyData = keyData;
            this.mouseData = mouseData;
        }

        public void actionCommand(KeyCommandListener listener) {
            if (listener == null || keyData == null) {
                return;
            }
            keyData.map.keySet().forEach((key) -> {
                boolean pressed = keyData.map.get(key);
                if (pressed) {
                    listener.keyPressed(key, keyData.time);
                } else {
                    listener.keyReleased(key, keyData.time);
                }
            });
        }

        public void actionCommand(MouseCommandListener listener) {
            if (listener == null || mouseData == null) {
                return;
            }
            listener.mouseTrig(mouseData.e, mouseData.state, mouseData.time);
        }
    }

    public static class CommandConverter {

        private boolean clear;// 是否在更新時清除上一幀指令
        private final Map<Integer, Byte> keyMap;// input to command
        private Map<Byte, Boolean> pressedMap;// command pressed/released

        public CommandConverter(boolean clear) {
            keyMap = new ConcurrentHashMap<>();
            pressedMap = new ConcurrentHashMap<>();
            this.clear = clear;
        }

        public void addKeyPair(int key, Byte command) {
            keyMap.put(key, command);
        }

        public void addKeyPair(int key, int command) {
            keyMap.put(key, (byte) command);
        }

        public void updateCommandByKey(int key, boolean pressed) {
            if (!keyMap.containsKey(key)) {
                return;
            }
            pressedMap.put(keyMap.get(key), pressed);
        }

        public boolean getPressedByKey(int key) {
            if (!keyMap.containsKey(key)) {
                return false;
            }
            return pressedMap.get(keyMap.get(key));
        }

        public Map<Byte, Boolean> release() {
            Map<Byte, Boolean> tmp = pressedMap;
            if(clear){
                pressedMap = new ConcurrentHashMap<>();
            }else{
                pressedMap = new ConcurrentHashMap<>(tmp);
            }
            // fill map
            keyMap.values().forEach((value) -> {
                if (!tmp.containsKey(value)) {
                    tmp.put(value, Boolean.FALSE);
                }
            });
            return tmp;
        }
    }

    private static class CommandRecorder<T extends Data> {

        private class Node {

            private T data;
            private Node next;

            public Node(T data) {
                this.data = data;
            }
        }
        private Node root;
        private Node current;
        private Node tail;

        public CommandRecorder() {
            root = tail = current = new Node(null);
        }

        public void add(T data) {
            tail = tail.next = new Node(data);
        }

        public boolean hasNext() {
            return current != tail;
        }

        public T next() {
            current = current.next;
            return current.data;
        }

        public T getCurrent() {
            return current.data;
        }

        public void reset() {
            current = root;
        }

//        public void writeCsv(String fileName){
//            
//        }
//        
//        public static CommandRecorder genByCsv(String fileName){
//            
//        }
    }

    private static class MouseTracker {

        private CommandRecorder<MouseData> recorder;
        private MouseEvent currentEvent;
        private MouseState currentState;

        private MouseTracker() {
            recorder = new CommandRecorder<>();
        }

        private void trig(MouseEvent e, MouseState state) {
            currentEvent = e;
            currentState = state;
        }

        // 將當前的指令存入recorder並刷新(滑鼠暫時不刷新)指令集
        private void record(long time) {
            recorder.add(new MouseData(currentEvent, currentState, time));
            currentEvent = null;
            currentState = null;
        }

        // 遊戲更新取得對應的指令
        public MouseData update() {
            if (recorder.hasNext()) {
                return recorder.next();
            }
            return null;
        }

        public void bind(Component c) {
            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    trig(e, MouseState.CLICKED);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    trig(e, MouseState.PRESSED);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    trig(e, MouseState.RELEASED);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    trig(e, MouseState.ENTERED);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    trig(e, MouseState.EXITED);
                }

                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    trig(e, MouseState.WHEEL_MOVED);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    trig(e, MouseState.DRAGGED);
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    trig(e, MouseState.MOVED);
                }
            };
            c.addMouseListener(mouseAdapter);
            c.addMouseMotionListener(mouseAdapter);
            c.addMouseWheelListener(mouseAdapter);
        }
    }

    private static class KeyTracker {
        // 自定義行為列表

        private CommandConverter commandList;
        // 紀錄每一次更新時的按鍵行為
        private CommandRecorder<KeyData> recorder;

        // 導入行為列表
        private KeyTracker(boolean clear) {
            commandList = new CommandConverter(clear);
            recorder = new CommandRecorder<>();
        }

        // 新增自定義按鍵以及對應的指令 => 用於不同種類的input設定
        public void add(int key, int command) {
            commandList.addKeyPair(key, command);
        }

        // 通過自定義按鍵去指定對應指令狀態
        public void trig(int key, boolean isPressed) {
            commandList.updateCommandByKey(key, isPressed);
        }

        // 將當前的指令存入recorder並刷新指令集
        public void record(long time) {
            recorder.add(new KeyData(commandList.release(), time));
        }

        // 遊戲更新取得對應的指令
        public KeyData update() {
            if (recorder.hasNext()) {
                return recorder.next();
            }
            return null;
        }
    }

    public static class Builder {

        private ArrayList<int[]> cmArray;
        private int[][] array;
        private long deltaTime;
        private MouseTracker mt;
        private boolean clear;

        public Builder(long deltaTime) {
            clear = false;
            this.deltaTime = deltaTime;
            cmArray = new ArrayList<>();
        }

        public Builder(long deltaTime, int[][] array) {
            clear = false;
            this.deltaTime = deltaTime;
            this.array = array;
        }

        public Builder(long deltaTime, ArrayList<int[]> cmArray) {
            clear = false;
            this.deltaTime = deltaTime;
            this.cmArray = cmArray;
        }

        public Builder add(int key, int command) {
            cmArray.add(new int[]{key, command});
            return this;
        }

        public Builder enableMouseTrack(Component c) {
            mt = new MouseTracker();
            mt.bind(c);
            return this;
        }
        
        public Builder keyTypedMode(){
            clear = true;
            return this;
        }

        public CommandSolver gen() {
            KeyTracker cm = new KeyTracker(clear);
            if (cmArray != null) {
                for (int[] keyPair : cmArray) {
                    cm.add(keyPair[0], keyPair[1]);
                }
            } else if (array != null) {
                for (int[] keyPair : array) {
                    cm.add(keyPair[0], keyPair[1]);
                }
            }

            return new CommandSolver(deltaTime, cm, mt);
        }
    }

    private final long deltaTime;
    private final KeyTracker keyTracker;
    private final MouseTracker mouseTracker;

    private CommandSolver(long deltaTime, KeyTracker keyTracker, MouseTracker mouseTracker) {
        this.deltaTime = deltaTime;
        this.keyTracker = keyTracker;
        this.mouseTracker = mouseTracker;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long passedFrames = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            long totalTime = currentTime - startTime;
            long targetTotalFrames = totalTime / deltaTime;
            while (passedFrames < targetTotalFrames) {
                synchronized (keyTracker) {
                    keyTracker.record(currentTime);
                }
                if (mouseTracker != null) {
                    mouseTracker.record(currentTime);
                }
                passedFrames++;
            }
        }
    }

    public void trig(int key, boolean isPressed) {
        synchronized (keyTracker) {
            keyTracker.trig(key, isPressed);
        }
    }

    public CommandWrapper update() {
        MouseData mouseData = null;
        KeyData keyData;
        synchronized (keyTracker) {
            keyData = keyTracker.update();
        }
        if (mouseTracker != null) {
            synchronized (mouseTracker) {
                mouseData = mouseTracker.update();
            }
        }
        return new CommandWrapper(keyData, mouseData);
    }
}

