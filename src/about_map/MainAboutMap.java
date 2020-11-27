package about_map;

// Mapのインポート
import java.util.HashMap;
import java.util.Map;

public class MainAboutMap {

    public static void main(String[] args) {

        // ここから =====================================
        // 1 newの時にキーと値の両方を型として指定
        Map<String, String> sampleHashMap = new HashMap<String, String>();
        // 2「put」を使用して値を追加する
        sampleHashMap = new HashMap<String, String>() {
            {
                put("ニビジム", "タケシ");
                put("ハナダジム", "カスミ");
                put("クチバジム", "マチス");
            }
        };
        // ここまで =====================================

        // 3 「get」でキー値を指定して出力
        System.out.println(sampleHashMap.get("ニビジム"));
        System.out.println(sampleHashMap.get("ハナダジム"));
        System.out.println(sampleHashMap.get("クチバジム"));
        System.out.println(sampleHashMap.get("タマムシジム")); // null になる
    }
}
