package pva6;

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

  public static Pair binarySearch(int[] arr, int l, int r, int x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;

      // If the element is present at the
      // middle itself
      if (arr[mid] == x) {
        int i = 1;
        int lower = mid;
        int higher = mid;
        while ((mid - i) >= 0){
          if (arr[mid-i] == x){
            lower = mid-i;
            i++;
          } else {
            break;
          }
        }
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

      // If element is smaller than mid, then
      // it can only be present in left subarray
      if (arr[mid] > x) {
        return binarySearch(arr, l, mid - 1, x);
      }

      // Else the element can only be present
      // in right subarray
      return binarySearch(arr, mid + 1, r, x);
    }

    // We reach here when element is not present
    // in array
    return null;
  }
}
