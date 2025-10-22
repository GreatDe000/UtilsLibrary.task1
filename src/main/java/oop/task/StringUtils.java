package oop.task;

public class StringUtils {

    public static String[] split(String text, String delimiter) {
        if (text == null || delimiter == null || delimiter.isEmpty()) {
            return new String[]{text};
        }

        int partsCount = 1;
        for (int i = 0; i <= text.length() - delimiter.length(); i++) {
            if (equalsSubstring(text, i, delimiter)) {
                partsCount++;
            }
        }

        String[] result = new String[partsCount];
        int index = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length();) {
            if (i <= text.length() - delimiter.length() && equalsSubstring(text, i, delimiter)) {
                result[index++] = current.toString();
                current.setLength(0);
                i += delimiter.length();
            } else {
                current.append(text.charAt(i));
                i++;
            }
        }
        result[index] = current.toString();
        return result;
    }

    public static String join(String[] parts, String delimiter) {
        if (parts == null || parts.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) sb.append(delimiter);
        }
        return sb.toString();
    }

    public static String replace(String text, String oldPart, String newPart) {
        if (text == null || oldPart == null || oldPart.isEmpty()) return text;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length();) {
            if (i <= text.length() - oldPart.length() && equalsSubstring(text, i, oldPart)) {
                result.append(newPart);
                i += oldPart.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            char ca = toLower(a.charAt(i));
            char cb = toLower(b.charAt(i));
            if (ca != cb) return false;
        }
        return true;
    }

    public static int indexOf(String text, String sub) {
        if (text == null || sub == null) return -1;
        if (sub.isEmpty()) return 0;

        for (int i = 0; i <= text.length() - sub.length(); i++) {
            if (equalsSubstring(text, i, sub)) return i;
        }
        return -1;
    }

    public static String format(String template, Object... args) {
        if (template == null) return null;
        StringBuilder result = new StringBuilder();
        int argIndex = 0;

        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            if (c == '%' && i + 1 < template.length() && template.charAt(i + 1) == 's' && argIndex < args.length) {
                result.append(args[argIndex++]);
                i++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String reverse(String text) {
        if (text == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    private static boolean equalsSubstring(String text, int start, String sub) {
        for (int j = 0; j < sub.length(); j++) {
            if (text.charAt(start + j) != sub.charAt(j)) return false;
        }
        return true;
    }

    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }
}
