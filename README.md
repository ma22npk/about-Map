# about-Map
【Java】コレクションフレームワークの Map について勉強したメモです。

<!-- ここからマップの記事================================ -->
# 【Map】キーと値とのマッピングを保持する

連想配列を取り扱うものに Map というコレクションがあります。

## Mapとは

Mapは *「キー」と「値」* の二つの要素から成り立っています。

「 *キー* は値につける名前のようなもの 」で、値ひとつひとつに「 *キー* 」が存在しており、「 *キー* 」と「 *値* 」がペアになっているのが Map の特徴です。

*キー* は一意（同じものが複数存在しない）ですが、値は同じものが複数あってもいいです。

## Map系クラスの特徴

マップはMap[インターフェース]を元に実装されていて、 *HashMap、TreMap、LinkedHashMap* の3つがよく使われます。

| Mapクラス     | 概要                                                                                                                                                                                                                                                                                                                                        | 
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | 
| HashMap       | ハッシュを使ったMapのデフォルト。 要素数によらない高速な検索ができます。<br>順序が保持されていないので目的の要素のキーを指定してそれに紐づく値を取得するのが早い                                                                                                                                                                            | 
| TreeMap       | 順序がキーの順番になっている。キーが数値の場合は小さい順に要素が保持されます。<br>キーが文字列の場合は、文字コードの順（辞書順、アルファベット順）に要素が保持される。                                                                                                                                                                      | 
| LinkedHashMap | キーの挿入順を保持する。 コンストラクタの引数の指定によって、<br>挿入順ではなくアクセス順を保持することもできます。デフォルトは挿入順です。<br>要素を追加（put）した順番に、そのままの順番で要素が保持されます。<br>または、コンストラクタの引数に順序付けモードを指定して、アクセス順（getした順番）に保持されるようにすることもできます。 | 





## Map の定義方法

Mapの初期化は以下のようにして行います。
ArrayList 等と同様の記述のしかたで書くことが出来、ダイヤモンド演算子を用いての記述も可能です。

### 基本の定義の仕方がこちらです。

```
マップインターフェース名<型> インスタンス名 = new コンストラクタ名<型>();
```
### HashMap の定義

```java
// HashMap（Mapの代わりに左辺を同じHashMapにしても可）
Map<String, Integer> hashMap = new HashMap<String, Integer>();
```
### TreeMap　の定義

```java
// TreeMap（Mapの代わりに左辺を同じTreeMapにしても可）
Map<String, Integer> treeMap = new TreeMap<String, Integer>();
```
### LinkedHashMap の定義

```java
// LinkedHashMap（Mapの代わりに左辺を同じLinkedHashMapにしても可）
Map<String, Integer> treeMap = new LinkedHashMap<String, Integer>();
```


## Map の使用例
まずはこちらのコードを御覧ください、説明はコメントアウトで記述してありますので、詳し異解説は下記に書きます。

```java
package about_map;

// Mapのインポート
import java.util.HashMap;
import java.util.Map;

public class MainAboutMap {

    public static void main(String[] args) {

        // ここから =====================================
      // 1　newの時にキーと値の両方を型として指定
        Map<String, String> sampleHashMap = new HashMap<String, String>(); 
        // 2「put」を使用して値を追加する
        sampleHashMap.put("ニビジム", "タケシ"); 
        sampleHashMap.put("ハナダジム", "カスミ");
        sampleHashMap.put("クチバジム", "マチス");
        // ここまで =====================================
			
        // 3 「get」でキー値を指定して出力
        System.out.println(sampleHashMap.get("ニビジム"));
        System.out.println(sampleHashMap.get("ハナダジム"));
        System.out.println(sampleHashMap.get("クチバジム"));
        System.out.println(sampleHashMap.get("タマムシジム")); //null になる
    }
}
```
出力結果

```
タケシ
カスミ
マチス
null
```

### 解説

こちらのコードの手順は、、

1. Mapを [インポート]する
2. [new]の時に キーと値 の両方を型として指定
3. 「 *put* 」を使用して 値 を追加する
4. 「 *get* 」で キー値 を指定して出力

といった記述をしています。

#### ① newの時にキーと値の両方を型として指定
生成したHashMapクラスの[インスタンス]をMap[インタフェース]型の変数sampleHashMapに保持。

```java
      // 1　newの時にキーと値の両方を型として指定
        Map<String, String> sampleHashMap = new HashMap<String, String>();
```

#### ② 「 put 」を使用して値を追加する
Map[インタフェース]では値の追加は「 add 」ではなく、
*「 put 」という名前のメソッドで要素の追加を行います。*

*putメソッドには引数を２つ指定します。*
第１[引数]がキー、第２[引数]がキーに紐づく値です。


```java
        // 2「put」を使用して値を追加する
        sampleHashMap.put("ニビジム", "タケシ"); 
        sampleHashMap.put("ハナダジム", "カスミ");
        sampleHashMap.put("クチバジム", "マチス");
```

#### ③ 「get」でキー値を指定して出力
*値を取り出すときは、 getメソッド を使用します。*

Map.getを使うと、Mapにputされているキー・値の対応付けの中から、キーに対応する値を取り出せます。キーがputされていない場合はnullが戻ります。

```java
        // 3 「get」でキー値を指定して出力
        System.out.println(sampleHashMap.get("ニビジム"));
        System.out.println(sampleHashMap.get("ハナダジム"));
        System.out.println(sampleHashMap.get("クチバジム"));
        System.out.println(sampleHashMap.get("タマムシジム")); //null になる

```




#### 【補足】 put の別パターン
putする時の別パターンでこちらの方法でも値の追加が可能です。
コメントアウト部分を上記のコードの部分を境に入れ替えて使用してください。
やっていることは上記のコードと同じなので、出力結果も同じです。

```java
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
```

## 参考文献・記事

- [Progate]
- [ドットインストール]
- [フレームワーク (framework)
](https://wa3.i-3-i.info/word12470.html)
- [【Java入門】ArrayListの使い方！配列との違いも解説
](https://style.potepan.com/articles/14984.html)


[Progate]:https://prog-8.com/
[ドットインストール]:https://dotinstall.com/







[インスタンス]:https://qiita.com/takahirocook/items/ec01cdcbb440cf0d1cc4
[インスタンス化]:https://qiita.com/takahirocook/items/ec01cdcbb440cf0d1cc4
[アクセス修飾子]:https://qiita.com/takahirocook/items/e51b0b9d37d95ad587fe
[フィールド]:https://qiita.com/takahirocook/items/28df75a133049a74ece1
[フィールド変数]:https://qiita.com/takahirocook/items/28df75a133049a74ece1
[new演算子]:https://qiita.com/takahirocook/items/00f9f97592bf50831d39
[new]:https://qiita.com/takahirocook/items/00f9f97592bf50831d39
[カプセル化]:https://qiita.com/takahirocook/items/e469a7c0539a0012868e
[クラス]:https://qiita.com/takahirocook/items/50cbbdca8e21539170e9
[メソッド]:https://qiita.com/takahirocook/items/5bfe43576d87a2a4006c
[mainメソッド]:https://qiita.com/takahirocook/items/f4635915337303de338c
[メソッドの呼び出し]:https://qiita.com/takahirocook/items/f4635915337303de338c
[コンストラクタ]:https://qiita.com/takahirocook/items/fa1822f2f22c3786593e
[引数]:https://qiita.com/takahirocook/items/5e5b0ba79e869f4a592e
[戻り値]:https://qiita.com/takahirocook/items/3b6fa670a1d6dd4a9386
[this]:https://qiita.com/takahirocook/items/d251ec4693c68f6b9538
[getter・setter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[setter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[getter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[オブジェクト指向]:https://qiita.com/takahirocook/items/041ba7a096b71ab8ffd4
[継承]:https://qiita.com/takahirocook/items/6c84ea66a6e2ad536a37
[オーバーライド]:https://qiita.com/takahirocook/items/09dd8e5f56d6617ce45a
[オーバーロード]:https://qiita.com/takahirocook/items/b937c3c07126fe7e02a4
[this]:https://qiita.com/takahirocook/items/d251ec4693c68f6b9538
[super]:https://qiita.com/takahirocook/items/75a07131e7e791c8442c
[スーパークラス]:https://qiita.com/takahirocook/items/75a07131e7e791c8442c
[final]:https://qiita.com/takahirocook/items/5e0916d9bf28bcf68d0c
[final修飾子]:https://qiita.com/takahirocook/items/5e0916d9bf28bcf68d0c
[定数]:https://qiita.com/takahirocook/items/5e0916d9bf28bcf68d0c
[static修飾子]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[static]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[インスタンスフィールド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[インスタンス変数]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[動的メソッド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[インスタンス変数]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[静的メソッド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[クラスメソッド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[静的メソッド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[クラスフィールド]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[クラス変数]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[静的変数]:https://qiita.com/takahirocook/items/cf527f85d17a5af86735
[インターフェイス]:https://qiita.com/takahirocook/items/ca84be8dfef664b19194
[インターフェース]:https://qiita.com/takahirocook/items/ca84be8dfef664b19194
[パッケージ]:https://qiita.com/takahirocook/items/39b58d17abcb159ef5c1
[インポート]:https://qiita.com/takahirocook/items/59a8a09cab6a98d3bca2
[import]:https://qiita.com/takahirocook/items/59a8a09cab6a98d3bca2
[配列]:https://qiita.com/takahirocook/items/16a123fb73b30869053b
[配列操作]:https://qiita.com/takahirocook/items/16a123fb73b30869053b
[List]:https://qiita.com/takahirocook/items/4d622fc6f271569783b5
[list]:https://qiita.com/takahirocook/items/4d622fc6f271569783b5
