package course1211.pkg1mergesort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class MergeSort {
    private int length;
    private int[] arrayOld;
    private int[] arrayNew;
    
    public MergeSort(int[] array){
        length = array.length;
        if(length == 0){
            System.out.print("Null Array");
            return;
        } else if (length == 1){
            return;
        }
        arrayOld = array;
        arrayNew = new int[length];
        sort();
    }
    
    private void sort(){
        int oldSortedUnit = 1, newSortedUnit = 2;
        do{
            int leftIndex = 0, rightIndex = oldSortedUnit, insertIndex = 0;
            boolean notMergedArraySumAreEven = (length/oldSortedUnit + (length%oldSortedUnit == 0 ? 0: 1))%2 == 0;//偶數個
            int roundEndIndex = (notMergedArraySumAreEven? length : newSortedUnit * (length/newSortedUnit));
            int turnEndIndex = (newSortedUnit>=length ? length : newSortedUnit);
            while(insertIndex<roundEndIndex){
//                print("old", arrayOld);
//                print("new", arrayNew);
//                System.out.println("roundEndIndex:" + roundEndIndex);
//                System.out.println("turnEndIndex:" + turnEndIndex);
//                System.out.println("oldSortedUnit" + oldSortedUnit);  
//                System.out.println("newSortedUnit" + newSortedUnit);  
//                System.out.println("insertIndex" + insertIndex);
//                System.out.println("startIndex"+ startIndex);
//                System.out.println("leftIndex:" + leftIndex);
//                System.out.println("rightIndex:" + rightIndex);
                
                merge(leftIndex, rightIndex, insertIndex, turnEndIndex); //倆倆排序
                leftIndex = insertIndex += newSortedUnit;
                rightIndex = leftIndex + oldSortedUnit;
                turnEndIndex+=newSortedUnit;
                turnEndIndex = (turnEndIndex>=length ? length : turnEndIndex); 
            }
            clone(arrayNew, arrayOld, insertIndex, length-roundEndIndex);
            swap();
            print("old", arrayOld);
            print("new", arrayNew);
            oldSortedUnit = newSortedUnit;
            newSortedUnit = oldSortedUnit*2; 
        } while(oldSortedUnit<length); //新的
        clone(arrayNew, arrayOld, 0, length);
    }
    
    public void merge(int leftIndex, int rightIndex, int insertIndex, int turnEndIndex){
//        System.out.println("turnEndIndex:" + turnEndIndex);
        int leftEnd = rightIndex, rightEnd = turnEndIndex;
        for(int i=insertIndex; i<turnEndIndex; i++){
            if(leftIndex == leftEnd){
                arrayNew[insertIndex++] = arrayOld[rightIndex++];
//                System.out.println("addRight:"+ arrayNew[insertIndex-1]);            
            }else if (rightIndex == rightEnd){
                arrayNew[insertIndex++] = arrayOld[leftIndex++];
//                System.out.println("addLeft:"+ arrayNew[insertIndex-1]);
            }else if(arrayOld[rightIndex] <= arrayOld[leftIndex]){
                arrayNew[insertIndex++] = arrayOld[rightIndex++];
//                System.out.println("addRight:"+ arrayNew[insertIndex-1]);
            }else if(arrayOld[leftIndex] < arrayOld[rightIndex]){
                arrayNew[insertIndex++] = arrayOld[leftIndex++];
//                System.out.println("addLeft:"+ arrayNew[insertIndex-1]);
            }
        }
    } 
    
    public void swap(){
        int[] tmp = arrayOld;
        arrayOld = arrayNew;
        arrayNew = tmp;        
    }
    
    public void clone(int[] clone, int[] array, int startIndex, int length){
        for(int i=startIndex; i<startIndex+length; i++){
            clone[i] = array[i];
        }        
    }
    
    public static void print(String arrayType, int[] intArray){
        System.out.print(arrayType + ": ");
        for(int i=0; i<intArray.length; i++){
            System.out.print(intArray[i] + (i!=intArray.length -1 ? " ": "\n" ));
//            System.out.print("\u001B[31m" + intArray[i] + (i!=end? " ": "\n" ) + "\u001B[0m");
        }
    }
    
}
