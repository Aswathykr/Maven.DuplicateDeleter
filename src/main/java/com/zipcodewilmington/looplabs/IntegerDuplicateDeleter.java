package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);

    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] result = new Integer[]{};
        Integer[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        Integer numberOfObjectsInArray = newArray.length;
        for(int i = 0; i < newArray.length;){
            int j = i + 1;
            for(; j < newArray.length; j++){
                if(newArray[j] != newArray[i])
                    break;
            }
            if(j - i < maxNumberOfDuplications)
                result = mergeArray(result, Arrays.copyOfRange(newArray, i, j));
            i = j;
        }
        return result;
    }

    private Integer[] mergeArray(Integer[] original, Integer[] toAdd){

        Integer[] newArray = new Integer[original.length + toAdd.length];
        int idx = 0;
        for (int i = 0; i < original.length; i++, idx ++) {
            newArray[idx] = original[i];
        }
        for (int i = 0; i < toAdd.length; i++, idx++) {
            newArray[idx] = toAdd[i];
        }
        return newArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] result = new Integer[]{};
        Integer[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        for(int i = 0; i < newArray.length;){
            int j = i + 1;
            for(; j < newArray.length; j++){
                if(newArray[j] != newArray[i])
                    break;
            }
            if(j - i != exactNumberOfDuplications)
                result = mergeArray(result, Arrays.copyOfRange(newArray, i, j));
            i = j;
        }
        return result;    }
}
