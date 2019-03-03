package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] result = new String[]{};
        String[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        for(int i = 0; i < newArray.length;){
            int j = i + 1;
            for(; j < newArray.length; j++){
                if(!newArray[j].equals(newArray[i]))
                    break;
            }
            if(j - i < maxNumberOfDuplications)
                result = mergeArray(result, Arrays.copyOfRange(newArray, i, j));
            i = j;
        }
        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] result = new String[]{};
        String[] newArray = Arrays.copyOf(array, array.length);
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
        return result;
    }

    private String[] mergeArray(String[] original, String[] toAdd){

        String[] newArray = new String[original.length + toAdd.length];
        int idx = 0;
        for (int i = 0; i < original.length; i++, idx ++) {
            newArray[idx] = original[i];
        }
        for (int i = 0; i < toAdd.length; i++, idx++) {
            newArray[idx] = toAdd[i];
        }
        return newArray;
    }
}
