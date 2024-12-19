public class Max_Chunks_to_Make_Sorted {

    public static int maxChunksToSorted(int arr[]) {
        int chunks = 0;
        int prefixMax[] = new int[arr.length];
        prefixMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        int suffixMin[] = new int[arr.length];
        suffixMin[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int pehlaKaMax = i > 0 ? prefixMax[i - 1] : -1;
            int baadKaMin = suffixMin[i];
            if (pehlaKaMax < baadKaMin) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 0, 2, 3, 4 };

        System.out.println(maxChunksToSorted(arr));
    }
}
