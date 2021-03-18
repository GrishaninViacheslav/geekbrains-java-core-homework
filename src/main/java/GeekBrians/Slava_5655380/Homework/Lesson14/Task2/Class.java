package GeekBrians.Slava_5655380.Homework.Lesson14.Task2;

public class Class {
    public static boolean method(int arr[]){
        boolean containsValueOne = false;
        boolean containsValueFour = false;
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == 1)
                containsValueOne = true;
            else if(arr[i] == 4)
                containsValueFour = true;
            else
                return false;
        return containsValueOne && containsValueFour;
    }
}
