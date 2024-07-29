public class test_binary {
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==target){ //중간 값이 목표 값과 같을 때
                return mid;
            }
            else if(arr[mid]<target){ //중간 값이 목표 값보다 작을 때
                left=mid+1;
            }
            else{ //중간 값이 목표 값보다 클 때
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;
        System.out.println(binarySearch(arr, target));
    }
}

