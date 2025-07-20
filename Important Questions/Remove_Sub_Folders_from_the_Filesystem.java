import java.util.*;

public class Remove_Sub_Folders_from_the_Filesystem {

    // Approach 1 O(N*L^2)
    public static List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        for (String currentFolder : folder) {
            boolean isSubFolder = false;
            String tempFolder = currentFolder;

            while (!currentFolder.isEmpty()) {
                int index = currentFolder.lastIndexOf('/');

                if (index == -1) {
                    break;
                }

                currentFolder = currentFolder.substring(0, index);

                if (set.contains(currentFolder)) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                result.add(tempFolder);
            }
        }

        return result;
    }

    // Approach 2 Sorting O(n*L*logn)
    public static List<String> removeSubfolders2(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String currentFolder = folder[i];
            String lastFolder = result.get(result.size() - 1);

            lastFolder += '/';

            if (!currentFolder.startsWith(lastFolder)) {
                result.add(currentFolder);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String folder[] = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };

        System.out.println(removeSubfolders(folder));
        System.err.println(removeSubfolders(folder));
    }
}
