package pva6.binSearch;

public class BinSearch {

  /**
   * Findet für einen aufsteigend geordneten Array zu einer Zahl value den kleinsten und den
   * grössten Index.
   *
   * @param array
   * @param value
   * @return Ein Paar mit kleinstem und grösstem Index oder null, wenn der gegebene Wert im array
   * nicht vorkommt.
   */
  public static Pair search(int[] array, int value) {
    // TODO
    return binarySearch(array, 0, array.length - 1, value);
  }

  // search function with the beginning and end of subarray to be searched.
  // allows for easy recursion
  public static Pair binarySearch(int[] arr, int l, int r, int x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;

      // if the element is found.
      // searching if there are multiple occurrences of it.
      if (arr[mid] == x) {
        int i = 1;
        int lower = mid;
        int higher = mid;
        // search array for occurrences of x that are below the previous found ones
        while ((mid - i) >= 0){
          if (arr[mid-i] == x){
            lower = mid-i;
            i++;
          } else {
            break;
          }
        }
        // search array for occurrences of x that are above the previous found ones
        i = 1;
        while ((mid + i) < arr.length){
          if (arr[mid+i] == x){
            higher = mid+i;
            i++;
          } else {
            break;
          }
        }
        return new Pair(lower, higher);
      }

      // If element is smaller than mid, then it can only be present in left subarray
      if (arr[mid] > x) {
        return binarySearch(arr, l, mid - 1, x);
      }

      // Else the element can only be present in right subarray
      return binarySearch(arr, mid + 1, r, x);
    }

    // return null if element is not present in the array
    return null;
  }
}
