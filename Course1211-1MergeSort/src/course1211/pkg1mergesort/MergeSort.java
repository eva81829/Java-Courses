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
    private int[] arrayOld;
    private int[] arrayNew;
    private int length;
    
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
            int minIndex1 = 0, minIndex2 = oldSortedUnit, insertIndex = 0, startIndex = 0;
            while(insertIndex<length){
                print("old", arrayOld);
                print("new", arrayNew);
//                System.out.println("oldSortedUnit" + oldSortedUnit);  
//                System.out.println("newSortedUnit" + newSortedUnit);  
//                System.out.println("insertIndex" + insertIndex);
//                System.out.println("startIndex"+ startIndex);
                System.out.println("minIndex1:" + minIndex1);
                System.out.print("minIndex2:" + minIndex2);
                
                if (minIndex2 == startIndex + 2 * oldSortedUnit || minIndex2 == length){ //minIndex2 == length為餘數pair的判斷
                    arrayNew[insertIndex++] = arrayOld[minIndex1++];
                    System.out.println("\taddMinIndex1:"+ arrayNew[insertIndex-1]);
                }else if(minIndex1 == startIndex + oldSortedUnit){
                    arrayNew[insertIndex++] = arrayOld[minIndex2++];
                    System.out.println("\taddMinIndex2:"+ arrayNew[insertIndex-1]);
                }else if(arrayOld[minIndex1] < arrayOld[minIndex2]){
                    arrayNew[insertIndex++] = arrayOld[minIndex1++];
                    System.out.println("\taddMinIndex1:"+ arrayNew[insertIndex-1]);
                }else if(arrayOld[minIndex2] <= arrayOld[minIndex1]){
                    arrayNew[insertIndex++] = arrayOld[minIndex2++];
                    System.out.println("\taddMinIndex2:"+ arrayNew[insertIndex-1]);
                }
                
                if((insertIndex - startIndex) == newSortedUnit){
                    int leftIndex = (length - insertIndex)/newSortedUnit;
                    if(leftIndex<1){
                        oldSortedUnit = newSortedUnit;
                        newSortedUnit = oldSortedUnit*2;
                        if(insertIndex==length){ //當最後一個數被插入時的終止條件
                            break;
                        }
                        clone(arrayOld, arrayNew, startIndex, oldSortedUnit);
                        print("clone", arrayOld);
                        minIndex2 = insertIndex; //處理餘數的部分, 重新倆倆排序
                        minIndex1 = insertIndex = startIndex;
                        continue;
                    }
                    minIndex1 = insertIndex; //重新倆倆排序
                    minIndex2 = minIndex1 + oldSortedUnit;
                    startIndex += newSortedUnit;
                }
            }       
            swap();
            print("old", arrayOld);
            print("new", arrayNew);   
        } while(newSortedUnit<=length);
        clone(arrayNew, arrayOld, 0, length);
    }
    
    public void clone(int[] clone, int[] array, int startIndex, int length){
        for(int i=startIndex; i<startIndex+length; i++){
            clone[i] = array[i];
        }        
    }    
    
    public void swap(){
        int[] tmp = arrayOld;
        arrayOld = arrayNew;
        arrayNew = tmp;        
    }
    
    public static void print(String arrayType, int[] intArray){
        System.out.print(arrayType + ": ");
        for(int i=0; i<intArray.length; i++){
            System.out.print(intArray[i] + (i!=intArray.length -1 ? " ": "\n" ));
//            System.out.print("\u001B[31m" + intArray[i] + (i!=end? " ": "\n" ) + "\u001B[0m");
        }
    }
    
}
