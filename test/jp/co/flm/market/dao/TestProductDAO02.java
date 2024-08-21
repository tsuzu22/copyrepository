/**
 * jp.co.flm.market.test.TestProductDAO02
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.flm.market.entity.Category;
import jp.co.flm.market.entity.Product;

/**
 * getProduct()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestProductDAO02 {

    /** コマンドライン引数の数 */
    private static final int ARGS_SIZE = 1;

    /**
     * テスト実行mainメソッドです。
     *
     * @param args
     *            コマンドライン引数
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // コマンドライン引数を確認する。
        if (args.length != ARGS_SIZE) {
            System.out.println("使い方: java jp.co.flm.market.test.TestProductDAO02 <商品ID>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String productId = args[i];

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            ProductDAO pdao = new ProductDAO(con);

            // 単体テスト対象メソッドを呼び出す。
            Product product = pdao.showProduct(productId);
            Category category = product.getCategory();
            System.out.println("商品ID：" + product.getProductId());
            System.out.println("カテゴリID：" + category.getCategoryId());
            System.out.println("商品名：" + product.getProductName());
            System.out.println("単価：" + product.getPrice());
            System.out.println("商品イメージ・ファイル：" + product.getPicture());
            System.out.println("ポイント：" + product.getPoint());
            System.out.println("カテゴリ名：" + category.getCategoryName());
            System.out.println("在庫数：" + product.getStock().getQuantity());
            System.out.println();
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
