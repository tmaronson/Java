
class Result {

    /*
     * Complete the 'getNumber' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST binary as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static long getNumber(SinglyLinkedListNode binary) {
    // Write your code here
        long sum =0;
        SinglyLinkedListNode node = binary;
        while(binary != null) {
            sum = (sum << 1) + (binary.data);
            binary = binary.next;
        }
        return sum;
    }

}
