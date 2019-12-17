package org.gerry.suanfa;

public class Array {
    private int[] array = null;
    private int count ;

    public static void main(String[] args){
        Array testArray = new Array(5);
//        testArray.insertLast(1);
//        testArray.insertLast(2);
//        testArray.insertLast(3);
//        testArray.insertLast(4);
//        testArray.insertLast(5);
        testArray.insertIndex(1,7);
        testArray.printArray();
    }

    public Array(int size){
        array = new int[size];
        count = 0;
    }

    public void insertIndex(int index , int value){
        if(index <0 || index >array.length){
         return;
        }
        if(index >count){
            array[index-1] = value;
            return ;
        }else{
            for(int temp = count;temp>index;temp--){
                array[temp-1] = array[temp-2];
            }

            array[index-1] = value;
        }

    }

    public void insertHead(int value){
        if(count>0){
            for(int temp = count;temp>1;temp--){
                array[temp-1] = array[temp-2];
            }
        }
        array[0] = value;
        count++;
    }

    public void insertLast(int value){
        array[count] = value;
        count++;
    }

    public void printArray(){
        for(int temp = 0 ;temp <array.length; temp++){
            System.out.println(" Array site :"+(temp+1)+" value :"+array[temp]);
        }
    }
}
