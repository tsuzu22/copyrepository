/**
 * jp.co.flm.market.test.TestCategoryDAO01
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.flm.market.entity.Category;

/**
 * getAllCategories()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestCategoryDAO01 {

    /**
     * テスト実行mainメソッドです。
     *
     * @param args
     *            コマンドライン引数
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            CategoryDAO cdao = new CategoryDAO(con);

            // 単体テスト対象メソッドを呼び出す。
            ArrayList<Category> list = cdao.returnTop();
            for (Category category : list) {
                System.out.println("カテゴリID：" + category.getCategoryId());
                System.out.println("カテゴリ名：" + category.getCategoryName());
                System.out.println("カテゴリ画像" + category.getPicture());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            // データベース接続を閉じる。
            if (con != null) {
                con.close();
            }
        }
    }
}
