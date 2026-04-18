package test;

public class UC20SearchValidation {

    // 🔹 Search with validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ❌ Fail-fast check
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // 🔹 Linear search after validation
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogies = {"BG101","BG205","BG309"};

        String key = "BG205";

        boolean found = searchBogie(bogies, key);

        if (found) {
            System.out.println("Bogie Found: " + key);
        } else {
            System.out.println("Bogie Not Found");
        }
    }
}